package com.springAndJava.twitterClone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{ // revize edilecek!!!
       return   httpSecurity.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth-> {
                   auth.requestMatchers("/welcome/**").permitAll();
                   auth.requestMatchers("/auth/**").permitAll();
                   auth.requestMatchers("/tweet/**", "/comment/**" ,
                                   "/like/**" , "/dislike/**", "/retweet/**")
                           .hasRole("USER");
                   auth.anyRequest().authenticated();
               })
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults())
               .build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
}
