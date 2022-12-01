package com.tienda.tienda_de_ropa.utils;

import javax.servlet.http.HttpServletRequest;

public class Utilidades {
    public static String url(HttpServletRequest request) {
        String sitioURL = request.getRequestURL().toString();
        return sitioURL.replace(request.getServletPath(), "");
    }
}
