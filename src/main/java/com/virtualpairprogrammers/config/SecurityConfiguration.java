package com.virtualpairprogrammers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("production")
public class SecurityConfiguration {

	// Authentication
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("rac").password("secret").roles("USER", "ADMIN");
	}

	// Autherization

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic();
		}
	}

	@Configuration
	@Order(100)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/website/**").authorizeRequests().anyRequest().hasRole("USER")

					.and()

					.formLogin().loginPage("/website/login.jsp").failureUrl("/website/login.jsp?error=1").loginProcessingUrl("/website/login")
					.permitAll().and().logout().logoutSuccessUrl("/website/vehicles/list.html");

		}
	}

}
