package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.models.GiftCard;

public interface GiftCardService {
    public void saveGiftCard(GiftCard giftCard);

    public GiftCard findByNumeroTarjeta (String numeroTarjeta);

}
