package bdbt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService UserDetailsService() {
    	UserDetails admin = User
    			.withUsername("admin")
    			.password("{noop}admin")
    			.roles("ADMIN")
    			.build();
    	UserDetails user = User
    			.withUsername("user")
    			.password("{noop}user")
    			.roles("USER")
    			.build();
    	return new InMemoryUserDetailsManager(admin, user);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/adminPanel","/employees", "/addEmployee","/editEmployee", "/deleteEmployee", "/airplanes","/addAirplane","/editAirplane", "/deleteAirplane", "/flights", "/addFlight", "/editFlight", "/deleteFlight", "/tickets", "/addTicket", "/editTicket", "/deleteTicket").hasRole("ADMIN")
        .antMatchers("/userPanel","/userFlight","/userTickets").hasRole("USER")
        .antMatchers("/login", "/css/**", "/js/**","/fonts/**", "/images/**", "/vendor/**", "/")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .permitAll()
        .and().formLogin().failureUrl("/403")
        .defaultSuccessUrl("/loginSuccess")
        .and().logout().logoutSuccessUrl("/")
        .permitAll();
          
    }
    
    
    
}