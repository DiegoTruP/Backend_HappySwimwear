package io.HappySwimwear.Filtro;

import io.HappySwimwear.Servicio.MyUserDetailsService;
import io.HappySwimwear.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    private MyUserDetailsService usuarioDetallesServicio;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtiene la token jwt completa con toodo y Bearer. ¿si le ponemos otro nombre al header igual funciona
        final String headerAutorizacion = request.getHeader("Authorization");

        String correoUsuario = null;//como iniciamos sesion con correo la token se genera a partir del correo y contraseña no del nombre y contraseña
        String jwtToken = null; //para guardar el token sin el "Bearer "

        if(headerAutorizacion != null && headerAutorizacion.startsWith("Bearer ")){// el espacio despues de Beare se debe dejar no es un error
            jwtToken = headerAutorizacion.substring(7); //quita los primeros 7 caracterers bearer y guarda la token
            correoUsuario = jwtUtil.extractUsername(jwtToken);
        }

        if(correoUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails usuarioDetalles = this.usuarioDetallesServicio.loadUserByUsername(correoUsuario);
            if(jwtUtil.validateToken(jwtToken, usuarioDetalles)){
                UsernamePasswordAuthenticationToken verificadorPasswordToken = new UsernamePasswordAuthenticationToken(usuarioDetalles, null, usuarioDetalles.getAuthorities());
                verificadorPasswordToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(verificadorPasswordToken);
            }
        }
        filterChain.doFilter(request, response);

    }
}
