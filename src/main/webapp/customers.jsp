<%@ page import="hotelapp.CustomerService" %>
<%@ page import="hotelapp.Customers" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <h1>Customer List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Registration Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            CustomerService customerService = new CustomerService();
            List<Customers> customers;
            try {
                customers = customerService.getCustomers();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Customers customer : customers) {
        %>
        <tr>
            <td><%= customer.getCustomerId() %></td>
            <td><%= customer.getfname() %></td>
            <td><%= customer.getlname() %></td>
            <td><%= customer.getAddress() %></td>
            <td><%= customer.getRegistrationDate() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
