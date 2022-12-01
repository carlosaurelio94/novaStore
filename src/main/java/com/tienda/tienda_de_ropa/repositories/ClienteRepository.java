package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreo(String correo);

    @Query("UPDATE Cliente c SET c.habilitado = true WHERE c.id = ?1")
    @Modifying
    void habilitar(Long id);

    @Query("SELECT c FROM Cliente c WHERE c.token = ?1")
    Cliente findByToken(String token);

}
