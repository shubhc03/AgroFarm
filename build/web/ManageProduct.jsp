<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Manage Product</title>
    <style>
        body {
            background-image: url('agro2.png');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            margin: 0;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            margin-top: 20px;
        }
        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        td img {
            width: 80px;
            height: 80px;
            border-radius: 5px;
        }
        a.button-link {
            text-decoration: none;
            color: white;
            padding: 10px 20px;
            background-color: grey;
            display: inline-block;
            margin: 10px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <%@include file="menu.jsp"%>

    <center>
        <h1>Manage Product</h1>

        <h2>
            <a href="AddProduct.jsp" class="button-link">Add Products</a>
            <a href="EditProduct.jsp" class="button-link">Delete Product</a>
            <a href="UpdateProduct.jsp" class="button-link">Update Product</a>
             <a href="fmenu1.jsp" class="button-link">Back to HOME</a>
        </h2>

        <table cellpadding="12">
            <tr>
                <th>Product ID</th>
                <th>Farmer_id ID</th>
                <th>Product Name</th>
                <th>cetigory</th>
                <th>Price</th>
                <th>Stock</th>
               
                <th>time</th>
                <th>UpDate Product</th>
            </tr>

            <%
               HttpSession session1=request.getSession();
              String s1 = String.valueOf(session1.getAttribute("farmer_id"));


                if (s1 == null) {
                    response.sendRedirect("flogin.jsp"); // Redirect if not logged in
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql:///vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                    Statement st = con.createStatement();

                    String tableName = "products1";
                 String sql = "SELECT * FROM " + tableName + " WHERE farmer_id='" + s1 + "'";



                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("product_id") %></td>
                 <td><%= rs.getInt("farmer_id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("category") %></td>
                <td><%= rs.getDouble("price") %></td>
                <td><%= rs.getInt("stock") %></td>

                <!-- ✅ Show image using a servlet that returns image bytes -->
              
                <td><%= rs.getTimestamp("date_added") %></td>
                <td> <a href="fmenu1.jsp" class="button-link">Update Pdroduct</a></td>
            </tr>
            <%
                    }
                    con.close();
                } catch (Exception e) {
                    out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
                }
            %>
        </table>
    </center>
</body>
</html>
