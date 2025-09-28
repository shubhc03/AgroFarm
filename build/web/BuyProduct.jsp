<%@ page session="true" %>
<%
    // Session check
 Object cid = session.getAttribute("customer_id");
if (cid == null) {
    response.sendRedirect("clogin.jsp");
    return;
}
String customer_id = cid.toString();


    // Get product info from request
    String productId = request.getParameter("product_id");
    String farmerId = request.getParameter("farmer_id");
    String productName = request.getParameter("product_name");
    String price = request.getParameter("price");

    if (productId == null || farmerId == null || productName == null || price == null) {
%>
    <p style="color:red; text-align:center;">Invalid product details. Please go back and try again.</p>
<%
        return;
    }
%>
<html>
<head>
    <title>Buy Product</title>
    <style>
        body {
            background: #eafbe7;
            font-family: Arial, sans-serif;
        }
        .buy-form-container {
            width: 400px;
            margin: 100px auto;
            background: white;
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #2e8b57;
        }
        label {
            font-weight: bold;
        }
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        button {
            background: #2e8b57;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background: #246b45;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #2e8b57;
        }
    </style>
</head>
<body>

<div class="buy-form-container">
    <h2>Buy <%= productName %></h2>
    <form action="PlaceOrderServlet" method="post">
        <input type="hidden" name="product_id" value="<%= productId %>">
        <input type="hidden" name="farmer_id" value="<%= farmerId %>">
        <input type="hidden" name="customer_id" value="<%= customer_id %>">
        <label>Price: ?<%= price %> per unit</label><br><br>
        <label for="quantity">Enter Quantity:</label>
        <input type="number" name="quantity" min="1" required>
        <button type="submit">Confirm Order</button>
    </form>
    <a href="CustomerDashboard.jsp" class="back-link">? Back to Shops</a>
</div>

</body>
</html>
