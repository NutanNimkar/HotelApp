<!-- Display hotels -->
<c:forEach var="hotel" items="${hotels}">
    <p>${hotel.name} - ${hotel.city} - ${hotel.email} - ${hotel.phone}</p>
    <a href="editHotel.jsp?id=${hotel.id}">Edit</a>
    <a href="deleteHotel.jsp?id=${hotel.id}">Delete</a>
</c:forEach>

<!-- Create form -->
<form action="addHotel.jsp" method="post">
    <input type="text" name="name" placeholder="Hotel Name" required>
    <input type="text" name="city" placeholder="City" required>
    <input type="email" name="email" placeholder="Email" required>
    <input type="tel" name="phone" placeholder="Phone" required>
    <button type="submit">Add Hotel</button>
</form>

<!-- Edit form -->
<form action="updateHotel.jsp" method="post">
    <input type="hidden" name="id" value="${hotel.id}">
    <input type="text" name="name" value="${hotel.name}" required>
    <input type="text" name="city" value="${hotel.city}" required>
    <input type="email" name="email" value="${hotel.email}" required>
    <input type="tel" name="phone" value="${hotel.phone}" required>
    <button type="submit">Update Hotel</button>
</form>

<!-- Delete button -->
<form action="deleteHotel.jsp" method="post">
    <input type="hidden" name="id" value="${hotel.id}">
    <button type="submit">Delete</button>
</form>
