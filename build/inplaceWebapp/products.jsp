<%@ page import="java.util.ArrayList" %>
<%@ page import="com.invoice.model.Product" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Products</title>

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

</head>
<body>


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
<form method="post" action="products">

    Nazwa produktu: <input type="text"  name="name"/> <br>
    Cena Netto: <input type="text" name="netto"/> <br>
    Vat: <input type="text" name="vat"/> <br>

    <button type="submit" name="add">Add</button>

</form>
<br>

</body>

</html>