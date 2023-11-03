package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class MySecurityConfig {

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
				.requestMatchers("/").permitAll() // URL racine accessible par tout le monde
				.requestMatchers("/avengers/assemble").hasRole("CHAMPION") // Pour cette route précise.
				// .requestMatchers("/avengers/**").hasRole("CHAMPION") // Pour tout ce qui commence par /avengers/..
				.requestMatchers("/secret-bases").hasRole("DIRECTEUR")

			)
			.formLogin(withDefaults()); // Configuration de la page de connexion
			return http.build();
		}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user = User
			.withUsername("Steve")
			.password(encoder.encode("motdepasse"))
			.roles("CHAMPION")
			.build();

		UserDetails admin = User
			.withUsername("Nick")
			.password(encoder.encode("flerken"))
			.roles("DIRECTEUR")
			.build();

		return new InMemoryUserDetailsManager(List.of(user, admin));
	}

}