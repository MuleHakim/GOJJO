package com.Gojjo.house.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo){
       return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
        };
   }

//    @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http
//                     .authorizeRequests()
//                     .antMatchers().hasRole("USER")
//                     .antMatchers("/", "/**").permitAll()
//                     // .antMatchers("/index", "/login").hasRole("USER")
//                     // .antMatchers("/","/**").denyAll()
//                     .and()
//                     .formLogin()
//                         .loginPage("/login")
//                         .defaultSuccessUrl("/contact")
//                     .and()
//                     .logout()
//                         .logoutSuccessUrl("/login")
//                     .and()
//                     .build();
//     }

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                    .authorizeRequests()
                    .antMatchers("/profile", "/UserList", "/postList","/comment").hasRole("USER")
                    .antMatchers("/", "/**").permitAll()
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/index")
                    .and()
                    .logout()
                        .logoutSuccessUrl("/index")
                    .and()
                    .build();
    }
}
