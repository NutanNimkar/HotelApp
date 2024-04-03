<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    // Get the hotel ID from the request

    int hotelId = 0; // Initialize hotelId to a default value
    String hotelIdParam = request.getParameter("hotelId");
    if (hotelIdParam != null && !hotelIdParam.isEmpty()) {
        try {
            hotelId = Integer.parseInt(hotelIdParam);
        } catch (NumberFormatException e) {
            // Handle invalid hotelId parameter
            // For example: display an error message or log the error
            e.printStackTrace(); // Or log it to a logging framework
        }
    }

    // Create a message object
    Message msg;

    // Try to delete the hotel
    try {
        // Create an instance of HotelService
        HotelService hotelService = new HotelService();

        // Delete the hotel and get the result message
        String value = hotelService.deleteHotel(hotelId);

        // Check if the deletion was successful or not
        if (value.toLowerCase().contains("error")) {
            // If an error occurred during deletion
            msg = new Message("error", value);
        } else {
            // If the hotel was successfully deleted
            msg = new Message("success", value);
        }
    } catch (Exception e) {
        // If an exception occurred during the deletion process
        msg = new Message("error", "Failed to delete hotel: " + e.getMessage());
    }

    // Create an ArrayList to hold the message
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // Set session attribute to hold the messages
    session.setAttribute("messages", messages);

    // Redirect back to the hotel list page
    response.sendRedirect("../hotel.jsp");
%>
