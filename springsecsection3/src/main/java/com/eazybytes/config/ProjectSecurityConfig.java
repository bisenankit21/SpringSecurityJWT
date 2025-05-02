package com.eazybytes.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

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

    //Below code is to store the user details in memory
    @Bean
    public UserDetailsService userDetailsService() {
       UserDetails user = User.withUsername("user").password("{noop}user").authorities("read").build();

       //if we not write {bcrypt} then the password will be stored in by default format i.e., in Bcyrpt only. but better to write it for more readability
       UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$12$PuhBjWYvyzw/4fuBz.Ik.eYD8vbOKMn5iaHLIQbEuP83QeveI.lHC").authorities("admin").build();
       return new InMemoryUserDetailsManager(user,admin);

    }

    //This below code is to encode the password in Bcrypt format(Default password encoder) and store in memory in the form of encoded password.
    //so that we dont need to store the password in plain text and no need to write {noop} in above code.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //can write below code also
        // return BcryptPasswordEncoder();   but not recommended
    }

   /* @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }*/
}
