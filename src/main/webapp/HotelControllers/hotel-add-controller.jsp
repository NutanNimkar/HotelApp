<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Hotel" %>
<%@ page import="hotelapp.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    // Get values from the request
    int hotelId = Integer.parseInt(request.getParameter("hotelId"));
    String name = request.getParameter("name");
    String city = request.getParameter("city");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    int chainId = Integer.parseInt(request.getParameter("chainId"));
    int numOfRooms = Integer.parseInt(request.getParameter("numOfRooms"));
    String category = request.getParameter("category");

    // Create a new Hotel object
    Hotel newHotel = new Hotel(hotelId, chainId, city, name, email, phone, numOfRooms, category);

    // Create an instance of HotelService
    HotelService hotelService = new HotelService();

    // Create a message object
    Message msg;

    // Try to add the new hotel
    try {
        String value = hotelService.addHotel(newHotel);
        if (value.toLowerCase().contains("error")) {
            msg = new Message("error", value);
        } else {
            msg = new Message("success", value);
        }
    } catch (Exception e) {
        msg = new Message("error", "Failed to add hotel: " + e.getMessage());
    }

    // Create an ArrayList to hold the message
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // Set session attribute to hold the messages
    session.setAttribute("messages", messages);

    // Redirect back to the hotel list page
    response.sendRedirect("hotel.jsp");
%>
