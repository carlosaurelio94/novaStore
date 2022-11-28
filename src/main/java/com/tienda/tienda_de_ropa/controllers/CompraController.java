package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.models.*;
import com.tienda.tienda_de_ropa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompraController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    CompraService compraService;
    @Autowired
    CarritoService carritoService;

    @Transactional
    @PostMapping("/transaccional")
    public ResponseEntity<?> crearTransferencias(
            Authentication authentication,
            @RequestParam Double monto) {
        Cliente clienteAutenticado =clienteService.findByCorreo(authentication.getName());
        Carrito carrito = clienteAutenticado.getCarrito();
        Factura factura = new Factura(carrito) ;

        if(carrito.getOrdenCompra().size() == 0){
            return new ResponseEntity<>("No agregaste productos", HttpStatus.FORBIDDEN);
        }
        if (monto.isNaN()){
            return new ResponseEntity<>("No ingresaste un monto",HttpStatus.FORBIDDEN);
        }
        if (monto <= 0){
            return new ResponseEntity<>("No puedes ingresar menor o igual a cero", HttpStatus.FORBIDDEN);
        }

        Compra compraRealizada = new Compra(LocalDateTime.now(),TipoTransaccion.DEBITO,factura.getPrecioTotal()/10,"Muchos productos",factura.getPrecioTotal(),clienteAutenticado);
        compraService.guardarCompra(compraRealizada);
        carritoService.eliminarCarrito(carrito);
        clienteService.guardarCliente(clienteAutenticado);

        return new ResponseEntity<>("Se Realizo la transaccion con exito",HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/transaccionPuntos")
    public ResponseEntity<Object> compraPuntos(Authentication authenticatio){
        Cliente clienteAutenticado = clienteService.findByCorreo(authenticatio.getName());
        Carrito carrito = clienteAutenticado.getCarrito();
        Factura factura = new Factura(carrito) ;
        double cantidadPuntosCarrito = factura.getPrecioTotal()/10;
        double puntosTotales = clienteAutenticado.getPuntos()-cantidadPuntosCarrito;
        if (clienteAutenticado.getPuntos() <= 0){
            return new ResponseEntity<>("No tienes puntos disponibles", HttpStatus.FORBIDDEN);
        }
        if (clienteAutenticado.getPuntos()<cantidadPuntosCarrito){
            return new ResponseEntity<>("No tienes los puntos suficientes para realizar la compra",HttpStatus.FORBIDDEN);
        }
        if (puntosTotales <= 0){
            return new ResponseEntity<>("No tienes los puntos suficientes para realizar la compra",HttpStatus.FORBIDDEN);
        }
        Compra compraPuntos = new Compra(LocalDateTime.now(),TipoTransaccion.DEBITO,puntosTotales,factura.getId().toString(),factura.getPrecioTotal(),clienteAutenticado);

        compraService.guardarCompra(compraPuntos);
        carritoService.eliminarCarrito(carrito);
        clienteAutenticado.setPuntos(puntosTotales);
        clienteService.guardarCliente(clienteAutenticado);


        return new ResponseEntity<>("Se Realizo la compra con exito",HttpStatus.ACCEPTED);
    }

}

