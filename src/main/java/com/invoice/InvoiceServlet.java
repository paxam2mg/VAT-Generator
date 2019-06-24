package com.invoice;

import com.invoice.data.DBController;
import com.invoice.model.Invoice;
import com.invoice.model.Product;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InvoiceServlet", urlPatterns = {"invoice"}, loadOnStartup = 1)
public class InvoiceServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Invoice invoice = getInvoiceFromRequest(request);

        DBController databaseController = new DBController();
        List<Product> productList = new ArrayList<>(); // Creating empty list of products.

        //Product product = new Product("nn", "3123", "34"); // Creating new product with sent specification.
        Product product = databaseController.getProducts("Chair");   //
        product.setQuantity(2);
        productList.add(product);


     //   productList.addAll(databaseController.getProductsList()); // Adding all products from database to created list.
        invoice.setListOfProducts(productList);



        //databaseController.addProductToDatabase(product); // Adding new product to database.


        ByteArrayOutputStream byteArrayOutputStream = new PDFCreator().create(invoice); // Creating PDF with list of products and saving it as output.

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + "Invoice-" + "" + ".pdf");
        response.setContentLength(byteArrayOutputStream.size());

        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();
            byteArrayOutputStream.writeTo(servletOutputStream);
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Invoice getInvoiceFromRequest(HttpServletRequest request){
        Invoice invoice = new Invoice();
        invoice.setFaktura(request.getParameter("faktura"));
        invoice.setNumerFaktury(request.getParameter("numer-faktury"));
        invoice.setDataWFaktury(request.getParameter("data-w-faktury"));
        invoice.setMiejsceFaktury(request.getParameter("miejsce-faktury"));

        invoice.setNameS(request.getParameter("name-s"));
        invoice.setAdresS(request.getParameter("adres-s"));
        invoice.setAdresS2(request.getParameter("adres-s2"));
        invoice.setNIPS(request.getParameter("NIP-s"));
        invoice.setREGONS(request.getParameter("REGON-s"));
        invoice.setDodatekS(request.getParameter("dodatek-s"));

        invoice.setWaluta(request.getParameter("waluta"));

        invoice.setNettoPrice(request.getParameter("netto-price"));
        invoice.setVat(request.getParameter("vat"));

        invoice.setNameN(request.getParameter("name-n"));
        invoice.setAdresN(request.getParameter("adres-n"));
        invoice.setAdresN2(request.getParameter("adres-n2"));
        invoice.setNIPN(request.getParameter("NIP-n"));
        invoice.setREGONN(request.getParameter("REGON-n"));
        invoice.setDodatekN(request.getParameter("dodatek-n"));

        return invoice;
    }

}
