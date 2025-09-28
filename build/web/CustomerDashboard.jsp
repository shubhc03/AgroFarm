<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Consumer Home Page</title>
    <link rel="stylesheet" href="common.css">
    <link rel="stylesheet" href="ConsumerHome.css">
    <style>
        .scroll-container {
            display: flex;
            overflow-x: auto;
            padding: 20px;
            gap: 20px;
        }
        .card {
            flex: 0 0 auto;
            width: 250px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card-img {
            width: 100%;
            height: 180px;
            object-fit: cover;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        .card-content {
            padding: 15px;
        }
        .card-content .name {
            font-size: 18px;
            font-weight: bold;
        }
        .card-content .city, .card-content .price {
            font-size: 14px;
            color: #555;
        }
        .btn {
            display: inline-block;
            margin-top: 10px;
            padding: 8px 16px;
            background: green;
            color: white;
            border-radius: 5px;
            text-decoration: none;
        }
        .heading2 {
            font-size: 22px;
            font-weight: bold;
            padding-left: 20px;
            margin-top: 40px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="nav logo"><img src="logo.png" alt="Logo"></div>
        <div class="nav">Home</div>
        <div class="nav">Shop</div>

        <%
        HttpSession session1 = request.getSession(false);
        String customer_id = "";
        if (session1 == null || session1.getAttribute("customer_id") == null) {
        %>
            <a href="clogin.jsp"><div class="nav">login/sign-up</div></a>
        <%
        } else {
            customer_id = String.valueOf(session1.getAttribute("customer_id"));
        %>
            <a href="CLogoutServlet" style="color:red; float:right;"><div class="nav">Logout</div></a>
        <% } %>

        <div class="nav2 search">
            <input type="search" placeholder="Search farmers or products...">
        </div>
    </div>

    <!-- Main Container -->
    <div id="main">

        <!-- Farmer Shops Section -->
        <div class="section">
            <div class="heading2">Farmer Shops</div>
            <div class="scroll-container">
                <%
                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root");

                        ps = con.prepareStatement("SELECT * FROM farmers");
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            int farmerId = rs.getInt("farmer_id");
                            String name = rs.getString("name");
                            String location = rs.getString("location");
                %>
                <div class="card">
                    <img src="ShopImageServlet?farmer_id=<%= farmerId %>" alt="Farmer Image" class="card-img">
                    <div class="card-content">
                        <div class="name"><%= name %></div>
                        <div class="city"><%= location %></div>
                        <a href="ViewProducts.jsp?farmerId=<%= farmerId %>&customer_id=<%= customer_id %>" class="btn">Visit Shop</a>
                    </div>
                </div>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (Exception e) {}
                        try { if (ps != null) ps.close(); } catch (Exception e) {}
                        try { if (con != null) con.close(); } catch (Exception e) {}
                    }
                %>
            </div>
        </div>

        <!-- Vegetable Section -->
        <div class="section">
            <div class="heading2">Fresh Vegetables ?</div>
            <div class="scroll-container">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root");

                        String sql = "SELECT p1.* FROM products1 p1 " +
                                     "INNER JOIN (SELECT name, MIN(price) AS min_price FROM products1 WHERE category='vegetable' GROUP BY name) p2 " +
                                     "ON p1.name = p2.name AND p1.price = p2.min_price " +
                                     "WHERE p1.category='vegetable'";

                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            String name = rs.getString("name");
                            double price = rs.getDouble("price");
                            int stock = rs.getInt("stock");

                            String imgPath = "vegetable/" + name.toLowerCase().trim().replaceAll(" ", "-") + ".jpg";
                %>
                <div class="card">
                    <img src="<%= imgPath %>" alt="<%= name %>" class="card-img">
                    <div class="card-content">
                        <div class="name"><%= name %></div>
                        <div class="price"> <%= price %>/kg</div>
                        <div class="city">Available: <%= stock %> kg</div>
                        <a class="btn" href="BuyProduct.jsp?product_id=<%= rs.getInt("product_id") %>&farmer_id=<%= rs.getInt("farmer_id") %>&product_name=<%= rs.getString("name") %>&price=<%= rs.getDouble("price") %>&customer_id=<%= customer_id %>">Buy</a>
                    </div>
                </div>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<p style='color:red;'>Error loading vegetables: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (Exception e) {}
                        try { if (ps != null) ps.close(); } catch (Exception e) {}
                        try { if (con != null) con.close(); } catch (Exception e) {}
                    }
                %>
            </div>
        </div>

        <!-- Fruit Section -->
        <div class="section">
            <div class="heading2">Fresh Fruits ?</div>
            <div class="scroll-container">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root");

                        String sql = "SELECT p1.* FROM products1 p1 " +
                                     "INNER JOIN (SELECT name, MIN(price) AS min_price FROM products1 WHERE category='fruit' GROUP BY name) p2 " +
                                     "ON p1.name = p2.name AND p1.price = p2.min_price " +
                                     "WHERE p1.category='fruit'";

                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            String name = rs.getString("name");
                            double price = rs.getDouble("price");
                            int stock = rs.getInt("stock");

                            String imgPath = "fruits/" + name.toLowerCase().trim().replaceAll(" ", "-") + ".jpg";
                %>
                <div class="card">
                    <img src="<%= imgPath %>" alt="<%= name %>" class="card-img">
                    <div class="card-content">
                        <div class="name"><%= name %></div>
                        <div class="price"> <%= price %>/kg</div>
                        <div class="city">Available: <%= stock %> kg</div>
                        <a class="btn" href="BuyProduct.jsp?product_id=<%= rs.getInt("product_id") %>&farmer_id=<%= rs.getInt("farmer_id") %>&product_name=<%= rs.getString("name") %>&price=<%= rs.getDouble("price") %>&customer_id=<%= customer_id %>">Buy</a>
                    </div>
                </div>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<p style='color:red;'>Error loading fruits: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (Exception e) {}
                        try { if (ps != null) ps.close(); } catch (Exception e) {}
                        try { if (con != null) con.close(); } catch (Exception e) {}
                    }
                %>
            </div>
        </div>

    </div>
</body>
</html>
