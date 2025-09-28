<%@ page import="javax.servlet.http.*,java.sql.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Feedback</title>
    <style>
        body {
            background: linear-gradient(to right, #c1dfc4, #deecdd);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 0;
            margin: 0;
        }
        .feedback-form {
            max-width: 600px;
            margin: 60px auto;
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
        }
        .feedback-form h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #2c3e50;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 15px 0 5px;
        }
        textarea, select {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
            resize: none;
            font-size: 14px;
        }
        .btn {
            margin-top: 25px;
            width: 100%;
            padding: 12px;
            border: none;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 6px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<%
    // Assume farmer_id is passed via URL or stored in session
    String farmerIdStr = request.getParameter("farmer_id");
    if (farmerIdStr == null && session.getAttribute("farmer_id") != null) {
        farmerIdStr = String.valueOf(session.getAttribute("farmer_id"));
    }

    if (farmerIdStr == null) {
%>
    <h3 style="text-align:center; color:red;">Farmer ID not specified.</h3>
<%
    } else {
%>

<div class="feedback-form">
    <h2>Send Feedback</h2>
    <form action="SendFeedbackServlet" method="post">
        <input type="hidden" name="farmer_id" value="<%= farmerIdStr %>" />

        <label for="rating">Rating (1 to 5):</label>
        <select name="rating" id="rating" required>
            <option value="">-- Select Rating --</option>
            <option value="1">1 *</option>
            <option value="2">2 **</option>
            <option value="3">3 ***</option>
            <option value="4">4 ****</option>
            <option value="5">5 *****</option>
        </select>

        <label for="message">Feedback Message:</label>
        <textarea name="message" id="message" rows="5" required></textarea>

        <button type="submit" class="btn">Submit Feedback</button>
    </form>
</div>

<%
    }
%>

</body>
</html>
