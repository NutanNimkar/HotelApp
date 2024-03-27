<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Home Page </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">--%>
    <link rel="stylesheet" href="assets/css/sandbox.css">
    <link rel="stylesheet" href="assets/css/styles.css">
<%--    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">--%>
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container" id="row-container">
    <div class="row" id="row">
        <div class="col-md-4">
            <div class="card" id="rooms-card">
                <div class="textOL">
                    <h4 class="card-title">Rooms</h4>
                    <p class="card-text">View and manage rooms</p>
                    <a class="btn btn-primary" href="rooms.jsp">View Rooms</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" id="bookings-card">
                <div class="testerBox1">
                    <h4 class="card-title">Bookings</h4>
                    <p class="card-text">View and manage bookings</p>
                    <a class="btn btn-primary" href="bookings.jsp">View Bookings</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" id="customers-card">
                <div class="testerBox1">
                    <h4 class="card-title">Customers</h4>
                    <p class="card-text">View and manage customers</p>
                    <a class="btn btn-primary" href="customers.jsp">View Customers</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row" id="row-2">
        <div class="col-md-4">
            <div class="card" id="employees-card">
                <div class="testerBox1">
                    <h4 class="card-title">Employees</h4>
                    <p class="card-text">View and manage employees</p>
                    <a class="btn btn-primary" href="employees.jsp">View Employees</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" id="hotels-card">
                <div class="textOL">
                    <h4 class="card-title">Hotels</h4>
                    <p class="card-text">View and manage hotels</p>
                    <a class="btn btn-primary" href="hotel.jsp">View Hotels</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" id="hotel-chains-card">
                <div class="testerBox1">
                    <h4 class="card-title">Hotel Chains</h4>
                    <p class="card-text">View and manage hotel chains</p>
                    <a class="btn btn-primary" href="hotelchains.jsp">View Hotel Chains</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

<script>
    $(document).ready(function() {
        toastr.options = {
            "closeButton": true,
            "positionClass": "toast-bottom-right",
            "preventDuplicates": false
        };
        /* In order to access variables sent to ejs file to script you must Parse them to string */
        /* then to parse them back to JSON */
        let messages = document.getElementById("message").value;
        if (messages !== "") messages = JSON.parse("[" + messages.slice(0, -1) + "]");
        else messages = [];

        messages
            .forEach(({
                          type,
                          value
                      }) => {
                switch (type) {
                    case "error":
                        toastr.error(value)
                        break;
                    case "success":
                        toastr.success(value)
                        break;
                    case "warning":
                        toastr.warning(value)
                        break;
                    default:
                        toastr.info(value)
                        break;
                }
            });
    })
</script>
</body>

</html>
