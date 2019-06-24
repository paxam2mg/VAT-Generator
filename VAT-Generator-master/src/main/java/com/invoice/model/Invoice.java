package com.invoice.model;

import com.invoice.model.Product;

import java.util.List;

public class Invoice {

    private String faktura;
    private String numerFaktury;
    private String dataWFaktury;
    private String miejsceFaktury;
    private String nameS;
    private String adresS;
    private String adresS2;
    private String NIPS;
    private String REGONS;
    private String dodatekS;
    private String waluta;

    private String nettoPrice;
    private String vat;
    private String nameN;
    private String adresN;
    private String adresN2;
    private String NIPN;
    private String REGONN;
    private String dodatekN;
    private List<Product> listOfProducts;

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public String getFaktura() {
        return faktura;
    }

    public void setFaktura(String faktura) {
        this.faktura = faktura;
    }

    public String getNumerFaktury() {
        return numerFaktury;
    }

    public void setNumerFaktury(String numerFaktury) {
        this.numerFaktury = numerFaktury;
    }

    public String getDataWFaktury() {
        return dataWFaktury;
    }

    public void setDataWFaktury(String dataWFaktury) {
        this.dataWFaktury = dataWFaktury;
    }

    public String getMiejsceFaktury() {
        return miejsceFaktury;
    }

    public void setMiejsceFaktury(String miejsceFaktury) {
        this.miejsceFaktury = miejsceFaktury;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getAdresS() {
        return adresS;
    }

    public void setAdresS(String adresS) {
        this.adresS = adresS;
    }

    public String getAdresS2() {
        return adresS2;
    }

    public void setAdresS2(String adresS2) {
        this.adresS2 = adresS2;
    }

    public String getNIPS() {
        return NIPS;
    }

    public void setNIPS(String NIPS) {
        this.NIPS = NIPS;
    }

    public String getREGONS() {
        return REGONS;
    }

    public void setREGONS(String REGONS) {
        this.REGONS = REGONS;
    }

    public String getDodatekS() {
        return dodatekS;
    }

    public void setDodatekS(String dodatekS) {
        this.dodatekS = dodatekS;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(String nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getNameN() {
        return nameN;
    }

    public void setNameN(String nameN) {
        this.nameN = nameN;
    }

    public String getAdresN() {
        return adresN;
    }

    public void setAdresN(String adresN) {
        this.adresN = adresN;
    }

    public String getAdresN2() {
        return adresN2;
    }

    public void setAdresN2(String adresN2) {
        this.adresN2 = adresN2;
    }

    public String getNIPN() {
        return NIPN;
    }

    public void setNIPN(String NIPN) {
        this.NIPN = NIPN;
    }

    public String getREGONN() {
        return REGONN;
    }

    public void setREGONN(String REGONN) {
        this.REGONN = REGONN;
    }

    public String getDodatekN() {
        return dodatekN;
    }

    public void setDodatekN(String dodatekN) {
        this.dodatekN = dodatekN;
    }
}
