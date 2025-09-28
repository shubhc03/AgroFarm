package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BuyProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    String productId = request.getParameter("product_id");
    String farmerId = request.getParameter("farmer_id");
    String productName = request.getParameter("product_name");
    String price = request.getParameter("price");

    if (productId == null || farmerId == null || productName == null || price == null) {

      out.write("\n");
      out.write("    <p style=\"color:red; text-align:center;\">Invalid product details. Please go back and try again.</p>\n");

        return;
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Buy Product</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: #eafbe7;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("        .buy-form-container {\n");
      out.write("            width: 400px;\n");
      out.write("            margin: 100px auto;\n");
      out.write("            background: white;\n");
      out.write("            padding: 25px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.2);\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #2e8b57;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        input[type=\"number\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            background: #2e8b57;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 25px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background: #246b45;\n");
      out.write("        }\n");
      out.write("        .back-link {\n");
      out.write("            display: block;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: #2e8b57;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"buy-form-container\">\n");
      out.write("    <h2>Buy ");
      out.print( productName );
      out.write("</h2>\n");
      out.write("    <form action=\"PlaceOrderServlet\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print( productId );
      out.write("\">\n");
      out.write("        <input type=\"hidden\" name=\"farmer_id\" value=\"");
      out.print( farmerId );
      out.write("\">\n");
      out.write("        <label>Price: ?");
      out.print( price );
      out.write(" per unit</label><br><br>\n");
      out.write("        <label for=\"quantity\">Enter Quantity:</label>\n");
      out.write("        <input type=\"number\" name=\"quantity\" min=\"1\" required>\n");
      out.write("        <button type=\"submit\">Confirm Order</button>\n");
      out.write("    </form>\n");
      out.write("    <a href=\"CustomerDashboard.jsp\" class=\"back-link\">? Back to Shops</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
