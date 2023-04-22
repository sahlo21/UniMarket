package co.edu.uniquindio.unimarket.seguridad.config;
import co.edu.uniquindio.unimarket.seguridad.servicios.JwtService;
import co.edu.uniquindio.unimarket.seguridad.servicios.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain
            chain) throws ServletException, IOException {
        String token = getToken(req);
        try {
            if(token!=null) {
                String username = jwtService.extractUsername(token);
                if (username != null) {
                    UserDetails userDetails =
                            userDetailsServiceImpl.loadUserByUsername(username);

                    if (jwtService.isTokenValid(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails.getUsername(),
                                        null,
                                        userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    }
                }
            }
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        chain.doFilter(req, res);
    }
    private String getToken(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer "))
            return header.replace("Bearer ", "");
        return null;
    }
}
