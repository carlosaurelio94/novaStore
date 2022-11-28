package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.models.*;
import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.CompraService;
import com.tienda.tienda_de_ropa.service.OrdenCompraService;
import com.tienda.tienda_de_ropa.service.ProductoService;
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
    ProductoService productoService;
    @Autowired
    OrdenCompraService ordenCompraService;

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
        carrito.getOrdenCompra().removeAll(carrito.getOrdenCompra());
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
        carrito.getOrdenCompra().removeAll(carrito.getOrdenCompra());
        clienteAutenticado.setPuntos(puntosTotales);
        clienteService.guardarCliente(clienteAutenticado);


        return new ResponseEntity<>("Se Realizo la compra con exito",HttpStatus.ACCEPTED);
    }

//    @Transactional
//    @PostMapping("/compra")
//    public ResponseEntity<?> crearOrdenCompra(
//            @RequestParam String nombreProducto,
//            @RequestParam int cantidad,
//            Authentication authentication)
//    {
//        Cliente clienteActual = this.clienteService.findByCorreo(authentication.getName());
//        Producto productoEncontrado = productoService.productoPorNombre(nombreProducto.toLowerCase());
//
//
//        if (nombreProducto.isEmpty()) {
//            return new ResponseEntity<>("El nombre del producto no puede estar vacio", HttpStatus.FORBIDDEN);
//        }
//
//        if (cantidad <= 0) {
//            return new ResponseEntity<>("La cantidad no puede ser igual o menor a cero", HttpStatus.FORBIDDEN);
//        }
//
//        if (productoService.productoPorNombre(nombreProducto.toLowerCase()) == null) {
//            return new ResponseEntity<>("El producto no existe", HttpStatus.FORBIDDEN);
//        }
//
//        if (cantidad > productoEncontrado.getStock()) {
//            return new ResponseEntity<>("No podés comprar más del stock", HttpStatus.FORBIDDEN);
//        }
//
//        OrdenCompra nuevaOrdenCompra = new OrdenCompra(cantidad, productoEncontrado.getPrecio() * cantidad, LocalDateTime.now(), clienteActual.getCarrito(), productoEncontrado);
//        ordenCompraService.guardarOrdenCompra(nuevaOrdenCompra);
//
//        return new ResponseEntity<>("Orden de compra creada", HttpStatus.CREATED);
//    }

}

