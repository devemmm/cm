package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.car.model.CarModel;

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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Car Registration</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

          CarModel carModel = (CarModel) request.getAttribute("carModel");
          
          if(carModel == null){
              carModel = new CarModel();
              request.setAttribute("carModel", carModel);
          }
        
      out.write("\n");
      out.write("        <h1>Car Management Registration</h1>\n");
      out.write("        <form action=\"applicationController.do\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <label>");
      out.print(carModel.getSystemMsg());
      out.write("</label>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Plate No</td>\n");
      out.write("                    <td><input type=\"text\" name=\"plateNo\" id=\"plateNo\" value=\"");
      out.print(carModel.getInputPlateNo());
      out.write("\" required/></td>\n");
      out.write("                    <td style=\"color: red\">");
      out.print(carModel.getPlateNoMsg());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>Manufactured Date: </td>\n");
      out.write("                    <td><input type=\"date\" name=\"manufacturedDate\" id=\"manufacturedDate\" value=\"");
      out.print(carModel.getInputManufacturedDate());
      out.write("\"/></td>\n");
      out.write("                    <td style=\"color: red\">");
      out.print(carModel.getManaufactureDateMsg());
      out.write("</td>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>Price:</td>\n");
      out.write("                    <td><input type=\"number\" name=\"cost\" id=\"cost\" value=\"");
      out.print(carModel.getPrice());
      out.write("\"/></td>\n");
      out.write("                    <td style=\"color: red\">");
      out.print(carModel.getPriceMessage());
      out.write("</td>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>Institution: </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"institution\" id=\"institution\">\n");
      out.write("                            <option value=\"AUCA\">AUCA</option>\n");
      out.write("                            <option value=\"SONARWA\">SONARWA</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                 </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><button name=\"type\" value=\"save\" type=\"submit\">Save</button></td>\n");
      out.write("                    <td><button><a href=\"http://localhost:8080/CarManagement/carList.jsp\">Go to Car List</a></button></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
