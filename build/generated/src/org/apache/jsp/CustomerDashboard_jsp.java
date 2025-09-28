package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class CustomerDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Consumer Home Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"common.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"ConsumerHome.css\">\n");
      out.write("    <style>\n");
      out.write("        .scroll-container {\n");
      out.write("            display: flex;\n");
      out.write("            overflow-x: auto;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            flex: 0 0 auto;\n");
      out.write("            width: 250px;\n");
      out.write("            margin-right: 20px;\n");
      out.write("            background: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .card-img {\n");
      out.write("            width: 100%;\n");
      out.write("            height: 180px;\n");
      out.write("            object-fit: cover;\n");
      out.write("            border-top-left-radius: 10px;\n");
      out.write("            border-top-right-radius: 10px;\n");
      out.write("        }\n");
      out.write("        .card-content {\n");
      out.write("            padding: 15px;\n");
      out.write("        }\n");
      out.write("        .card-content .name {\n");
      out.write("            font-size: 18px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .card-content .city {\n");
      out.write("            font-size: 14px;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("        .btn {\n");
      out.write("            display: inline-block;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            background: green;\n");
      out.write("            color: white;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        .heading2 {\n");
      out.write("            font-size: 22px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            padding-left: 20px;\n");
      out.write("            margin-top: 40px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Navbar -->\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <div class=\"nav logo\"><img src=\"logo.png\" alt=\"Logo\"></div>\n");
      out.write("        <div class=\"nav\">Home</div>\n");
      out.write("        <div class=\"nav\">Shop</div>\n");
      out.write("          \n");
      out.write("     ");

    HttpSession session1 = request.getSession(false); // Don't create a new session if one doesn't exist
    if (session1 == null || session1.getAttribute("customer_id") == null) {
        
        
      out.write("\n");
      out.write("          <a href=\"clogin.jsp\"> <div class=\"nav1\">login/sign-up</div></a>\n");
      out.write("        ");

//        response.sendRedirect("clogin.jsp"); // Redirect to login page
//        return;
    }
    String customer_id = String.valueOf(session1.getAttribute("customer_id"));

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("         <div class=\"nav2 search\">\n");
      out.write("            <input type=\"search\" placeholder=\"Search farmers or products...\">\n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Main Container -->\n");
      out.write("    <div id=\"main\">\n");
      out.write("\n");
      out.write("        <!-- Farmer Shops -->\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"heading2\">Farmer Shops</div>\n");
      out.write("            <div class=\"scroll-container\">\n");
      out.write("                ");

                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

//                        HttpSession session1 = request.getSession();
//                        String customer_id = String.valueOf(session1.getAttribute("customer_id"));

                        ps = con.prepareStatement("SELECT * FROM farmers");
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            int farmerId = rs.getInt("farmer_id");
                            String name = rs.getString("name");
                            String location = rs.getString("location");
                
      out.write("\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <img src=\"ShopImageServlet?farmer_id=");
      out.print( farmerId );
      out.write("\" alt=\"Farmer Image\" class=\"card-img\">\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <div class=\"name\">");
      out.print( name );
      out.write("</div>\n");
      out.write("                            <div class=\"city\">");
      out.print( location );
      out.write("</div>\n");
      out.write("                            <a href=\"ViewProducts.jsp?farmerId=");
      out.print( farmerId );
      out.write("&customer_id=");
      out.print( customer_id );
      out.write("\" class=\"btn\">Visit Shop</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (Exception e) {}
                        try { if (ps != null) ps.close(); } catch (Exception e) {}
                        try { if (con != null) con.close(); } catch (Exception e) {}
                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Static Product Sections (Optional) -->\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"heading2\">Fresh Vegetables</div>\n");
      out.write("            <div class=\"scroll-container\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <img src=\"veg1.jpg\" alt=\"Tomato\" class=\"card-img\">\n");
      out.write("                    <div class=\"card-content\">\n");
      out.write("                        <div class=\"name\">Tomato</div>\n");
      out.write("                        <div class=\"city\">?20/kg</div>\n");
      out.write("                        <a href=\"#\" class=\"btn\">Buy</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"heading2\">Fresh Fruits</div>\n");
      out.write("            <div class=\"scroll-container\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <img src=\"fruit1.jpg\" alt=\"Apple\" class=\"card-img\">\n");
      out.write("                    <div class=\"card-content\">\n");
      out.write("                        <div class=\"name\">Apple</div>\n");
      out.write("                        <div class=\"city\">?100/kg</div>\n");
      out.write("                        <a href=\"#\" class=\"btn\">Buy</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
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
