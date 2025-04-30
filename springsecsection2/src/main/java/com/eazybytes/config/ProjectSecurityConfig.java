package com.eazybytes.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    //this below method we took from the SpringbootWebSecurityConfiguration class of spring security.
    //this class is responsible for the security configuration for all the endpoints.

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
      //  http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
       // http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());--> this will allow all the requests.
        //http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());--> this will deny all the requests.
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount",
                "/myBalance","/myCards","/myLoans").authenticated()
                .requestMatchers("/notices","/contact","/error").permitAll());

//        http.formLogin(flc->flc.disable());   //we have disable to login page here using this way.
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
