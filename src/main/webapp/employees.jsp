<%@ page import="hotelapp.EmployeesService" %>
<%@ page import="hotelapp.Employees" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <h1>Employee List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>SSN</th>
            <th>Role</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Street</th>
            <th>City</th>
            <th>Manager SSN</th>
            <th>Hotel ID</th>
        </tr>
        </thead>
        <tbody>
        <%
            EmployeesService employeeService = new EmployeesService();
            List<Employees> employees;
            try {
                employees = employeeService.getEmployees();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Employees employee : employees) {
        %>
        <tr>
            <td><%= employee.getSsn() %></td>
            <td><%= employee.getRole() %></td>
            <td><%= employee.getfname() %></td>
            <td><%= employee.getlname() %></td>
            <td><%= employee.getStreet() %></td>
            <td><%= employee.getCity() %></td>
            <td><%= employee.getManagerSsn() %></td>
            <td><%= employee.getHotelId() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
