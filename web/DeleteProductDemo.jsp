<%@page import="java.sql.*" %>
<%
   


    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///vishalji?useSSL=false", "root", "root");
            
            String query = "DELETE FROM products1 WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(productId));

            int rows = pst.executeUpdate();

            if (rows > 0) {
%>
                <script>
                    alert("Product deleted successfully.");
                    window.location = "ManageProduct.jsp";
                </script>
<%
            } else {
%>
                <script>
                    alert("Product not found or already deleted.");
                    window.location = "ManageProduct.jsp";
                </script>
<%
            }

            pst.close();
            con.close();
        } catch (Exception e) {
%>
            <script>
                alert("Error occurred while deleting the product: <%= e.getMessage() %>");
                window.location = "ManageProduct.jsp";
            </script>
<%
        }
    } else {
%>
        <script>
            alert("Invalid product ID.");
            window.location = "ManageProduct.jsp";
        </script>
<%
    }
%>
