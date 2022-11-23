package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
