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

    @GetMapping("/shoppingCarts")
    public List<CarritoDTO> traerListaCarritos() {
        return carritoService.traerTodos();
    }

    @GetMapping("/shoppingCart/{id}")
    public CarritoDTO traerCarritoDTO(@PathVariable Long id) {
        return carritoService.traerCarritoPorId(id);
    }

    @GetMapping("/clients/current/shoppingCart")
    public CarritoDTO traerCarritoAutenticado(Authentication authentication) {
        return carritoService.traerCarritoAutenticado(authentication);
    }

    @PostMapping("/clients/current/shoppingCart")
    public ResponseEntity<?> postShoppingCartDTO(Authentication authentication) {
        return carritoService.crearCarrito(authentication);
    }

}
