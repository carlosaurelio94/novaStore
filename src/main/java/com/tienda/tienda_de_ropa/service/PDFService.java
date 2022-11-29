package com.tienda.tienda_de_ropa.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tienda.tienda_de_ropa.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PDFService {
    @Autowired
    ClienteService clientService;

    public void export (HttpServletResponse response, @RequestParam String email, @RequestParam String number,
                        @RequestParam LocalDate dateFrom1, @RequestParam LocalDate dateTo1) throws IOException {
        Document document = new Document(PageSize.A5);
        PdfWriter.getInstance(document, response.getOutputStream());

        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);

        float[] columnDefinitionSize = { 33.33F, 33.33F, 33.33F };

        float pos = height / 2;
        PdfPTable table = null;
        PdfPCell cell = null;

        Cliente cliente = clientService.findByCorreo(email);



        Paragraph paragraph = new Paragraph("NOVA BANK ", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("BANK ACCOUNT STATEMENT", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph3 = new Paragraph("Welcome, " + cliente.getNombre() + " " + cliente.getApellido(), fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);

        table = new PdfPTable(columnDefinitionSize);
        table.getDefaultCell().setBorder(0);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 72);
        table.setLockedWidth(true);

        cell = new PdfPCell(new Phrase("NOVA BANK"));
        cell.setColspan(columnDefinitionSize.length);
        table.addCell(cell);
   /*     Set<Transaction> transactionsSet = account.getTransactions().stream().filter(transaction ->
                transaction.getDate().toLocalDate().isBefore(dateTo1.plusDays(1))
                        && transaction.getDate().toLocalDate().isAfter(dateFrom1)).collect(Collectors.toSet());
        ArrayList<Transaction> transactions = new ArrayList<>(transactionsSet);

        table.addCell(new Phrase("Amount", font8));
        table.addCell(new Phrase("Description", font8));
        table.addCell(new Phrase("Date", font8));

        for (int i = 0; i < transactions.size(); i++) {
            table.addCell(new Phrase(transactions.get(i).getAmount().toString(),font8));
            table.addCell(new Phrase(transactions.get(i).getDescription(), font8));
            table.addCell(new Phrase(transactions.get(i).getDate().getDayOfMonth() + " " + transactions.get(i).getDate().getMonth().toString()
                    + " " + transactions.get(i).getDate().getYear(), font8));
        }
*/
//        table.writeSelectedRows(0, -1, 50, pos, writer.getDirectContent());


        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(table);
        document.close();
    }
}
