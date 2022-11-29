package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.service.CarritoService;
import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    CarritoService carritoService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OrdenCompraService ordenCompraService;

    @GetMapping("/clientes")
    public List<ClienteDTO> listaClientesDTO(){
        return clienteService.getClientesDTO();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDTO clienteDTO(@PathVariable long id) { return clienteService.clienteDTO(id); }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearNuevoCliente(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String correo,
            @RequestParam String clave,
            @RequestParam String clave2
    ){
        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Nombre", HttpStatus.FORBIDDEN);
        }
        if(apellido.isEmpty()){
            return new ResponseEntity<>("Falta el dato Apellido", HttpStatus.FORBIDDEN);
        }
        if(correo.isEmpty()){
            return new ResponseEntity<>("Falta el dato Correo", HttpStatus.FORBIDDEN);
        }
        if(clave.isEmpty()){
            return new ResponseEntity<>("Falta el dato contraseña", HttpStatus.FORBIDDEN);
        }
        if (clienteService.findByCorreo(correo) != null) {
            return new ResponseEntity<>("El correo ya se encuentra en uso", HttpStatus.FORBIDDEN);
        }
        if (!clave.equals(clave2)) {
            return new ResponseEntity<>("Las contraseñas no coinciden", HttpStatus.FORBIDDEN);
        }

        String verificacionToken = UUID.randomUUID().toString();
        Cliente nuevoCliente = new Cliente(nombre, apellido, correo, passwordEncoder.encode(clave), 0);
        nuevoCliente.setToken(verificacionToken);
        clienteService.guardarCliente(nuevoCliente);

        Carrito nuevoCarritoCliente = new Carrito(nuevoCliente);
        carritoService.guardarCarrito(nuevoCarritoCliente);

        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/clientes/actual")
    public ClienteDTO traerClienteAutenticado(Authentication authentication) {
        return new ClienteDTO(clienteService.findByCorreo(authentication.getName()));
    }

    @DeleteMapping(path ="/clientes")
    public ResponseEntity<?> eliminarCliente(
            @RequestParam Long id)
    {
        Cliente clienteEncontrado = clienteService.encontrarPorId(id);

        if (clienteEncontrado == null){
            return new ResponseEntity<>("El cliente no existe", HttpStatus.FORBIDDEN);
        }

        Set<OrdenCompra> ordenesEncontradas = clienteEncontrado.getCarrito().getOrdenCompra();
        if (!ordenesEncontradas.isEmpty()){
            ordenCompraService.eliminarTodas(ordenesEncontradas);
        }

        Carrito carritoEncontrado = clienteEncontrado.getCarrito();
        carritoService.eliminarCarrito(carritoEncontrado);
        clienteService.eliminarCliente(clienteEncontrado);
        return new ResponseEntity<>("Cliente Borrado correctamente",HttpStatus.ACCEPTED);
    }
}
