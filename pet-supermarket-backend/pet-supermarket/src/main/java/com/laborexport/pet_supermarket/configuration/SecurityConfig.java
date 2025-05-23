package com.laborexport.pet_supermarket.configuration;

import com.laborexport.pet_supermarket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> corsFilter())
                .authorizeHttpRequests(
                        config->config
                                // Public endpoints
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/swagger-ui/index.html/**", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/users/{userId}/**").hasAnyRole("CUSTOMER", "ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/orders/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/orders/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasAnyRole("CUSTOMER", "ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/order-products/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/order-products/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/order-products/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/order-products/**").hasAnyRole("CUSTOMER", "ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/discounts/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/manufacturers/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/pets/**").hasAnyRole("CUSTOMER", "ADMIN")


                                .requestMatchers(HttpMethod.PUT, "/api/users/{userId}/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.POST, "api/images/**").hasAnyRole("CUSTOMER", "ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/users/{userId}/update-avatar").hasAnyRole("CUSTOMER", "ADMIN")


                                // Admin and Manager endpoints
                                .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/pets/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/pets/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/pets/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/images/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/images/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/images/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/manufacturers/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/manufacturers/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/manufacturers/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/discounts/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/discounts/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/discounts/**").hasRole("ADMIN")



                                // Default policy
                                .anyRequest().denyAll()
                )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }



}
