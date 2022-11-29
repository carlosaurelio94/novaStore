package com.tienda.tienda_de_ropa.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@EnableWebSecurity
@Configuration
public class AutorizacionWeb extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/admin/**").hasAuthority("ADMIN")
                //.antMatchers("/h2-console/**").hasAuthority("ADMIN")
                //.antMatchers("/rest/**").hasAuthority("ADMIN")
                //.antMatchers(HttpMethod.GET, "/api/clients").hasAuthority("ADMIN")
                .antMatchers("/web/index.html", "/web/assets/**", "/api/login", "/api/clientes").permitAll();
                //.antMatchers(HttpMethod.POST , "/api/accounts").hasAuthority("CLIENT")
                //.antMatchers("/web/account.html","/web/accounts.html","/web/cards.html", "/web/createCard.html", "/web/profile.html", "/web/settings.html").hasAuthority("CLIENT")
                //.antMatchers(HttpMethod.POST , "/api/clientes").permitAll();
        http.formLogin()
                .usernameParameter("correo")
                .passwordParameter("clave")
                .loginPage("/api/login");
        http.logout().logoutUrl("/api/logout").deleteCookies("JSESSIONID");
        // turn off checking for CSRF tokens
        http.csrf().disable();
        //disabling frameOptions so h2-console can be accessed
        http.headers().frameOptions().disable();
        // if user is not authenticated, just send an authentication failure response
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));
        // if login is successful, just clear the flags asking for authentication
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));
        // if login fails, just send an authentication failure response
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));
        // if logout is successful, just send a success response
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
