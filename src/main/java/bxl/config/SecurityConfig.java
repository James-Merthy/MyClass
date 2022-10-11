package bxl.config;

import bxl.filters.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true, // acces à @PreAuthorize et @PostAuthorize
        securedEnabled = true, // acces à @Secured
        jsr250Enabled = true // acces à @RolesAllowed
)
public class SecurityConfig/* extends WebSecurityConfigurerAdapter  (deprecié depuis 5.7.0) */ {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter authFilter) throws Exception {

        http.csrf().disable();
        http.httpBasic().disable();
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/*", "/*/all").hasAnyRole("PROF", "ADMIN")
                .antMatchers("/eleve/all").permitAll()
                .antMatchers("/local/all").permitAll()
                .antMatchers("/lecon/all").permitAll()
                .antMatchers("/prof/all").hasAnyRole("PROF", "ADMIN")
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .antMatchers("/api/user/**").permitAll()
                .anyRequest().permitAll();
        return http.build();

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}