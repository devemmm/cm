<%-- 
    Document   : index
    Created on : Jul 6, 2021, 11:28:06 AM
    Author     : emmanuel
--%>

<%@page import="com.car.model.CarModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Registration</title>
    </head>
    <body>
        
        <%
          CarModel carModel = (CarModel) request.getAttribute("carModel");
          
          if(carModel == null){
              carModel = new CarModel();
              request.setAttribute("carModel", carModel);
          }
        %>
        <h1>Car Management Registration</h1>
        <form action="applicationController.do" method="POST">
            <table>
                <label><%=carModel.getSystemMsg()%></label>
                <tr>
                    <td>Plate No</td>
                    <td><input type="text" name="plateNo" id="plateNo" value="<%=carModel.getInputPlateNo()%>" required/></td>
                    <td style="color: red"><%=carModel.getPlateNoMsg()%></td>
                </tr>
                 <tr>
                    <td>Manufactured Date: </td>
                    <td><input type="date" name="manufacturedDate" id="manufacturedDate" value="<%=carModel.getInputManufacturedDate()%>"/></td>
                    <td style="color: red"><%=carModel.getManaufactureDateMsg()%></td>
                 </tr>
                 <tr>
                    <td>Price:</td>
                    <td><input type="number" name="cost" id="cost" value="<%=carModel.getPrice()%>"/></td>
                    <td style="color: red"><%=carModel.getPriceMessage()%></td>
                 </tr>
                 <tr>
                    <td>Institution: </td>
                    <td>
                        <select name="institution" id="institution">
                            <option value="AUCA">AUCA</option>
                            <option value="SONARWA">SONARWA</option>
                        </select>
                    </td>
                 </tr>
                <tr>
                    <td></td>
                    <td><button name="type" value="save" type="submit">Save</button></td>
                    <td><button><a href="http://localhost:8080/CarManagement/carList.jsp">Go to Car List</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
