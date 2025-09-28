package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("        #mymenu {\n");
      out.write("            background-color: rgba(0, 0, 0, 0.4);\n");
      out.write("            color: gray;\n");
      out.write("            text-align: right;\n");
      out.write("            box-shadow: 15px 15px 15px blanchedalmond;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #mymenu:hover {\n");
      out.write("            background-color: rgba(0, 0, 0, 0.8);\n");
      out.write("            color: gray;\n");
      out.write("            text-align: right;\n");
      out.write("            box-shadow: 20px 20px 20px #330033;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #mymenu ul li {\n");
      out.write("            display: inline-block;\n");
      out.write("            background: blue;\n");
      out.write("            color: black;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #mymenu ul li:hover {\n");
      out.write("            background: white;\n");
      out.write("            padding:5px;\n");
      out.write("            color: #330033;\n");
      out.write("            box-shadow: 20px 20px 20px blanchedalmond;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"mymenu\">\n");
      out.write("            <ul>\n");
      out.write("                <li>Home</li>\n");
      out.write("                <li>Registration</li>\n");
      out.write("                <li>Login</li>\n");
      out.write("                <li>Logout</li>\n");
      out.write("                <li>Menu</li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
