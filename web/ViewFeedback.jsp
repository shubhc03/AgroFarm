<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Farmer Feedback</title>
    <style>
        body {
            background: linear-gradient(to right, #d2e1f8, #fef6f9);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 40px auto;
            width: 90%;
            max-width: 1000px;
            background-color: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #6c7ae0;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f4f6fa;
        }
        .no-feedback {
            text-align: center;
            margin-top: 20px;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Feedback</h2>
        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            HttpSession session1 = request.getSession(false);
            int farmerId = 0;

            if (session1 != null && session1.getAttribute("farmer_id") != null) {
                farmerId = (Integer) session1.getAttribute("farmer_id");
            } else if (request.getParameter("farmer_id") != null) {
                farmerId = Integer.parseInt(request.getParameter("farmer_id"));
            }

            if (farmerId != 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root");

                    String sql = "SELECT f.rating, f.message, f.feedback_date, c.name AS customer_name " +
                                 "FROM feedback f JOIN customers c ON f.customer_id = c.customer_id " +
                                 "WHERE f.farmer_id = ? ORDER BY f.feedback_date DESC";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, farmerId);
                    rs = ps.executeQuery();

                    boolean hasFeedback = false;
        %>
        <table>
            <tr>
                <th>Customer Name</th>
                <th>Rating</th>
                <th>Message</th>
                <th>Date</th>
            </tr>
        <%
                    while (rs.next()) {
                        hasFeedback = true;
        %>
            <tr>
                <td><%= rs.getString("customer_name") %></td>
                <td><%= rs.getInt("rating") %> *</td>
                <td><%= rs.getString("message") %></td>
                <td><%= rs.getTimestamp("feedback_date") %></td>
            </tr>
        <%
                    }
                    if (!hasFeedback) {
        %>
            </table>
            <div class="no-feedback">No feedback available for this farmer.</div>
        <%
                    }
                } catch (Exception e) {
                    out.println("<div class='no-feedback'>Error: " + e.getMessage() + "</div>");
                    e.printStackTrace();
                } finally {
                    try { if (rs != null) rs.close(); } catch (Exception e) {}
                    try { if (ps != null) ps.close(); } catch (Exception e) {}
                    try { if (con != null) con.close(); } catch (Exception e) {}
                }
            } else {
        %>
            <div class="no-feedback">Invalid farmer ID or session expired.</div>
        <%
            }
        %>
    </div>
</body>
</html>
