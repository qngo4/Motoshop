package com.motoshop.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   PasswordEncoder passwordEncoder;

   @Bean
   public PasswordEncoder passWordEndCoder() {
	   return new BCryptPasswordEncoder();
   }
   
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
       .passwordEncoder(passwordEncoder)
       .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
       .and()
       .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests() .antMatchers("/login") .permitAll()
		 * .antMatchers("/**") .hasAnyRole("ADMIN", "USER") .and() .formLogin()
		 * .loginPage("/username") .defaultSuccessUrl("/home")
		 * .failureUrl("/login?error=true") .permitAll() .and() .logout()
		 * .logoutSuccessUrl("/login?logout=true") .invalidateHttpSession(true)
		 * .permitAll() .and() .csrf() .disable();
		 */
		http
				// HTTP Basic authentication
				.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/user/**").permitAll()
				.antMatchers(HttpMethod.POST, "/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/user/**").hasRole("ADMIN")
				.and()
				.csrf().disable()
				.formLogin().disable();
   }
}
