<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel List</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div id="editModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Edit Hotel</h4>
            </div>
            <div class="modal-body">
                <form id="modal-form">
                    <div style="text-align: center;">
                        <br><input type="number" name="id" id="id" readonly> Hotel ID</br>
                        <input type="text" name="chainid" id="chainid" readonly> Chain ID</br>
                        <input type="text" name="city" id="city"> City</br>
                        <input type="text" name="name" id="name"> Name</br>
                        <input type="text" name="email" id="email"> Email</br>
                        <input type="text" name="phone" id="phone"> Phone</br>
                        <input type="text" name="numofrooms" id="numofrooms"> NumofRooms</br>
                        <input type="text" name="street" id="street"> Street</br>
                        <input type="text" name="category" id="category">Category
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" form="modal-form" class="btn btn-success">Update</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<div class="container">
    <h1>Hotel List</h1>
    <form action="" method="get">
        <div class="filter-section">
            <label for="chainIdFilter">Filter by Chain ID:</label>
            <input type="text" id="chainIdFilter" name="chainId"/>
            <button type="submit">Filter</button>
        </div>
    </form>
    <div class="table-responsive">
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
            <th>Street</th>
            <th>Category</th>
        </tr>
        </thead>
        <tbody>
        <%
            HotelService hotelService = new HotelService();
            String chainIdParam = request.getParameter("chainId");
            Integer chainId = chainIdParam != null ? Integer.valueOf(chainIdParam) : null;
            List<Hotel> hotels;
            try {
                hotels = hotelService.getHotels(chainId);
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
            <td><%= hotel.getStreet()%></td>
            <td><%= hotel.getCategory() %></td>
            <td>
                <a type="button" onclick="setModalFields(this)"
                   data-toggle="modal"
                   data-id="<%= hotel.getHotelId() %>"
                   data-chainid="<%= hotel.getChainId() %>"
                   data-city="<%= hotel.getCity() %>"
                   data-name="<%= hotel.getName() %>"
                   data-email="<%= hotel.getEmail() %>"
                   data-phone="<%= hotel.getPhone() %>"
                   data-numofrooms="<%= hotel.getNumOfRooms() %>"
                   data-street="<%= hotel.getStreet() %>"
                   data-category="<%= hotel.getCategory() %>"
                   data-target="#editModal">
                <i class="fa fa-edit"></i>
                </a>



            </td>
            <form method="POST" action="HotelControllers/hotel-delete-controller.jsp">
                <td>
                    <input type="hidden" value="<%= hotel.getHotelId() %>" name="hotelId" />
                    <button style="all: unset; cursor: pointer;" type="submit"><i class="fa fa-trash"></i></button>
                </td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
    </div>
</div>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script src="/assets/js/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<script>
    function setModalFields(row) {
        var idElement = document.getElementById("id");
        var chainIdElement = document.getElementById("chainid");
        var cityElement = document.getElementById("city");
        var nameElement = document.getElementById("name");
        var emailElement = document.getElementById("email");
        var phoneElement = document.getElementById("phone");
        var streetElement = document.getElementById("numofrooms"); // Updated to match "numofrooms" dataset attribute
        var numOfRoomsElement = document.getElementById("street"); // Updated to match "street" dataset attribute
        var categoryElement = document.getElementById("category");
        idElement.value = row.dataset.id;
        chainIdElement.value = row.dataset.chainid;
        cityElement.value = row.dataset.city;
        nameElement.value = row.dataset.name;
        emailElement.value = row.dataset.email;
        phoneElement.value = row.dataset.phone;
        streetElement.value = row.dataset.street; // Updated to match "street" dataset attribute
        numOfRoomsElement.value = row.dataset.numofrooms; // Updated to match "numofrooms" dataset attribute
        categoryElement.value = row.dataset.category;
        document.getElementById("modal-form").action = "hotel-update-controller.jsp";
        document.getElementById("modal-form").method = "POST";
    }


</script>
</body>
</html>
