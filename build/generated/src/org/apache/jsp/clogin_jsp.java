package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class clogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     \n");
      out.write("        <link rel=\"stylesheet\" href=\"asp.css\"></link>\n");
      out.write("        \n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("             \n");
      out.write("            <center>\n");
      out.write("            <div>\n");
      out.write("                <form action=\"ConsumerLoginDemo.jsp\">\n");
      out.write("                    <table cellpadding=\"15px\" cellspacing=\"20px\"  style=\"margin-top:400px;\">\n");
      out.write("                          <tr>\n");
      out.write("                     \n");
      out.write("                             <th colspan=\"2\" style=\"font-weight:bold; font-color:blue; font-size: 50px\">Consumer Login Page</th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h1>Enter Name:</h1></td>\n");
      out.write("                            <td><h1><input type=\"text\" name=\"u1\" placeholder=\"Enter Name\"></h1></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h1>Enter Password:</h1></td>\n");
      out.write("                                <td><h1><input type=\"password\" name=\"u2\" placeholder=\"Enter Password\"></h1></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th colspan=\"2\"><h1><input type=\"submit\" value=\"Login\" class=\"B\"></h1></th>\n");
      out.write("                                  \n");
      out.write("                                    </tr>\n");
      out.write("                                       <tr>\n");
      out.write("                     \n");
      out.write("                             <th colspan=\"2\">Don't have an account..? <a href=\"cregistration.jsp\" style=\"text-decoration:crimson\">Registration</a></th>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                </center>\n");
      out.write("        </body>\n");
      out.write("        </html>");
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
