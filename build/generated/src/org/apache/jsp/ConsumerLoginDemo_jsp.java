package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.Base64;

public final class ConsumerLoginDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Available Farmer Shops</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #eef2f3;\n");
      out.write("            padding: 20px;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("        }\n");
      out.write("        .shop-container {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: center;\n");
      out.write("            gap: 20px;\n");
      out.write("        }\n");
      out.write("        .shop-card {\n");
      out.write("            background-color: white;\n");
      out.write("            width: 300px;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0,0,0,0.1);\n");
      out.write("            overflow: hidden;\n");
      out.write("            transition: transform 0.2s ease-in-out;\n");
      out.write("        }\n");
      out.write("        .shop-card:hover {\n");
      out.write("            transform: scale(1.03);\n");
      out.write("        }\n");
      out.write("        .shop-image {\n");
      out.write("            width: 100%;\n");
      out.write("            height: 200px;\n");
      out.write("            object-fit: cover;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("        .shop-details {\n");
      out.write("            padding: 15px;\n");
      out.write("        }\n");
      out.write("        .shop-details h3 {\n");
      out.write("            margin-top: 0;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        .shop-details p {\n");
      out.write("            margin: 5px 0;\n");
      out.write("            color: #444;\n");
      out.write("        }\n");
      out.write("        .visit-button {\n");
      out.write("            display: block;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 6px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("        .visit-button:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <h2>Explore Farmer Shops</h2>\n");
      out.write("\n");
      out.write("    <div class=\"shop-container\">\n");
      out.write("        ");

            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

                String query = "SELECT id, FullName, FarmAddress, MainCrops, shop_image FROM FarmerRegistration1";
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    int farmerId = rs.getInt("id");
                    String name = rs.getString("FullName");
                    String address = rs.getString("FarmAddress");
                    String crops = rs.getString("MainCrops");

                    InputStream imageStream = rs.getBinaryStream("shop_image");
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = imageStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    String base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"shop-card\">\n");
      out.write("            <img src=\"data:image/jpeg;base64,");
      out.print( base64Image );
      out.write("\" class=\"shop-image\" />\n");
      out.write("            <div class=\"shop-details\">\n");
      out.write("                <h3>");
      out.print( name );
      out.write("</h3>\n");
      out.write("                <p><strong>Address:</strong> ");
      out.print( address );
      out.write("</p>\n");
      out.write("                <p><strong>Main Crops:</strong> ");
      out.print( crops );
      out.write("</p>\n");
      out.write("                <a class=\"visit-button\" href=\"FarmerShop.jsp?farmerId=");
      out.print( farmerId );
      out.write("\">Visit Shop</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

                }
            } catch (Exception e) {
                out.println("<p style='color:red; text-align:center;'>Error: " + e.getMessage() + "</p>");
                e.printStackTrace();
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        
      out.write("\n");
      out.write("    </div>\n");
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
