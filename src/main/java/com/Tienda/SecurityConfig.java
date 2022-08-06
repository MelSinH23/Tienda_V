package com.Tienda;

import com.Tienda.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired    
            UsuarioDetailsServiceImpl userDetailsService;
// método para hacer autenticación de usuario    
    @Override    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()//                .withUser("admin")//                    .password("{noop}123")//                    .roles("ADMIN", "VENDEDOR", "USER")//                .and()//                .withUser("vendedor")//                    .password("{noop}123")//                    .roles("VENDEDOR", "USER")//                .and()//                .withUser("user")//                    .password("{noop}123")//                    .roles("USER");        auth.userDetailsService(userDetailsService);
    }
    //El siguiente método funciona para realizar la autorización de accesos    
        @Override    
        protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo", "/articulo/guardar",
                        "/articulo/modificar/**", "/articulo/eliminar/**",
                        "/categoria/nuevo", "/categoria/guardar",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        "/cliente/nuevo", "/cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado", "/cliente/listado",
                        "/categoria/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .antMatchers("/")
                .hasAnyRole("ADMIN", "VENDEDOR", "USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}