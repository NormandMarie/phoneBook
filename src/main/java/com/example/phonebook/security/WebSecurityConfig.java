package com.example.phonebook.security;

import com.example.phonebook.service.UserDetailsServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    UserDetailsServiceImpl CustomUserDetailservice;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(CustomUserDetailservice);
        return provider;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(resquets -> {
                    resquets

                            .requestMatchers("/").permitAll()
                            .requestMatchers("/register").permitAll()
                            .requestMatchers("/users/**").permitAll()
                            .anyRequest().authenticated();

                })

                .formLogin(form ->{
                    form
                            .loginPage("/login")
                            .usernameParameter("name")
                            .passwordParameter("password")
                            .permitAll()

                            .defaultSuccessUrl("/auth/profil");
                })
                .logout(logout ->{
                    logout.logoutUrl("/logout")
                            .permitAll();
                })
               .build();
    }
}
