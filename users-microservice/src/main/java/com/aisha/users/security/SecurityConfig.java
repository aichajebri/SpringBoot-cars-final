package com.aisha.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aisha.users.security.JWTAuthorizationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 	@Autowired
 	UserDetailsService userDetailsService;
 	
 	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	
    }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	  http.sessionManagement().
	  			sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http.authorizeRequests().antMatchers("/login").permitAll();  
	  http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN");
	  http.authorizeRequests().antMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER");
	  http.authorizeRequests().antMatchers("/api/grp/**").hasAnyAuthority("ADMIN","USER");
	  //consulter par son id
	  http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("ADMIN","USER");
	  http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/grp/**").hasAnyAuthority("ADMIN","USER");
	  
	  //ajouter
	  http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADMIN");
	 // http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/grp/**").hasAuthority("ADMIN");
	  
	  //modifier
	  http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("ADMIN");
	 // http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/grp/**").hasAuthority("ADMIN");
	  //supprimer
	  http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN");
	 // http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/grp/**").hasAuthority("ADMIN");
	  
	  http.authorizeRequests().anyRequest().authenticated();
	  http.addFilter(new  JWTAuthenticationFilter (authenticationManager())) ;
	  http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

		 
  }

}
