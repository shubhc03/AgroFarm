<%@ page import="java.sql.*" %>
<%
    String farmerId = request.getParameter("farmerId");
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Customer Feedback</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('images/feedback_bg.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 60px auto;
            background: rgba(255,255,255,0.95);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Feedback</h2>
        <%
            if (farmerId == null || farmerId.trim().isEmpty()) {
                out.println("<p>Error: Farmer ID not provided.</p>");
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(
                        "jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM feedback_" + farmerId + " ORDER BY feedback_time DESC");

                    if (!rs.isBeforeFirst()) {
                        out.println("<p>No feedback received yet.</p>");
                    } else {
        %>
        <table>
            <tr>
                <th>Customer Name</th>
                <th>Mobile</th>
                <th>Rating</th>
                <th>Message</th>
                <th>Time</th>
            </tr>
        <%
                        while (rs.next()) {
        %>
            <tr>
                <td><%= rs.getString("customer_name") %></td>
                <td><%= rs.getString("customer_mobile") %></td>
                <td><%= rs.getInt("rating") %> / 5</td>
                <td><%= rs.getString("message") %></td>
                <td><%= rs.getTimestamp("feedback_time") %></td>
            </tr>
        <%
                        }
        %>
        </table>
        <%
                    }
                    conn.close();
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                }
            }
        %>
    </div>
</body>
</html>
