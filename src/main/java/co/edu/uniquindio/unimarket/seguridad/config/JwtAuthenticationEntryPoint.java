package co.edu.uniquindio.unimarket.seguridad.config;

import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        MensajeDTO<String> dto = new MensajeDTO<>(HttpStatus.UNAUTHORIZED, true, "Token no encontrado o invalido");
                response.setContentType("application/json");
        response.setStatus(dto.getEstado().value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(dto));
        response.getWriter().flush();
        response.getWriter().close();
    }
}