<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Hotel" %>
<%@ page import="hotelapp.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    // Get hotel info from the request
    int hotelId = Integer.parseInt(request.getParameter("id"));
    int chainId = Integer.parseInt(request.getParameter("chainid"));
    String city = request.getParameter("city");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String street = request.getParameter("street");
    int numOfRooms = request.getParameter("numOfRooms");
    String category = request.getParameter("category");

    // Create a new Hotel object
    Hotel updatedHotel = new Hotel(hotelId, chainId, city, name, email, phone, street, numOfRooms, category);



    // Create an instance of HotelService
    HotelService hotelService = new HotelService();

    // Create a message object
    Message msg;

    // Try to update the hotel
    try {
        String value = hotelService.updateHotel(updatedHotel);
        if (value.toLowerCase().contains("error")) {
            msg = new Message("error", value);
        } else {
            msg = new Message("success", value);
        }
    } catch (Exception e) {
        msg = new Message("error", "Failed to update hotel: " + e.getMessage());
    }

    // Create an ArrayList to hold the message
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // Set session attribute to hold the messages
    session.setAttribute("messages", messages);

    // Redirect back to the hotel list page
    response.sendRedirect("hotel.jsp");
%>
