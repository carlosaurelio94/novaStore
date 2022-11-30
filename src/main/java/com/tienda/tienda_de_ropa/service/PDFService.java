package com.tienda.tienda_de_ropa.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.Factura;
import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.repositories.CarritoRepository;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PDFService {
    @Autowired
    ClienteService clientService;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CarritoRepository carritoRepository;

    public void export (HttpServletResponse response, String email) throws IOException {
        Document document = new Document(PageSize.A5);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);

        float[] columnDefinitionSize = { 10F, 40F, 20F, 30F };

        float pos = height / 2;
        PdfPTable table = null;
        PdfPCell cell = null;

        Cliente cliente = clienteRepository.findByCorreo(email);

        Paragraph paragraph = new Paragraph("NOVA STORE ", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("ORDEN DE COMPRA", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph3 = new Paragraph("Bienvenido, " + cliente.getNombre() + " " + cliente.getApellido(), fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);

        table = new PdfPTable(columnDefinitionSize);
        table.getDefaultCell().setBorder(0);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 72);
        table.setLockedWidth(true);

        cell = new PdfPCell(new Phrase("NOVA STORE"));
        cell.setColspan(columnDefinitionSize.length);
        table.addCell(cell);
            Set<OrdenCompra> ordenesCompra = cliente.getCarrito().getOrdenCompra();
        ArrayList<OrdenCompra> ordenComprasLista = new ArrayList<>(ordenesCompra);

        table.addCell(new Phrase("ID", font8));
        table.addCell(new Phrase("Nombre", font8));
        table.addCell(new Phrase("Cantidad", font8));
        table.addCell(new Phrase("Precio", font8));

        for (int i = 0; i < ordenComprasLista.size(); i++) {
            table.addCell(new Phrase(ordenComprasLista.get(i).getId().toString(),font8));
            table.addCell(new Phrase(ordenComprasLista.get(i).getProducto().getNombre(), font8));
            Integer cantidad = ordenComprasLista.get(i).getCantidad();
            table.addCell(new Phrase(cantidad.toString()));
            Double precio = ordenComprasLista.get(i).getPrecio();
            table.addCell(new Phrase(String.valueOf(precio)));
        }
        List<Double> monto = carrito.getOrdenCompra().stream().map(compra -> compra.getPrecio()).collect(Collectors.toList());
        double total = 0.0;
        for (double precio : monto) {
            total = total + precio;
        }

       // table.writeSelectedRows(0, -1, 50, pos, writer.getDirectContent());

        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(table);
        document.close();
    }
}
