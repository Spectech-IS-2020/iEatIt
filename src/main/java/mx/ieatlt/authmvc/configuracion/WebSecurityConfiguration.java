package mx.ieatlt.authmvc.configuracion;

import mx.ieatlt.authmvc.modelo.Role;
import mx.ieatlt.authmvc.servicio.implementacion.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/registrar").permitAll()
//                .antMatchers("/cliente/**").hasRole(Role.CLIENTE.toString())
//                .antMatchers("/administrador/**").hasRole(Role.ADMINISTRADOR.toString())
//                .antMatchers("/repartidor/**").hasRole(Role.REPARTIDOR.toString())
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().successHandler(myAuthenticationSuccessHandler())
                .and()
                .logout().permitAll().logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationHandler();
    }
}