<%@ page import="hotelapp.RoomsService" %>
<%@ page import="hotelapp.Rooms" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms List</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
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
            <th>Problems</th>
        </tr>
        </thead>
        <tbody>
        <%
            RoomsService RoomsService = new RoomsService();
            List<Rooms> Rooms;
            try {
                Rooms = RoomsService.getRooms();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Rooms Room : Rooms) {
        %>
        <tr>
            <td><%= Room.getRoomId() %></td>
            <td><%= Room.getHotelId() %></td>
            <td><%= Room.isSeaView() %></td>
            <td><%= Room.isMountainView() %></td>
            <td><%= Room.getAmenities() %></td>
            <td><%= Room.isSingle() %></td>
            <td><%= Room.isExtended() %></td>
            <td><%= Room.getProblems() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
