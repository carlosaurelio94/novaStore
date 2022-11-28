package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.dtos.CarritoDTO;
import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.CarritoRepository;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import com.tienda.tienda_de_ropa.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImplement implements CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void guardarCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public List<CarritoDTO> traerTodos() {
        return carritoRepository.findAll().stream().map(carrito -> new CarritoDTO(carrito)).collect(Collectors.toList());
    }

    @Override
    public CarritoDTO traerCarritoPorId(Long id) {
        return carritoRepository.findById(id).map(carrito -> new CarritoDTO(carrito)).orElse(null);
    }

    @Override
    public CarritoDTO traerCarritoAutenticado(Authentication authentication) {
        Cliente client=this.clienteRepository.findByCorreo(authentication.getName());
        return  new CarritoDTO(client.getCarrito());
    }

    @Override
    public ResponseEntity<?> crearCarrito(Authentication authentication) {
        Cliente clienteActual = this.clienteRepository.findByCorreo(authentication.getName());
        Carrito nuevoCarrito = clienteActual.getCarrito();
        return new ResponseEntity<>("Carrito Creado", HttpStatus.CREATED);
    }

    @Override
    public void eliminarCarrito(Carrito carrito) {
        carritoRepository.delete(carrito);
    }


}
