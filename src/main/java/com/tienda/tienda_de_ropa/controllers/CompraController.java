package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.models.TipoTransaccion;
import com.tienda.tienda_de_ropa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class CompraController {
    @Autowired
    ClienteService clienteService;

    @Transactional
    @PostMapping("/transaccional")
    public ResponseEntity<Object> crearTransferencias(Authentication authentication, @RequestParam TipoTransaccion tipoTransaccion,
                                                      @RequestParam Double monto) {
        //Cliente clienteAutenticado =clienteService.findByCorreo(authentication.getName());
        if (tipoTransaccion == null){
            return new ResponseEntity<>("No ingresaste el tipo de transaccion", HttpStatus.FORBIDDEN);
        }
        if (monto.isNaN() || monto == 0){
            return new ResponseEntity<>("No ingresaste un monto",HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("Se Realizo la transaccion con exito",HttpStatus.CREATED);
    }
}

