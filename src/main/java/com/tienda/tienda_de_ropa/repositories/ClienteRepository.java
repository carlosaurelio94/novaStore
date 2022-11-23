package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreo(String correo);
}
