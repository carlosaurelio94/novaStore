package com.tienda.tienda_de_ropa.service.implementation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.tienda_de_ropa.dtos.ItemDTO;
import com.tienda.tienda_de_ropa.models.Preference;
import com.tienda.tienda_de_ropa.models.Producto;
import com.tienda.tienda_de_ropa.repositories.ProductoRepository;
import com.tienda.tienda_de_ropa.service.PaymentServiceMP;
import com.tienda.tienda_de_ropa.utils.PaymentUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
@Service
public class PaymentServiceMPImplement implements PaymentServiceMP {
    @Autowired
    ProductoRepository productRepository;

    @Override
    public ResponseEntity<Object> getPaymentUrl(@NotNull List<ItemDTO> itemDTOList) {
        itemDTOList.forEach(itemDTO -> {
            Producto productInfo =  productRepository.findById(Long.parseLong(itemDTO.getId())).orElse(null);
            itemDTO.setTitle(productInfo.getNombre());
            itemDTO.setCurrency_id("ARS");
            itemDTO.setPicture_url("");
            itemDTO.setCategory_id("art");
            itemDTO.setUnit_price(productInfo.getPrecio());
        });
        Preference preference = new Preference(itemDTOList);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = "";
        try {
            requestBody = mapper.writeValueAsString(preference);
            System.out.println(requestBody);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        try {
            String linkResponse = PaymentUtils.postGetMPUrl(requestBody);
            return new ResponseEntity<Object>(linkResponse ,HttpStatus.CREATED);
        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
