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

<div>
<form method="post" action="invoice">


<table1>
        <tr>
            <td>Nazwa produktu: <input type="text"  name="name"/></td>
            <td>Cena Netto: <input type="text" name="netto"/></td>
            <td>Vat: <input type="text" name="vat"/></td>
            <td><button type="submit" name="add">Add</button></td>
        </tr>
</table1>

</form>
</div>
<br> <br>
<div>
<form method="post" action="invoice">
<table2>
<tr>
    <td>Faktura VAT: <input type="text" id="faktura-input" name="faktura"/></td>
    <td>Faktura nr #: <input type="text" id="numerfaktury" name="numer-faktury"/></td>
     <td>Miejsce wystawienia faktury: <input type="text" id="miejsce-faktury" name="miejsce-faktury"/></td> <br> <br>
</tr>
<tr>
    <td>Data wystawienia faktury: <input type="date" id="data-w-faktury" name="data-w-faktury"/></td>

</tr>
</table2>
<br> <br>
</div>
<div>
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
</div>
<div>
<table3>
    <tr>
    <td>Nazwa produktu: <input type="text"  name="product-name1"/></td>
    <td> Ilość: <input type="text" name="quantity1"/></td> <br> <br>
    </tr>
    <tr>
    <td>Nazwa produktu: <input type="text"  name="product-name2"/></td>
    <td> Ilość: <input type="text" name="quantity2"/></td> <br> <br>
    </tr>
        <tr>
    <td>Nazwa produktu: <input type="text"  name="product-name3"/></td>
    <td> Ilość: <input type="text" name="quantity3"/></td> <br> <br>
    </tr>
    <tr>
    <td>Nazwa produktu: <input type="text"  name="product-name4"/></td>
    <td> Ilość: <input type="text" name="quantity4"/></td> <br> <br>
    </tr>

<br> <br>
</table3>

</div>
<div>
<table4>
<tr>
    <td>Nazwa firmy sprzedawca: <input type="text"  name="name-s"/></td>
    <td>Nazwa firmy nabywca: <input type="text" id="say-s-hello-text-input" name="name-n"/></td> <br> <br>
</tr>
<tr>
    <td>Adres firmy sprzedawca: <input type="text" name="adres-s"/></td>
    <td>Adres firmy nabywca: <input type="text" id="adres-s-input" name="adres-n"/></td> <br> <br>
</tr>
<tr>
    <td>Adres firmy cd. sprzedawca: <input type="text"  name="adres-s2"/></td>
    <td>Adres firmy cd. nabywca: <input type="text" id="adres-s2-input" name="adres-n2"/></td> <br> <br>
</tr>
<tr>
    <td>NIP sprzedawca: <input type="text"  name="NIP-s"/></td>
    <td>NIP nabywca: <input type="text" id="NIP-input" name="NIP-n"/></td> <br> <br>
</tr>
<tr>
    <td>REGON sprzedawca: <input type="text"  name="REGON-s"/></td>
    <td>REGON nabywca: <input type="text" id="REGON-input" name="REGON-n"/></td> <br> <br>
</tr>
<tr>
    <td>Dodatkowe informacje: <input type="text"  name="dodatek-s"/></td>
    <td>Dodatkowe informacje: <input type="text" id="dodatek-input" name="dodatek-n"/></td>
</tr>

    <br> <br>
     <br> <br>

</table4>
    <input type="submit" id="send-button" value="Send"/>

</form>
</body>
</html>