package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.GiftCard;
import com.tienda.tienda_de_ropa.repositories.GiftCardRepository;
import com.tienda.tienda_de_ropa.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftCardServiceImplement implements GiftCardService {

    @Autowired
    GiftCardRepository giftCardRepository;

    @Override
    public void guardarGiftCard(GiftCard giftCard) {
        giftCardRepository.save(giftCard);
    }

    public GiftCard findByNumeroTarjeta (String numeroTarjeta) {
        return giftCardRepository.findByNumeroTarjeta(numeroTarjeta);
    }

}
