package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
}
