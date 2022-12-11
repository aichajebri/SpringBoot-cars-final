package com.aisha.cars.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 @Override
 protected void configure(HttpSecurity http) throws Exception { 
http.csrf().disable();
 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
//consulter tous les Cars
 
http.authorizeRequests().antMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER");
http.authorizeRequests().antMatchers("/api/grp/**").hasAnyAuthority("ADMIN","USER");

//consulter par son id
http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("ADMIN","USER");
http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/grp/**").hasAnyAuthority("ADMIN","USER");

//ajouter
http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADMIN");
http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/grp/**").hasAuthority("ADMIN");

//modifier
http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("ADMIN");
//http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/grp/**").hasAuthority("ADMIN");

//supprimer
http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN");
//http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/grp/**").hasAuthority("ADMIN");

http.authorizeRequests().anyRequest().authenticated();
http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
 
 } 
}