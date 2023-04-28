package com.project.todo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        (auth) -> {
//                            auth.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER");
//                            auth.requestMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole("ADMIN", "USER");
//                            auth.requestMatchers(HttpMethod.GET, "/api/**").permitAll();
                            auth.anyRequest().authenticated();
                        }
                ).httpBasic(
                        Customizer.withDefaults()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }



//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails hemant =
//                User
//                .builder()
//                .username("hemant")
//                .password(passwordEncoder().encode("12345"))
//                .roles("USER").build();
//        UserDetails admin =
//                User
//                        .builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("1234"))
//                        .roles("ADMIN")
//                        .build();
//        return new InMemoryUserDetailsManager(hemant, admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
