<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel List</title>
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">--%>
    <link rel="stylesheet" href="assets/css/styles.css">
    <%--    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">--%>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <h1>Hotel List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Hotel ID</th>
            <th>Chain ID</th>
            <th>City</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Number of Rooms</th>
            <th>Category</th>
        </tr>
        </thead>
        <tbody>
        <%
            HotelService hotelService = new HotelService();
            List<Hotel> hotels;
            try {
                hotels = hotelService.getHotels();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Hotel hotel : hotels) {
        %>
        <tr>
            <td><%= hotel.getHotelId() %></td>
            <td><%= hotel.getChainId() %></td>
            <td><%= hotel.getCity() %></td>
            <td><%= hotel.getName() %></td>
            <td><%= hotel.getEmail() %></td>
            <td><%= hotel.getPhone() %></td>
            <td><%= hotel.getNumOfRooms() %></td>
            <td><%= hotel.getCategory() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<%--<script src="/assets/js/jquery.min.js"></script>--%>
<%--<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>--%>
</body>
</html>
