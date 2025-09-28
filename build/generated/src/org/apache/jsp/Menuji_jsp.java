package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menuji_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Farmer's Market</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            height: 100vh;\n");
      out.write("            /*background: url('c336a7a4-0d90-4906-9690-947a02dc3acd.png') no-repeat center center fixed;*/\n");
      out.write("            background-size: cover;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            background-image: url('agro2.png');\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-around;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            width: 100%;\n");
      out.write("            max-width: 1400px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .circle-link {\n");
      out.write("    width: 280px;\n");
      out.write("    height: 280px;\n");
      out.write("    border-radius: 50%;\n");
      out.write("    background-color: rgba(255, 204, 0, 0.9);\n");
      out.write("    box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);\n");
      out.write("    text-align: center;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    margin: 20px;\n");
      out.write("            transition: transform 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .circle-link:hover {\n");
      out.write("            transform: scale(1.05);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .circle-link a {\n");
      out.write("            display: block;\n");
      out.write("            width: 100%;\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 24px;\n");
      out.write("            padding-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @media (max-width: 768px) {\n");
      out.write("            .circle-link {\n");
      out.write("                width: 220px;\n");
      out.write("                height: 220px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .circle-link a {\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @media (max-width: 480px) {\n");
      out.write("            .container {\n");
      out.write("                flex-direction: column;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .circle-link {\n");
      out.write("                width: 200px;\n");
      out.write("                height: 200px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"circle-link\">\n");
      out.write("            <a href=\"flogin.jsp\">FARMER</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"circle-link\">\n");
      out.write("            <a href=\"CustomerDashboard.jsp\">CONSUMER</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
