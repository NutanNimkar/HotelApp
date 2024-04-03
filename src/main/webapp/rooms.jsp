<%@ page import="hotelapp.RoomsService" %>
<%@ page import="hotelapp.Rooms" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms List</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.bookRoomBtn').click(function() {
                // Remove the button
                $(this).remove();
                // Show an alert
                alert('Booking confirmed!');
            });
        });
    </script>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <h1>Rooms List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Rooms ID</th>
            <th>Hotel ID</th>
            <th>Sea View</th>
            <th>Mountain View</th>
            <th>Amenities</th>
            <th>Is Single</th>
            <th>Is Extended</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            RoomsService roomsService = new RoomsService();
            List<Rooms> rooms;
            try {
                rooms = roomsService.getRooms();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Rooms room : rooms) {
        %>
        <tr>
            <td><%= room.getRoomId() %></td>
            <td><%= room.getHotelId() %></td>
            <td><%= room.isSeaView() ? "Yes" : "No" %></td>
            <td><%= room.isMountainView() ? "Yes" : "No" %></td>
            <td><%= room.getAmenties() %></td>
            <td><%= room.isSingle() ? "Yes" : "No" %></td>
            <td><%= room.isExtended() ? "Yes" : "No" %></td>
            <td>
                <% if (Math.random() < 0.5) { %>
                    <button type="button" class="btn btn-primary bookRoomBtn" data-roomid="<%= room.getRoomId() %>">Book</button>
                <% } %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
