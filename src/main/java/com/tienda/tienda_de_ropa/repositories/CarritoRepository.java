package com.tienda.tienda_de_ropa.repositories;

import com.tienda.tienda_de_ropa.models.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

=======
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
>>>>>>> 8be4ddfe729bb561ae3b0d4afcbd93400b5279c8
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
}
