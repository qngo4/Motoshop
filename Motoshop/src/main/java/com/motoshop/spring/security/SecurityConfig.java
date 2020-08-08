package com.motoshop.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.motoshop.spring.service.MotoUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passWordEndCoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new MotoUserDetailsService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder);
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// HTTP Basic authentication
		http
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
