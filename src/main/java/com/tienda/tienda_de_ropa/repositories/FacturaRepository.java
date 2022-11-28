package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
