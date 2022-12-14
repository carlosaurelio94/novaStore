package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.GiftCard;
import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GiftCardController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    GiftCardService giftCardService;

    public String numberRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min) + "-" + (int) ((Math.random() * (max - min)) + min) + "-" + (int) ((Math.random() * (max - min)) + min) + "-" + (int) ((Math.random() * (max - min)) + min);
    }

    @Transactional
    @PostMapping("/gift/enviar")
    public ResponseEntity<?> enviarGiftCard(
            Authentication autenticacion,
            @RequestParam String correoAEnviar,
            @RequestParam Double monto)
    {
        Cliente clienteActual = clienteService.findByCorreo(autenticacion.getName());
        Cliente clienteAEnviar = clienteService.findByCorreo(correoAEnviar);
        if (clienteActual == null) {
            return new ResponseEntity<>("El cliente actual no existe",HttpStatus.FORBIDDEN);
        }
        if (correoAEnviar == null) {
            return new ResponseEntity<>("El correo al cual quieres enviar la Gift Card no existe", HttpStatus.FORBIDDEN);
        }
        if (monto <= 0) {
            return new ResponseEntity<>("El monto no ser menor o igual a cero", HttpStatus.FORBIDDEN);
        }

        GiftCard nuevaGiftCard = new GiftCard(numberRandom(1000, 10000) ,monto, monto / 10, true, clienteAEnviar);
        giftCardService.guardarGiftCard(nuevaGiftCard);

        return new ResponseEntity<>(nuevaGiftCard, HttpStatus.CREATED);
    }

    @PatchMapping("/gift/deshabilitar")
    public ResponseEntity<?> deshabilitarCard(
            Authentication autenticacion,
            @RequestParam String numeroTarjeta)
    {
        Cliente clienteActual = clienteService.findByCorreo(autenticacion.getName());
        GiftCard giftCard = giftCardService.findByNumeroTarjeta(numeroTarjeta);

        if (clienteActual == null) {
            return new ResponseEntity<>("El cliente actual no existe",HttpStatus.FORBIDDEN);
        }
        if(giftCard == null) {
            return new ResponseEntity<>("Esta tarjeta no existe",HttpStatus.FORBIDDEN);
        }
        if(giftCard.isActivada() == false) {
            return new ResponseEntity<>("Esta tarjeta ya fue utilizada",HttpStatus.FORBIDDEN);
        }

        clienteActual.setPuntos(clienteActual.getPuntos() + giftCard.getPuntos());
        giftCard.setActivada(false);
        clienteService.guardarCliente(clienteActual);
        giftCardService.guardarGiftCard(giftCard);

        return new ResponseEntity<>("Usted ha canjeado su Gift Card con ??xito", HttpStatus.CREATED);
    }

}
