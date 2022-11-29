package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class PDFController {

    @Autowired
    PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @Autowired
    ClienteService clienteService;

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response, Authentication authentication, @RequestParam String number) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        String email = authentication.getName();

        this.pdfService.export(response, email, number);
    }
}
