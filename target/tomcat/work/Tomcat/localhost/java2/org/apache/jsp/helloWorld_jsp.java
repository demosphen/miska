/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2016-07-20 16:53:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class helloWorld_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1468622426000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>JSP page</title>\n");
      out.write("    <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("<nav class=\"navbar navbar-default navbar-inverse\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-0 col-sm-0 col-md-2 col-lg-3\"></div>\n");
      out.write("            <div class=\"col-xs-6 col-md-4 col-md-8 col-lg-6\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Miska.lv</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li><a href=\"#\">info@miska.lv</a></li>\n");
      out.write("                    <li><a href=\"#\">123-456-78</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"navbar-form navbar-left\" role=\"search\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info\">\n");
      out.write("                        Go!\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-xs-0 col-sm-0 col-md-2 col-lg-3\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"row\" id=\"canvas\">\n");
      out.write("        <div class=\"col-xs-0 col-sm-0 col-md-1 col-lg-2\">\n");
      out.write("            <!-- empty space to the left-->\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-xs-6 col-md-4 col-md-10 col-lg-8\" id=\"content\">\n");
      out.write("\n");
      out.write("            <div class=\"col-xs-3 col-sm-2 col-md-2 col-lg-2\" id=\"left-bar\">\n");
      out.write("                <div class = \"panel panel-info\">\n");
      out.write("\n");
      out.write("                <h4>What is Lorem Ipsum?</h4>\n");
      out.write("                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class = \"panel panel-info\">\n");
      out.write("                    <h4>Where does it come from?</h4>\n");
      out.write("                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.</p>\n");
      out.write("                    <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-xs-9 col-sm-10 col-md-10 col-lg-10\" id=\"main\">\n");
      out.write("                <div class=\"row\" id=\"content-header\">\n");
      out.write("                    <div class=\"row panel panel-info\" id=\"canvas\" >\n");
      out.write("                        <h1>");
      out.print( request.getAttribute("model") );
      out.write("</h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"row panel panel-info\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info\" >\n");
      out.write("                            product\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info\" >\n");
      out.write("                            product\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info\" >\n");
      out.write("                            product\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info\" >\n");
      out.write("                            product\n");
      out.write("                        </div>\n");
      out.write("                        product row\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row panel panel-info\">\n");
      out.write("                        another product row\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row panel panel-info\">\n");
      out.write("                        another product row\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-xs-0 col-sm-0 col-md-1 col-lg-2\">\n");
      out.write("            <!-- empy space to the right-->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
