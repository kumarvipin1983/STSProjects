package com.photoapp.api.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private Environment env;

	@Autowired
	public WebSecurity(Environment env) {
		this.env = env;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(env.getProperty("gateway.ip"));
		// http.authorizeRequests().antMatchers("/login").permitAll();
		// http.authorizeRequests().antMatchers("/users/**").hasIpAddress(env.getProperty("gateway.ip"));
		// http.authorizeRequests().antMatchers("/**").hasIpAddress("192.168.1.9").anyRequest().authenticated();
		http.authorizeHttpRequests().antMatchers("/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
