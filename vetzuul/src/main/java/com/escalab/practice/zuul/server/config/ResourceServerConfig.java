package com.escalab.practice.zuul.server.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * The Class ResourceServerConfig.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/vet-uaa/oauth/**").permitAll()
				.antMatchers(HttpMethod.GET, "/owners/find-owner/{rut}", "/pets/find-pet-name/{name}", "/pets/find-pet/{rut}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/pets/find-pet-name/{name}", "/pets/find-pet/{rut}", "/pets/get-weight/{petId}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.POST, "/owners/new-owner", "/owners/update-owner").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/pets/new-pet", "/pets/update-pet", "/pets/add-weight").hasRole("ADMIN").anyRequest()
				.authenticated().and().cors().configurationSource(corsConfigurationSource()).and().csrf().disable();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("GET","HEADER","OPTIONS","POST","PUT","PATCH", "DELETE"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
