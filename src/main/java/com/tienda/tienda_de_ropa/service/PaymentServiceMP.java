package com.tienda.tienda_de_ropa.service;


import com.tienda.tienda_de_ropa.dtos.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentServiceMP {
    ResponseEntity<Object> getPaymentUrl(List<ItemDTO> itemDTOList);
}
