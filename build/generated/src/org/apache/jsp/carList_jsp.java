package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.car.domain.Car;
import com.car.dao.GeneralDao;
import com.car.service.CarServiceImpl;
import com.car.service.CarService;
import com.car.model.CarModel;

public final class carList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("        <h1>car List</h1>\n");
      out.write("        <form>\n");
      out.write("            <table border='1' style='border-collapse:collapse;  margin-left: auto; margin-right: auto;'>\n");
      out.write("                <thead>\n");
      out.write("                    <td>Plate No</td>\n");
      out.write("                    <td>Manufactured Date</td>\n");
      out.write("                    <td>Price</td>\n");
      out.write("                    <td>Institution</td\n");
      out.write("                    <td>Action></td>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    \n");
      out.write("                    ");

                        GeneralDao<Car> carDao = new GeneralDao<Car>(Car.class);
                        
                        for(Car car : carDao.listAll()){
                           
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(car.getPlateNo());
      out.write("</td>\n");
      out.write("                        <td>20154688</td>\n");
      out.write("                        <td>");
      out.print(car.getCost());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(car.getInstutution());
      out.write("</td>\n");
      out.write("                        <td><button>Edit</button></td\n");
      out.write("                        <td><button>Delete</button></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
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
