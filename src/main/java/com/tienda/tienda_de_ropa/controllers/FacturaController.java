package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.FacturaDTO;
import com.tienda.tienda_de_ropa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/factura")
    public List<FacturaDTO> traerTodos() {
        return facturaService.traerTodos();
    }

    @GetMapping("/factura/{id}")
    public FacturaDTO getBillById(@PathVariable Long id) {
        return facturaService.traerFacturaPorId(id);
    }

    //To do: PDF de Factura

}
