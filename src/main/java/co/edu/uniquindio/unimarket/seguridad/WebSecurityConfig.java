package co.edu.uniquindio.unimarket.seguridad;

import co.edu.uniquindio.unimarket.seguridad.config.JwtAuthenticationEntryPoint;
import co.edu.uniquindio.unimarket.seguridad.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.authorizeHttpRequests().anyRequest().permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/usuario/crear/**",
                "/api/usuario/actualizar/**",
                "/api/usuario/eliminar/**",
                "/api/usuario/obtener/**",
                "/api/usuario/cambiarContraseniaAnterior/**",
                "/api/usuario/cambiarContrasenaRecuperada/**",
                "/api/usuario/recuperarContrasena/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/detalleCompra/crear/**",
                "/api/detalleCompra/actualizarUnidades/**",
                "/api/detalleCompra/listarDetalleCompra/**",
                "/api/detalleCompra/obtener/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/cupon/crear/**",
                "/api/cupon/listarCupones/**",
                "/api/cupon/obtenerCompra/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/compra/crear/**",
                "/api/compra/listarComprasUsuario/**",
                "/api/compra/obtenerCompra/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/comentario/crear/**",
                "/api/comentario/listar/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("/api/calificacion/crear/**",
                "/api/calificacion/listarCalificacion/**",
                "/api/calificacion/promediarCalificaciones/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("api/producto/crear/**",
                "api/producto/actualizar/**",
                "api/producto/eliminar/**",
                "api/producto/obtener/**",
                "api/producto/listarProductoUsuario/**",
                "api/producto/listarProductosCategoria/**",
                "api/producto/listarProductosEstado/**",
                "api/producto/listarProductosFavoritos/**",
                "api/producto/listarProductosPrecio/**",
                "api/producto/listarProductosNombre/**",
                "api/producto/guardarFavorito/**",
                "api/producto/eliminarFavorito/**"
                ).hasAuthority("CLIENTE");
        http.authorizeHttpRequests().requestMatchers("api/imagines/upload/**",
                "api/producto/eliminar/**"
                ).permitAll();
        http.authorizeHttpRequests().requestMatchers("api/moderador/listarProducto/**",
                "api/moderador/revisarProducto/**"
                ).hasAuthority("MODERADOR");
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
