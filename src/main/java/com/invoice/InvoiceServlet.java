package com.invoice;

import com.invoice.data.DBController;
import com.invoice.model.Invoice;
import com.invoice.model.Product;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        DBController dbc = new DBController();
        List<Product> productList = dbc.getProductsList();

        request.setAttribute("productList", productList);

        RequestDispatcher disp = request
                .getRequestDispatcher("index.jsp");
        disp.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            addProduct(request);
            doGet(request, response);
            return;
        }
        Invoice invoice = getInvoiceFromRequest(request);

        List<Product> productList = new ArrayList<>(); // Creating empty list of products.

        for (int i = 1; i < 5; i++) {
            if (!request.getParameter("product-name" + i).equals("") && !request.getParameter("quantity" + i).equals("")) {
                productList.add(getProductFromRequest(String.valueOf(i), request));
            }
        }

        invoice.setListOfProducts(productList);

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


    public Invoice getInvoiceFromRequest(HttpServletRequest request) {
        Invoice invoice = new Invoice();
        invoice.setFaktura(request.getParameter("faktura"));
        invoice.setNumerFaktury(request.getParameter("numer-faktury"));
        invoice.setDataWFaktury(request.getParameter("data-w-faktury"));
        invoice.setMiejsceFaktury(request.getParameter("miejsce-faktury"));
        invoice.setData(request.getParameter("data"));
        invoice.setTypDaty(request.getParameter("typ-daty"));
        invoice.setFormaPlatnosci(request.getParameter("forma-platnosci"));

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

    private Product getProductFromRequest(String number, HttpServletRequest request) {
        DBController databaseController = new DBController();
        Product product = databaseController.getProduct(request.getParameter("product-name" + number));   //
        product.setQuantity(request.getParameter("quantity" + number));
        return product;
    }

    private void addProduct(HttpServletRequest request) {
        String name = request.getParameter("name");
        String netto = request.getParameter("netto");
        String vat = request.getParameter("vat");
        Product product = new Product(name, netto, vat);
        DBController dbController = new DBController();
        dbController.addProductToDatabase(product);
    }
}
