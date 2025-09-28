<%@ page import="java.sql.*" %>
<%
    String farmerId = request.getParameter("farmerId");
    String customerName = request.getParameter("customerName");
    String customerMobile = request.getParameter("customerMobile");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Feedback</title>
    <style>
        body {
            font-family: Arial;
            background: url('images/feedback_bg.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .container {
            width: 90%;
            max-width: 500px;
            margin: 80px auto;
            padding: 30px;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        label {
            font-weight: bold;
        }
        input, textarea {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type=submit] {
            background: #3498db;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>We value your feedback!</h2>
        <form action="SubmitFeedbackServlet" method="post">
            <input type="hidden" name="farmerId" value="<%= farmerId %>">
            <input type="hidden" name="customerName" value="<%= customerName %>">
            <input type="hidden" name="customerMobile" value="<%= customerMobile %>">

            <label>Rating (1 to 5):</label>
            <input type="number" name="rating" min="1" max="5" required>

            <label>Your Feedback:</label>
            <textarea name="message" rows="4" required></textarea>

            <input type="submit" value="Submit Feedback">
        </form>
    </div>
</body>
</html>
