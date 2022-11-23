package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository <Contacto, Long> {
}
