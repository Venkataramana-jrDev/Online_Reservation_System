<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Reservation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('images/pawel-czerwinski-AyG1P85-hIE-unsplash.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #007bff;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-custom {
            width: 100%;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            padding: 10px;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }
        .btn-custom:hover {
            background-color: #0056b3;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book Reservation</h2>
        <form action="/booking" method="post">
            <div class="form-group">
                <label for="fromPlace">From:</label>
                <input type="text" id="fromPlace" name="fromPlace" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="toPlace">To:</label>
                <input type="text" id="toPlace" name="toPlace" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="dateOfJourney">Date of Journey:</label>
                <input type="date" id="dateOfJourney" name="dateOfJourney" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="trainId">Train Id:</label>
                <input type="text" id="trainId" name="trainId" value="${train.id}" class="form-control" />
            </div>
            <button type="submit" class="btn btn-custom">Book</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
