<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hotelapp.HotelService" %>
<%@ page import="hotelapp.Hotel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="hotelapp.Message" %>

<%
    // Process request parameters if any
    String action = request.getParameter("action");

    // Create a message object
    Message msg;

    // Perform CRUD operations based on action
    if (action != null) {
        HotelService hotelService = new HotelService();
        switch (action) {
            case "delete":
                // get the hotel id that was sent
                int hotelId = Integer.parseInt(request.getParameter("id"));
                // Delete hotel
                try {
                    msg = new Message("success", hotelService.deleteHotel(hotelId));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "add":
                // Extract parameters for the new hotel
                int newHotelId = Integer.parseInt(request.getParameter("hotelId"));
                int chainId = Integer.parseInt(request.getParameter("chainId"));
                String city = request.getParameter("city");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                int numOfRooms = Integer.parseInt(request.getParameter("numOfRooms"));
                String category = request.getParameter("category");
                // Create a new Hotel object
                Hotel newHotel = new Hotel(newHotelId, chainId, city, name, email, phone, numOfRooms, category);
                // Add hotel
                try {
                    msg = new Message("success", hotelService.addHotel(newHotel));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                // Extract parameters for the updated hotel
                int updatedHotelId = Integer.parseInt(request.getParameter("hotelId"));
                int updatedChainId = Integer.parseInt(request.getParameter("chainId"));
                String updatedCity = request.getParameter("city");
                String updatedName = request.getParameter("name");
                String updatedEmail = request.getParameter("email");
                String updatedPhone = request.getParameter("phone");
                int updatedNumOfRooms = Integer.parseInt(request.getParameter("numOfRooms"));
                String updatedCategory = request.getParameter("category");
                // Create a new Hotel object
                Hotel updatedHotel = new Hotel(updatedHotelId, updatedChainId, updatedCity, updatedName, updatedEmail, updatedPhone, updatedNumOfRooms, updatedCategory);
                // Update hotel
                try {
                    msg = new Message("success", hotelService.updateHotel(updatedHotel));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            // Add more cases for other CRUD operations if needed
            default:
                msg = new Message("error", "Invalid action.");
        }
    } else {
        msg = new Message("error", "No action specified.");
    }

    // Create a list to hold the message
    List<Message> messages = new ArrayList<>();
    messages.add(msg);

    // Set session attribute to hold the messages
    session.setAttribute("messages", messages);

    // Redirect back to the hotel list page
    response.sendRedirect("hotel.jsp");
%>
