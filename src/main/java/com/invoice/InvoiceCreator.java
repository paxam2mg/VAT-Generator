package com.invoice;


import com.invoice.model.Invoice;
import com.invoice.model.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class InvoiceCreator {

    private Invoice invoice;
    private PDPageContentStream content;

    private PDFont fontBasic = PDType1Font.HELVETICA;
    private PDFont fontBoldAndOblique = PDType1Font.HELVETICA_BOLD_OBLIQUE;
    private PDFont fontOblique = PDType1Font.HELVETICA_OBLIQUE;
    private PDFont fontBold = PDType1Font.HELVETICA_BOLD;

    private int lastProductsRowPosition;
    private BigDecimal totalNettoPrice = new BigDecimal(0);
    private BigDecimal totalBruttoPrice = new BigDecimal(0);

    public ByteArrayOutputStream create(Invoice invoice) {

        this.invoice = invoice;

        PDDocument document = new PDDocument();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
            document.addPage(page);

            //fontBasic = PDType0Font.load(document, new File(InvoiceServlet.class.getResource("/fonts/LiberationSans-Regular.ttf").getPath()));

            try (PDPageContentStream content = new PDPageContentStream(document, page)) {

                this.content = content;


                printHeader();
                printTable();
                printSummaryTable();
                printPaymentInfo();
                printSignPlace();

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
        justTextPrinter.putText(340, 720, "Data wystawienia: " + invoice.getDataWFaktury());

        int movement = -12;

        headerTextPrinter.putText(50, 793, "Sprzedawca");
        justTextPrinter.putText(50, 790 + movement, invoice.getNameS());
        justTextPrinter.putText(50, 790 + movement * 2, invoice.getAdresS());
        justTextPrinter.putText(50, 790 + movement * 3, invoice.getAdresS2());
        justTextPrinter.putText(50, 790 + movement * 4, "NIP: " + invoice.getNIPS());


        headerTextPrinter.putText(50, 703, "Nabywca");
        justTextPrinter.putText(50, 700 + movement, invoice.getNameN());
        justTextPrinter.putText(50, 700 + movement * 2, invoice.getAdresN());
        justTextPrinter.putText(50, 700 + movement * 3, invoice.getAdresN2());
        justTextPrinter.putText(50, 700 + movement * 4, "NIP: " + invoice.getNIPN());

    }

    private void printTable() throws IOException {
        PDFPrinter justTextPrinter = new PDFPrinter(content, fontBasic, 9);
        PDFPrinter boldTextPrinter = new PDFPrinter(content, fontBold, 9);

        boldTextPrinter.putText(50, 600, "Lp");
        boldTextPrinter.putText(100, 600, "Usluga/Towar");
        boldTextPrinter.putText(250, 600, "Ilosc");
        boldTextPrinter.putText(290, 600, "Cena netto");
        boldTextPrinter.putText(350, 600, "Wartosc netto");
        boldTextPrinter.putText(425, 600, "Stawka VAT");
        boldTextPrinter.putText(490, 600, "Wartosc brutto");

        List<Product> listOfProducts = invoice.getListOfProducts();

        int rowPosition = 600;
        int movement = - 18;
        int counter = 1;

        for (Product product : listOfProducts) {

            totalNettoPrice = totalNettoPrice.add(new BigDecimal(product.getTotalNettoPrice()));
            totalBruttoPrice = totalBruttoPrice.add(new BigDecimal(product.getTotalBruttoPrice()));

            rowPosition += movement;

            justTextPrinter.putTextToTheRight(60, rowPosition, String.valueOf(counter++));
            justTextPrinter.putText(105, rowPosition, product.getName());
            justTextPrinter.putTextToTheRight(268, rowPosition, product.getQuantity());
            justTextPrinter.putTextToTheRight(333, rowPosition, product.getNettoPrice());
            justTextPrinter.putTextToTheRight(405, rowPosition, product.getTotalNettoPrice());
            justTextPrinter.putTextToTheRight(470, rowPosition, product.getVAT() + "%");
            justTextPrinter.putTextToTheRight(550, rowPosition, product.getTotalBruttoPrice());

        }

        lastProductsRowPosition = rowPosition;

    }

    private void printSummaryTable() throws IOException {
        PDFPrinter justTextPrinter = new PDFPrinter(content, fontBasic, 9);
        PDFPrinter boldTextPrinter = new PDFPrinter(content, fontBold, 9);
        PDFPrinter bigTextPrinter = new PDFPrinter(content, fontBold, 13);

        BigDecimal totalVat = totalBruttoPrice.subtract(totalNettoPrice);

        int movement = -60;

        boldTextPrinter.putText(300, lastProductsRowPosition + movement, "Razem:");
        justTextPrinter.putTextToTheRight(405, lastProductsRowPosition + movement, totalNettoPrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        justTextPrinter.putTextToTheRight(470, lastProductsRowPosition + movement, totalVat.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        justTextPrinter.putTextToTheRight(550, lastProductsRowPosition + movement, totalBruttoPrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());

        movement -= 30;

        bigTextPrinter.putText(300, lastProductsRowPosition + movement , "Razem do zaplaty:");
        bigTextPrinter.putTextToTheRight(550, lastProductsRowPosition + movement, totalBruttoPrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString() + " "+ invoice.getWaluta());

    }

    private void printPaymentInfo() throws IOException {
        PDFPrinter justTextPrinter = new PDFPrinter(content, fontBasic, 9);

    }

    private void printSignPlace() throws IOException {

        PDFPrinter justTextPrinter = new PDFPrinter(content, fontBasic, 8);

        int movement = -150;

        justTextPrinter.putText(110, lastProductsRowPosition + movement,"..........................." );
        justTextPrinter.putText(120, lastProductsRowPosition + movement - 10,"Sprzdawca" );
        justTextPrinter.putText(430, lastProductsRowPosition + movement, "...........................");
        justTextPrinter.putText(443, lastProductsRowPosition + movement - 10, "Nabywca");

    }


}
