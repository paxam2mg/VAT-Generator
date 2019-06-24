package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.invoice.model.Product;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Generator faktur</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        th {\r\n");
      out.write("            border: 1px solid black;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .sides {\r\n");
      out.write("            width: 20%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .middle {\r\n");
      out.write("            width: 60%;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<p><h2>Generator faktur VAT</h2></p>\r\n");
      out.write("\r\n");
      out.write("<div id=\"main\">\r\n");
      out.write("    <table class=\"table\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th class=\"middle\">Nazwa</th>\r\n");
      out.write("            <th class=\"sides\">Cena Netto</th>\r\n");
      out.write("            <th class=\"sides\">Stawka Vat</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");

            List<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
            if (productList == null || productList.isEmpty()) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Pusto</td>\r\n");
      out.write("            <td>Pusto</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

        } else {
            int i = 1;
            for (Product product : productList) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"middle\">");
      out.print(product.getName());
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"sides\">");
      out.print(product.getNettoPrice());
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"sides\">");
      out.print(product.getVAT());
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

                    ++i;
                }
            }
        
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("<form method=\"post\" action=\"invoice\">\r\n");
      out.write("\r\n");
      out.write("    Nazwa produktu: <input type=\"text\"  name=\"name\"/> <br>\r\n");
      out.write("    Cena Netto: <input type=\"text\" name=\"netto\"/> <br>\r\n");
      out.write("    Vat: <input type=\"text\" name=\"vat\"/> <br>\r\n");
      out.write("\r\n");
      out.write("    <button type=\"submit\" name=\"add\">Add</button>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<br>\r\n");
      out.write("<form method=\"post\" action=\"invoice\">\r\n");
      out.write("    Faktura VAT: <input type=\"text\" id=\"faktura-input\" name=\"faktura\"/> <br> <br>\r\n");
      out.write("    Faktura nr #: <input type=\"text\" id=\"numerfaktury\" name=\"numer-faktury\"/> <br> <br>\r\n");
      out.write("\r\n");
      out.write("    Data wystawienia faktury: <input type=\"date\" id=\"data-w-faktury\" name=\"data-w-faktury\"/> <br> <br>\r\n");
      out.write("    Miejsce wystawienia faktury: <input type=\"text\" id=\"miejsce-faktury\" name=\"miejsce-faktury\"/> <br> <br>\r\n");
      out.write("    <SELECT name=\"typ-daty\">\r\n");
      out.write("        <OPTION Value=\"Wybor\">Wybierz typ daty</OPTION>\r\n");
      out.write("        <OPTION Value=\"Data dostawy\">Data dokonania dostawy towarów</OPTION>\r\n");
      out.write("        <OPTION Value=\"Data uslugi\">Data wykonania usługi</OPTION>\r\n");
      out.write("        <OPTION Value=\"Data sprzedazy\">Data sprzedaży</OPTION>\r\n");
      out.write("    </SELECT>\r\n");
      out.write("    <input type=\"date\" id=\"data-input\" name=\"data\"/>\r\n");
      out.write("    <br> <br>\r\n");
      out.write("    Waluta:\r\n");
      out.write("    <SELECT name=\"waluta\">\r\n");
      out.write("        <OPTION Value=\"PLN\">PLN</OPTION>\r\n");
      out.write("        <OPTION Value=\"USD\">USD</OPTION>\r\n");
      out.write("        <OPTION Value=\"EUR\">EUR</OPTION>\r\n");
      out.write("    </SELECT>\r\n");
      out.write("    <br> <br>\r\n");
      out.write("    Forma płatności:\r\n");
      out.write("    <SELECT name=\"forma-platnosci\">\r\n");
      out.write("        <OPTION Value=\"Gotowka\">Gotówka</OPTION>\r\n");
      out.write("        <OPTION Value=\"Przelew\">Przelew</OPTION>\r\n");
      out.write("    </SELECT>\r\n");
      out.write("    <br> <br>\r\n");
      out.write("    <br> <br>\r\n");
      out.write("\r\n");
      out.write("    Nazwa produktu: <input type=\"text\"  name=\"product-name1\"/> <br> <br>\r\n");
      out.write("    Ilość: <input type=\"text\" name=\"quantity1\"/> <br> <br>\r\n");
      out.write("    Nazwa produktu: <input type=\"text\"  name=\"product-name2\"/> <br> <br>\r\n");
      out.write("    Ilość: <input type=\"text\" name=\"quantity2\"/> <br> <br>\r\n");
      out.write("    Nazwa produktu: <input type=\"text\"  name=\"product-name3\"/> <br> <br>\r\n");
      out.write("    Ilość: <input type=\"text\" name=\"quantity3\"/> <br> <br>\r\n");
      out.write("    Nazwa produktu: <input type=\"text\"  name=\"product-name4\"/> <br> <br>\r\n");
      out.write("    Ilość: <input type=\"text\" name=\"quantity4\"/> <br> <br>\r\n");
      out.write("    <br> <br>\r\n");
      out.write("\r\n");
      out.write("    Nazwa firmy sprzedawca: <input type=\"text\"  name=\"name-s\"/> <br> <br>\r\n");
      out.write("    Adres firmy sprzedawca: <input type=\"text\" name=\"adres-s\"/> <br> <br>\r\n");
      out.write("    Adres firmy cd. sprzedawca: <input type=\"text\"  name=\"adres-s2\"/> <br> <br>\r\n");
      out.write("    NIP sprzedawca: <input type=\"text\"  name=\"NIP-s\"/> <br> <br>\r\n");
      out.write("    REGON sprzedawca: <input type=\"text\"  name=\"REGON-s\"/> <br> <br>\r\n");
      out.write("    Dodatkowe informacje: <input type=\"text\"  name=\"dodatek-s\"/> <br> <br>\r\n");
      out.write("\r\n");
      out.write("    <br> <br>\r\n");
      out.write("    Nazwa firmy nabywca: <input type=\"text\" id=\"say-s-hello-text-input\" name=\"name-n\"/> <br> <br>\r\n");
      out.write("    Adres firmy nabywca: <input type=\"text\" id=\"adres-s-input\" name=\"adres-n\"/> <br> <br>\r\n");
      out.write("    Adres firmy cd. nabywca: <input type=\"text\" id=\"adres-s2-input\" name=\"adres-n2\"/> <br> <br>\r\n");
      out.write("    NIP nabywca: <input type=\"text\" id=\"NIP-input\" name=\"NIP-n\"/> <br> <br>\r\n");
      out.write("    REGON nabywca: <input type=\"text\" id=\"REGON-input\" name=\"REGON-n\"/> <br> <br>\r\n");
      out.write("    Dodatkowe informacje: <input type=\"text\" id=\"dodatek-input\" name=\"dodatek-n\"/> <br> <br>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"submit\" id=\"send-button\" value=\"Send\"/>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
