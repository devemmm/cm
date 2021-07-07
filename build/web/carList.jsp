<%-- 
    Document   : carList
    Created on : Jul 6, 2021, 11:28:44 AM
    Author     : emmanuel
--%>

<%@page import="java.util.List"%>
<%@page import="com.car.domain.Car"%>
<%@page import="com.car.dao.GeneralDao"%>
<%@page import="com.car.service.CarServiceImpl"%>
<%@page import="com.car.service.CarService"%>
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
        %>
        <form method="POST">
            <table border='1' style='border-collapse:collapse;  margin-left: auto; margin-right: auto;'>
                <thead>
                    <td>Plate No</td>
                    <td>Manufactured Date</td>
                    <td>Price</td>
                    <td>Institution</td>
                    <td>Action</td>
                    <td></td> 
                    
                </thead>
                <tbody>
                    
                    <%
                        GeneralDao<Car> carDao = new GeneralDao<Car>(Car.class);
                        
                        for(Car car : carDao.listAll()){
                           
                    %>
                        <tr>
                            <td><%=car.getPlateNo()%></td>
                            <td><%=car.getManufacturedDate()%></td>
                            <td><%=car.getCost()%></td>
                            <td><%=car.getInstutution()%></td>
                            <td><button><a href="http://localhost:8080/CarManagement/editCar.jsp?plateNo=<%=car.getPlateNo()%>">Edit</a></button></td>
                            <td><button><a href="http://localhost:8080/CarManagement/deleteCar.jsp?plateNo=<%=car.getPlateNo()%>">Delete</a></button></td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
                <button style="margin-left: 50%; margin-top: 10px;"><a href="http://localhost:8080/CarManagement/index.jsp">Back to Car Registration</a></button>
        </form>
    </body>
</html>
