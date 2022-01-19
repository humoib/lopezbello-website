package com.tgd.things;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

@Lazy
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2-console/**").permitAll();

		// https://dzone.com/articles/add-login-to-your-spring-boot-app-in-10-mins

		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

		// the boolean flags force the redirection even though
		// the user requested a specific secured resource.
		// http.formLogin().defaultSuccessUrl(ThingsAppProperties.getContext() +
		// "/index", true);

		http.httpBasic().and().authorizeRequests()
				.antMatchers("/", "/home", "/signup", "/resources/**", "/admin/h2-console/**", "/monitoring/**",
						"/css/**", "/js/**")
				.permitAll().anyRequest().authenticated().and().formLogin()
				// .loginPage("/login.html")
				.loginProcessingUrl("/login").defaultSuccessUrl("/index", true)
				// .loginPage("/login")
				// .successHandler(new AuthenticationSuccessHandler() {
				// @Override
				// public void onAuthenticationSuccess(HttpServletRequest request,
				// HttpServletResponse response,
				// Authentication authentication) throws IOException, ServletException {
				// redirectStrategy.sendRedirect(request, response,
				// ThingsAppProperties.getContext() + "/");
				// }
				// })
				.permitAll().and().logout().permitAll(); // .and().antMatcher("/admin/h2-console/**");

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder().username("user").password("password").
	 * roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

}
