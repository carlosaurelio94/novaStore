package com.tienda.tienda_de_ropa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteProductoRepository extends JpaRepository<TicketCompraProducto, Long> {
}
