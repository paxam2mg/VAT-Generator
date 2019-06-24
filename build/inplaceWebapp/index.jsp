<%@ page import="java.util.ArrayList" %>
<%@ page import="com.invoice.model.Product" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Generator faktur</title>
    <style>
        th {
            border: 1px solid black;
        }

        .sides {
            width: 20%;
        }

        .middle {
            width: 60%;
        }
    </style>
    <link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

<p><h2>Generator faktur VAT</h2></p>

<div id="main">
    <table class="table">
        <tr>
            <th class="middle">Nazwa</th>
            <th class="sides">Cena Netto</th>
            <th class="sides">Stawka Vat</th>
        </tr>

        <%
            List<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
            if (productList == null || productList.isEmpty()) {
        %>
        <tr>
            <td>Pusto</td>
            <td>Pusto</td>
        </tr>
        <%
        } else {
            int i = 1;
            for (Product product : productList) {
        %>
        <tr>
            <td class="middle"><%=product.getName()%>
            </td>
            <td class="sides"><%=product.getNettoPrice()%>
            </td>
            <td class="sides"><%=product.getVAT()%>
            </td>
        </tr>
        <%
                    ++i;
                }
            }
        %>
    </table>
</div>
<br>
<form method="post" action="invoice">

    Nazwa produktu: <input type="text"  name="name"/> <br>
    Cena Netto: <input type="text" name="netto"/> <br>
    Vat: <input type="text" name="vat"/> <br>

    <button type="submit" name="add">Add</button>

</form>
<br>
<form method="post" action="invoice">
    Faktura VAT: <input type="text" id="faktura-input" name="faktura"/> <br> <br>
    Faktura nr #: <input type="text" id="numerfaktury" name="numer-faktury"/> <br> <br>

    Data wystawienia faktury: <input type="date" id="data-w-faktury" name="data-w-faktury"/> <br> <br>
    Miejsce wystawienia faktury: <input type="text" id="miejsce-faktury" name="miejsce-faktury"/> <br> <br>
    <SELECT name="typ-daty">
        <OPTION Value="Wybor">Wybierz typ daty</OPTION>
        <OPTION Value="Data dostawy">Data dokonania dostawy towarów</OPTION>
        <OPTION Value="Data uslugi">Data wykonania usługi</OPTION>
        <OPTION Value="Data sprzedazy">Data sprzedaży</OPTION>
    </SELECT>
    <input type="date" id="data-input" name="data"/>
    <br> <br>
    Waluta:
    <SELECT name="waluta">
        <OPTION Value="PLN">PLN</OPTION>
        <OPTION Value="USD">USD</OPTION>
        <OPTION Value="EUR">EUR</OPTION>
    </SELECT>
    <br> <br>
    Forma płatności:
    <SELECT name="forma-platnosci">
        <OPTION Value="Gotowka">Gotówka</OPTION>
        <OPTION Value="Przelew">Przelew</OPTION>
    </SELECT>
    <br> <br>
    <br> <br>

    Nazwa produktu: <input type="text"  name="product-name1"/> <br> <br>
    Ilość: <input type="text" name="quantity1"/> <br> <br>
    Nazwa produktu: <input type="text"  name="product-name2"/> <br> <br>
    Ilość: <input type="text" name="quantity2"/> <br> <br>
    Nazwa produktu: <input type="text"  name="product-name3"/> <br> <br>
    Ilość: <input type="text" name="quantity3"/> <br> <br>
    Nazwa produktu: <input type="text"  name="product-name4"/> <br> <br>
    Ilość: <input type="text" name="quantity4"/> <br> <br>
    <br> <br>

    Nazwa firmy sprzedawca: <input type="text"  name="name-s"/> <br> <br>
    Adres firmy sprzedawca: <input type="text" name="adres-s"/> <br> <br>
    Adres firmy cd. sprzedawca: <input type="text"  name="adres-s2"/> <br> <br>
    NIP sprzedawca: <input type="text"  name="NIP-s"/> <br> <br>
    REGON sprzedawca: <input type="text"  name="REGON-s"/> <br> <br>
    Dodatkowe informacje: <input type="text"  name="dodatek-s"/> <br> <br>

    <br> <br>
    Nazwa firmy nabywca: <input type="text" id="say-s-hello-text-input" name="name-n"/> <br> <br>
    Adres firmy nabywca: <input type="text" id="adres-s-input" name="adres-n"/> <br> <br>
    Adres firmy cd. nabywca: <input type="text" id="adres-s2-input" name="adres-n2"/> <br> <br>
    NIP nabywca: <input type="text" id="NIP-input" name="NIP-n"/> <br> <br>
    REGON nabywca: <input type="text" id="REGON-input" name="REGON-n"/> <br> <br>
    Dodatkowe informacje: <input type="text" id="dodatek-input" name="dodatek-n"/> <br> <br>

    <input type="submit" id="send-button" value="Send"/>

</form>
</body>
</html>