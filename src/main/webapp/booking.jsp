<%@ page import="hotelapp.BookingService" %>
<%@ page import="hotelapp.Booking" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking List</title>
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">--%>
    <link rel="stylesheet" href="assets/css/styles.css">
    <%--    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">--%>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container mt-3">
    <h1>Booking List</h1>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Booking ID</th>
            <th>Customer ID</th>
            <th>Room ID</th>
            <th>Booking Date</th>
            <th>Check-In Date</th>
            <th>Check-Out Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            BookingService bookingService = new BookingService();
            List<Booking> bookings;
            try {
                bookings = bookingService.getBookings();
                for (Booking booking : bookings) {
        %>
        <tr>
            <td><%= booking.getBookingId() %></td>
            <td><%= booking.getCustomerId() %></td>
            <td><%= booking.getRoomId() %></td>
            <td><%= booking.getBookingDate().toString() %></td>
            <td><%= booking.getCheckInDate().toString() %></td>
            <td><%= booking.getCheckOutDate().toString() %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <tr>
            <td colspan="6">Error retrieving bookings: <%= e.getMessage() %></td>
        </tr>
        <%
            }
        %>
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
