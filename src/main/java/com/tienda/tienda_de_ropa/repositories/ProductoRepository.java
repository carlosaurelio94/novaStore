package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public Producto findByNombre(String nombre);
}
