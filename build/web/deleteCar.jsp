<%-- 
    Document   : deleteCar
    Created on : Jul 6, 2021, 11:29:23 AM
    Author     : emmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Car</title>
    </head>
    <body>
        <%
            String plateNo = request.getParameter("plateNo");
        %>
        <form action="applicationController.do" method="POST">
            <h1>are you sure you want to delete this car <%=plateNo%> ?</h1>
            <input type="hidden" name="plateNo" value="<%=plateNo%>"/>
            <button name="type" value="delete" type="submit">Delete</button>
        </form>
    </body>
</html>
