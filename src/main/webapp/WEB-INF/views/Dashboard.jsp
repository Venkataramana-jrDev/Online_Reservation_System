<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
    <style>
        body {
            background-image: url('images/rocky-xiong-lvIY0YrCiEI-unsplash.jpg'); 
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            color: #343a40;
        }
        table {
            width: 100%;
        }
        th, td {
            padding: 15px;
            text-align: left;
            vertical-align: middle;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td {
            background-color: #f8f9fa;
        }
        .actions a {
            margin-right: 15px;
            text-decoration: none;
            color: #007bff;
        }
        .actions a:hover {
            text-decoration: underline;
        }
        .no-reservations {
            color: #dc3545;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome, ${loggedInUser.username}</h1>
    <h2>Your Reservations</h2>

    <c:if test="${empty reservations}">
        <p class="no-reservations">You have no reservations at the moment.</p>
    </c:if>

    <c:if test="${not empty reservations}">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>PNR Number</th>
                    <th>Train Name</th>
                    <th>Date of Journey</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reservation" items="${reservations}">
                    <tr>
                        <td>${reservation.pnrNumber}</td>
                        <td>${reservation.train.trainName}</td>
                        <td>${reservation.dateOfJourney}</td>
                        <td>${reservation.fromPlace}</td>
                        <td>${reservation.toPlace}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty reservation.cancellation}">
                                    ${reservation.cancellation.status}
                                </c:when>
                                <c:otherwise>
                                    Active
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="actions">
        <a href="<c:url value='/book'/>">Book a New Reservation</a> |
        <a href="<c:url value='/cancel'/>">Cancel a Reservation</a> |
        <a href="<c:url value='/login'/>">Logout</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
