<%-- 
    Document   : editCar
    Created on : Jul 6, 2021, 11:29:09 AM
    Author     : emmanuel
--%>

<%@page import="com.car.domain.Car"%>
<%@page import="com.car.dao.GeneralDao"%>
<%@page import="com.car.model.CarModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
          CarModel carModel = (CarModel) request.getAttribute("carModel");
          
          if(carModel == null){
              carModel = new CarModel();
              request.setAttribute("carModel", carModel);
          }
          
          GeneralDao<Car> carDao = new GeneralDao<Car>(Car.class);
          
          Car car = carDao.findBySTRING_PK(request.getParameter("plateNo"));
        %>
        <h1>Car Management Registration</h1>
        <form action="applicationController.do" method="POST">
            <table>
                <tr>
                    <td>Plate No</td>
                    <td><input type="text" name="plateNo" id="plateNo" value="<%=car.getPlateNo()%>" disabled="true"/></td>
                    <td><%=carModel.getPlateNoMsg()%></td>
                </tr>
                 <tr>
                    <td>Manufactured Date: </td>
                    <td><input type="date" name="manufacturedDate" id="manufacturedDate" value="<%=car.getManufacturedDate()%>"/></td>
                    <td><%=carModel.getManaufactureDateMsg()%></td>
                 </tr>
                 <tr>
                    <td>Price:</td>
                    <td><input type="number" name="cost" id="cost" value="<%=car.getCost()%>"/></td>
                    <td><%=carModel.getPriceMessage()%></td>
                 </tr>
                 <tr>
                    <td>Institution: </td>
                    <td><input type="text" name="institution" id="institution" value="<%=car.getInstutution()%>" required/></td>
                    <td><%=carModel.getInstitutionMsg()%></td>
                 </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" name="type" value="edit">Edit</button></td>
                    <td><button><a href="http://localhost:8080/CarManagement/carList.jsp">Go to Car List</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
