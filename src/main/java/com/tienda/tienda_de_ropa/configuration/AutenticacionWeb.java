package com.tienda.tienda_de_ropa.configuration;

import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AutenticacionWeb extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email -> {
            Cliente cliente = clienteRepository.findByCorreo(email);
            if (cliente != null) {
                if (cliente.getCorreo().contains("@admin")) {
                    return new User(cliente.getCorreo(), cliente.getClave(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                } else {
                    return new User(cliente.getCorreo(), cliente.getClave(),
                            AuthorityUtils.createAuthorityList("CLIENT"));
                }
            } else {
                throw new UsernameNotFoundException("Unknown client: " + email);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
