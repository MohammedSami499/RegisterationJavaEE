<%-- 
    Document   : employeedetails
    Created on : Jun 16, 2022, 1:47:23 PM
    Author     : Samy
--%>

<%@page import="net.javaguide.registeration.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Details</h1>
        
        <%
        
         Employee emp = (Employee) request.getAttribute("emp");
         
        %>
        
        <h1> The emp Contact Company</h1> : <h1> <%= emp.getContactCompany().toString() %> </h1>
    </body>
</html>
