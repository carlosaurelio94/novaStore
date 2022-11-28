package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.CarritoDTO;
import com.tienda.tienda_de_ropa.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @GetMapping("/carrito")
    public List<CarritoDTO> traerListaCarritos() {
        return carritoService.traerTodos();
    }

    @GetMapping("/carrito/{id}")
    public CarritoDTO traerCarritoDTO(@PathVariable Long id) {
        return carritoService.traerCarritoPorId(id);
    }

    @GetMapping("/clientes/actual/carrito")
    public CarritoDTO traerCarritoAutenticado(Authentication authentication) {
        return carritoService.traerCarritoAutenticado(authentication);
    }

    @PostMapping("/clientes/actual/carrito")
    public ResponseEntity<?> postShoppingCartDTO(Authentication authentication) {
        return carritoService.crearCarrito(authentication);
    }

}
