package com.invoice;

import com.invoice.model.Invoice;
import com.invoice.model.Product;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PDFCreatorTest {

    @Test
    public void exportPDF() {

        ByteArrayOutputStream byteArrayOutputStream = generatePDF();
        try (OutputStream outputStream = new FileOutputStream("C:/Raporty/testInvoice.pdf")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException e){

        }
    }


    public ByteArrayOutputStream generatePDF() {

        Invoice invoice = new Invoice();

        invoice.setFaktura("faktura");
        invoice.setNumerFaktury("F/2029/01");
        invoice.setDataWFaktury("21-10-2019");
        invoice.setMiejsceFaktury("Poznan");

        invoice.setNameS("Guzikowo");
        invoice.setAdresS("Gorna 3");
        invoice.setAdresS2("60-699 Poznan");
        invoice.setNIPS("1381398131");
        invoice.setREGONS("343414112");
        invoice.setDodatekS("dodatek-s");

        invoice.setWaluta("PLN");

        invoice.setNettoPrice("netto-price");
        invoice.setVat("vat");

        invoice.setNameN("JanKowal");
        invoice.setAdresN("Dluga 3");
        invoice.setAdresN2("39-233 Kolo");
        invoice.setNIPN("1343141311");
        invoice.setREGONN("13441331");
        invoice.setDodatekN("dodatek-n");

        invoice.setListOfProducts(getProductList());

        PDFCreator PDFCreator = new PDFCreator();


        return PDFCreator.create(invoice);
    }

    private List<Product> getProductList(){
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("Krzeslo", "100", "23", "2"));
        listOfProducts.add(new Product("Krzeslo", "100", "23", "2"));
        listOfProducts.add(new Product("Krzeslo", "100", "23", "2"));
        listOfProducts.add(new Product("Wazon", "152.55", "7", "3"));
        listOfProducts.add(new Product("Wazon", "152.55", "7", "3"));
        return listOfProducts;
    }

}
