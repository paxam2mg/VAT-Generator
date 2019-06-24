package com.invoice;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class InvoiceCreatorTest {

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

        invoice.setWaluta("waluta");

        invoice.setNettoPrice("netto-price");
        invoice.setVat("vat");

        invoice.setNameN("JanKowal");
        invoice.setAdresN("Dluga 3");
        invoice.setAdresN2("39-233 Kolo");
        invoice.setNIPN("1343141311");
        invoice.setREGONN("13441331");
        invoice.setDodatekN("dodatek-n");

        InvoiceCreator invoiceCreator = new InvoiceCreator();


        return invoiceCreator.create(invoice);
    }


}
