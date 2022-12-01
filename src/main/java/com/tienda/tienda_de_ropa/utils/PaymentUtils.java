package com.tienda.tienda_de_ropa.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.tienda.tienda_de_ropa.dtos.ItemDTO;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class PaymentUtils {
    private static final String accessToken = "Bearer " + "APP_USR-8667575308804966-120118-a34d74cb3e0b8ec0ba2e185f8c065fe9-726832199";
    private static final String urlAPI = "https://api.mercadopago.com/checkout/preferences";
    public static String postGetMPUrl(String json) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .addHeader("Authorization", accessToken)
                .url(urlAPI)
                .post(requestBody)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            ObjectMapper mapper = new JsonMapper();
            JsonNode responseJson = mapper.readTree(response.body().string());
            return responseJson.get("init_point").asText();
        }
    }
    public static List<ItemDTO> stringToDTO(String items) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<ItemDTO> itemDTOList = mapper.readValue(items, new TypeReference<List<ItemDTO>>(){});
        System.out.println(itemDTOList);
        return itemDTOList;
    }
}
