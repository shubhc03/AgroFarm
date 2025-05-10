<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%
    String farmerIdStr = request.getParameter("farmerId");
    int farmerId = 0;
    if (farmerIdStr != null && !farmerIdStr.equals("null") && !farmerIdStr.isEmpty()) {
        farmerId = Integer.parseInt(farmerIdStr);
    }
%>
<html>
<head>
    <title>Products from Farmer</title>
    <style>
        body {
            background: #f0fff0;
            font-family: Arial, sans-serif;
        }
        .product-card {
            background: white;
            border-radius: 10px;
            padding: 15px;
            margin: 20px auto;
            width: 500px;
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }
        .product-card h3 {
            margin-top: 0;
            color: #2e8b57;
        }
        .buy-btn {
            display: inline-block;
            margin-top: 10px;
            padding: 8px 15px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .buy-btn:hover {
            background-color: #218838;
        }
        .back-button {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            background: #2e8b57;
            color: white;
            border-radius: 8px;
            text-decoration: none;
        }
        .ratting{
            float :right;
        }
        .back-button:hover {
            background: #256a45;
        }
    </style>
</head>
<body>

    <a href="CustomerDashboard.jsp" class="back-button"> Back to Shops</a>
    <% 
         Connection con = null;
    PreparedStatement psFarmer = null, psProducts = null;
    ResultSet rsFarmer = null, rsProducts = null;
     Double rating=0.0 ;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
        
         psFarmer = con.prepareStatement("SELECT AVG(rating) FROM feedback WHERE farmer_id = ?");
         psFarmer.setInt(1, Integer.parseInt(farmerIdStr));
        ResultSet rs = psFarmer.executeQuery();
        
        if(rs.next()){
            rating = rs.getDouble(1);
        }
        
    %>
    <a href="SendFeedBack.jsp?farmer_id=<%= farmerId %> " class="back-button ratting"> Give FeedBack  <%= rating %> </a>
    
    <h2 style="text-align:center;">Products from Farmer</h2>

<% 
   
        String customer_id = request.getParameter("customer_id");
//         HttpSession session1=request.getSession();
//              String customer_id = String.valueOf(session1.getAttribute("customer_id"));
//
//                     HttpSession session = request.getSession(false); // don't create new session if not present
//String customerIdStr = null;
//
//if (session != null && session.getAttribute("customer_id") != null) {
//    customerIdStr = String.valueOf(session.getAttribute("customer_id"));
//} else {
//    out.println("<script>alert('Session expired or customer not logged in.'); window.location='ConsumerLogin.jsp';</script>");
//    return;
//}
//
//int customerId = Integer.parseInt(customerIdStr);


        psFarmer = con.prepareStatement("SELECT * FROM farmers WHERE farmer_id = ?");
        psFarmer.setInt(1, farmerId);
        rsFarmer = psFarmer.executeQuery();

        String farmerName = "", location = "";

        if (rsFarmer.next()) {
            farmerName = rsFarmer.getString("name");
            location = rsFarmer.getString("location");
        }
%>
    <h3 style="text-align:center;"><%= farmerName %>'s Shop - <%= location %></h3>

<%
        psProducts = con.prepareStatement("SELECT * FROM products1 WHERE farmer_id = ?");
        psProducts.setInt(1, farmerId);
        rsProducts = psProducts.executeQuery();

        boolean hasProducts = false;
        while (rsProducts.next()) {
            hasProducts = true;
            int productId = rsProducts.getInt("product_id");
%>
    <div class="product-card">
        <h3><%= rsProducts.getString("name") %></h3>
        <p><strong>Category:</strong> <%= rsProducts.getString("category") %></p>
        <p><strong>Price:</strong> <%= rsProducts.getDouble("price") %> per unit</p>
        <p><strong>Stock:</strong> <%= rsProducts.getInt("stock") %></p>
        <a href="BuyProduct.jsp?product_id=<%= rsProducts.getInt("product_id") %>&farmer_id=<%= rsProducts.getInt("farmer_id") %>&product_name=<%= rsProducts.getString("name") %>&price=<%= rsProducts.getDouble("price") %>&customer_id=<%= customer_id %>" class="buy-button">Buy</a>

    </div>
<%
        }

        if (!hasProducts) {
%>
    <p style="text-align:center; color: red;">No products found for this farmer.</p>
<%
        }

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    } finally {
        try { if (rsFarmer != null) rsFarmer.close(); } catch (Exception e) {}
        try { if (rsProducts != null) rsProducts.close(); } catch (Exception e) {}
        try { if (psFarmer != null) psFarmer.close(); } catch (Exception e) {}
        try { if (psProducts != null) psProducts.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>

</body>
</html>
