package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.repositories.GiftCardRepository;
import com.tienda.tienda_de_ropa.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;

public class GiftCardServiceImplement implements GiftCardService {

    @Autowired
    GiftCardRepository giftCardRepository;
}
