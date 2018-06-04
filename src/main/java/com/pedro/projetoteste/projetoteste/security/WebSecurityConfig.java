package com.pedro.projetoteste.projetoteste.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll() //Acesso autorizado a todos
		.anyRequest().authenticated() //Qualquer outra requisicao, precisa estar autenticado.
		.and().formLogin().permitAll() //Acesso a pagina de login
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //Caso digite logout, ele desloga.
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() //Autenticacao em memoria
		.withUser("exemplo").password("123").roles("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/style/**"); //Para o spring nao bloquear as paginas estaticas (css...)
	}
}
