<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancellation Confirmation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #ff6347;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #333;
        }
        .btn-custom {
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #ff6347;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }
        .btn-custom:hover {
            background-color: #e5533d;
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Cancellation Confirmation</h2>

        <c:choose>
            <c:when test="${not empty message}">
                <p>${message}</p>
            </c:when>
            <c:otherwise>
                <p>${error}</p>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/Dashboard" class="btn-custom">Go to Dashboard</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
