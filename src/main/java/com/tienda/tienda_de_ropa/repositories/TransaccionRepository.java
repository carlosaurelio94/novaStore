package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long>{

}
