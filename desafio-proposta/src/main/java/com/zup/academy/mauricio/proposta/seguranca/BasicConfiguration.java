package com.zup.academy.mauricio.proposta.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.authorizeRequests(
						authorizeRequests -> authorizeRequests.antMatchers(HttpMethod.GET, "/api/propostas/**")
								.hasAuthority("SCOPE_propostas:read").antMatchers(HttpMethod.GET, "/api/cartoes/**")
								.hasAuthority("SCOPE_cartoes:read").antMatchers(HttpMethod.POST, "/api/cartoes/**")
								.hasAuthority("SCOPE_cartoes:write").antMatchers(HttpMethod.POST, "/api/propostas/**")
								.hasAuthority("SCOPE_propostas:write").anyRequest().hasAnyAuthority())
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

	}
}
