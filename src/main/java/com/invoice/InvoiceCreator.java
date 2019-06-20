package com.invoice;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InvoiceCreator {

    private Invoice invoice;
    private PDPageContentStream content;

    private PDFont fontBasic = PDType1Font.HELVETICA;
    private PDFont fontBoldAndOblique = PDType1Font.HELVETICA_BOLD_OBLIQUE;
    private PDFont fontOblique = PDType1Font.HELVETICA_OBLIQUE;
    private PDFont fontBold = PDType1Font.HELVETICA_BOLD;


    public ByteArrayOutputStream create(Invoice invoice) {

        this.invoice = invoice;

        PDDocument document = new PDDocument();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
            document.addPage(page);
            try (PDPageContentStream content = new PDPageContentStream(document, page)) {

                this.content = content;
                printHeader();

                content.close();
                document.save(byteArrayOutputStream);
                document.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }

    private void printHeader() throws IOException {
        PDFPrinter justTextPrinter = new PDFPrinter(content, fontBasic, 9);
        PDFPrinter headerTextPrinter = new PDFPrinter(content, fontBasic, 12);
        PDFPrinter bigHeaderTextPrinter = new PDFPrinter(content, fontBasic, 15);

        bigHeaderTextPrinter.putText(340, 760, "FAKTURA VAT");
        headerTextPrinter.putText(340, 740, "nr " + invoice.getNumerFaktury());

        headerTextPrinter.putText(50, 790, "Sprzedawca");
        justTextPrinter.putText(50, 770, invoice.getNameS());
        justTextPrinter.putText(50, 760, invoice.getAdresS());
        justTextPrinter.putText(50, 750, invoice.getAdresS2());
        justTextPrinter.putText(50, 740, "NIP: " + invoice.getNIPS());


        headerTextPrinter.putText(50, 700, "Nabywca");
        justTextPrinter.putText(50, 680, invoice.getNameN());
        justTextPrinter.putText(50, 670, invoice.getAdresN());
        justTextPrinter.putText(50, 660, invoice.getAdresN2());
        justTextPrinter.putText(50, 650, "NIP: " + invoice.getNIPN());

    }

}
