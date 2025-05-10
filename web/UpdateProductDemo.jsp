<%@page import="java.sql.*"%>
<%
    Integer userId = (Integer) session.getAttribute("user_id");
    if (userId == null) {
        response.sendRedirect("flogin.jsp");                               // Redirect if not logged in
        return;
    }
                                                                          //    
    String tableName = "product_" + userId;
    String s22 = request.getParameter("n1");
                                                                         //                                                                         
    if (s22 != null) {
        String s1 = request.getParameter("n1");
        String s2 = request.getParameter("n2");
        String s3 = request.getParameter("n3");
        String s4 = request.getParameter("n4");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                 PreparedStatement ps = con.prepareStatement("UPDATE " + tableName + " SET description = ?, stock = ?, price = ? WHERE product_name = ?")) {

                ps.setString(1, s2);
                ps.setString(2, s3);
                ps.setString(3, s4);
                ps.setString(4, s1);

                int x = ps.executeUpdate();
                if (x != 0) {
                    response.sendRedirect("ShowAll.jsp");
                } else {
                    out.println("<h1>Data not updated</h1>");
                }
            }
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
%>
<html>
<head>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4;">
<center>
    <form action="UpdateProductDemo.jsp" style="background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
        <table cellpadding="12px">
            <tr>
                <td>Enter Product Name :</td>
                <td><input type="text" style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;" name="u1" placeholder="Enter Product Name:"></td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" name="b1" value="Search" style="padding: 8px 16px; background: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;"></th>
            </tr>
        </table>
    </form>
</center>
<%
    String s21 = request.getParameter("u1");
    if (s21 != null) {
        String s1 = request.getParameter("u1");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName + " WHERE product_name = ?")) {

                ps.setString(1, s1);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
%>
<center>
    <form action="UpdateProductDemo.jsp" style="background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
        <table cellpadding="12">
            <tr>
                <td>Product No.</td>
                <td><input type="text" name="n0" value="<%=rs.getString(1)%>" readonly style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;"></td>
            </tr>
            <tr>
                <td>Product Name</td>
                <td><input type="text" name="n1" value="<%=rs.getString(2)%>" style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="n2" value="<%=rs.getString(3)%>" style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;"></td>
            </tr>
            <tr>
                <td>Stock</td>
                <td><input type="text" name="n3" value="<%=rs.getString(4)%>" style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="n4" value="<%=rs.getString(5)%>" style="padding: 8px; border-radius: 4px; border: 1px solid #ccc;"></td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" name="b2" value="Update" style="padding: 8px 16px; background: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;"></th>
            </tr>
        </table>
    </form>
</center>
<%
                    } else {
                        out.println("<h1>Invalid Product Name</h1>");
                    }
                }
            }
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
%>
</body>
</html>
