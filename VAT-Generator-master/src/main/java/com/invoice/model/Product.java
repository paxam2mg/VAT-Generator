package com.invoice.model;

import java.math.BigDecimal;

public class Product {

    private String name;
    private String nettoPrice;
    private String VAT;
    private String quantity;

    public Product() {
    }

    public Product(String name, String nettoPrice, String VAT) {
        this.name = name;
        this.nettoPrice = nettoPrice;
        this.VAT = VAT;
        this.quantity = "1";
    }

    public Product(String name, String nettoPrice, String VAT, String quantity) {
        this.name = name;
        this.nettoPrice = nettoPrice;
        this.VAT = VAT;
        this.quantity = quantity;
    }

    public String getQuantity() {
            return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = String.valueOf(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNettoPrice() {
        BigDecimal nettoPriceBD = new BigDecimal(nettoPrice);
        return nettoPriceBD.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getTotalNettoPrice() {
        if (quantity != null) {
            BigDecimal nettoPriceBD = new BigDecimal(nettoPrice);
            nettoPriceBD = nettoPriceBD.multiply(new BigDecimal(quantity));
            return nettoPriceBD.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }
        return "";
    }

    public void setNettoPrice(String nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public String getBruttoPrice() {

        BigDecimal nettoPriceBD = new BigDecimal(nettoPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal vatBD = new BigDecimal(VAT).multiply(BigDecimal.valueOf(0.01));
        BigDecimal bruttoPrice = nettoPriceBD.multiply(vatBD).add(nettoPriceBD);
        bruttoPrice = bruttoPrice.multiply(new BigDecimal(quantity));
        return bruttoPrice.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getTotalBruttoPrice() {
        if (quantity != null) {
            BigDecimal nettoPriceBD = new BigDecimal(nettoPrice);
            BigDecimal vatBD = new BigDecimal(VAT).multiply(BigDecimal.valueOf(0.01));
            BigDecimal bruttoPrice = nettoPriceBD.multiply(vatBD).add(nettoPriceBD);
            bruttoPrice = bruttoPrice.multiply(new BigDecimal(quantity));
            return bruttoPrice.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }
        return "";
    }

    public String getVAT() {
        BigDecimal VATBD = new BigDecimal(VAT);
        return VATBD.toString();
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }
}
