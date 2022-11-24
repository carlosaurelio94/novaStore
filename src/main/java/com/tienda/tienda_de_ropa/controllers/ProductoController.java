package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.models.ProductoTalle;
import com.tienda.tienda_de_ropa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/producto")
    public ResponseEntity<?> crearNuevoProducto(
            @RequestParam String nombre,
            @RequestParam int stock,
            @RequestParam double precio,
            @RequestParam ProductoTalle talle
            ) {
        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Nombre", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("El stock no puede ser igual o menor a cero", HttpStatus.FORBIDDEN);
        }
        if (precio <= 0) {
            return new ResponseEntity<>("El precio del producto no puede ser igual o menor a cero", HttpStatus.FORBIDDEN);
        }
        
    }
}
