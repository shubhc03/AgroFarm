import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        

//        String productIdStr = "1";
//        String farmerIdStr =  "1";
//        String customer_id =  "1";
//        String quantityStr =  "1";
        String productIdStr = request.getParameter("product_id");
        String farmerIdStr = request.getParameter("farmer_id");
//        String customer_id = request.getParameter("customer_id");
        String quantityStr = request.getParameter("quantity");
       

//        HttpSession session = request.getSession();
//        String customerUsername = (String) session.getAttribute("username");

        int productId = Integer.parseInt(productIdStr.trim());
        int farmerId = Integer.parseInt(farmerIdStr.trim());
//        int customerid = Integer.parseInt(customer_id.trim());
        int quantity = Integer.parseInt(quantityStr.trim());
        
        
        String customerIdStr = request.getParameter("customer_id");
int customerid = 0;

if (customerIdStr != null && !customerIdStr.equals("null") && !customerIdStr.trim().isEmpty()) {
    customerid = Integer.parseInt(customerIdStr.trim());
} else {
    out.println("<script>alert('Customer ID is missing. Please login again.');window.location='ConsumerLogin.jsp';</script>");
    return;
}

        String customer_name="";

        Connection con = null;
        PreparedStatement psProduct = null, psInsertOrder = null, psUpdateStock = null;
        ResultSet rsProduct = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root");
            psProduct = con.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
            psProduct.setInt(1, customerid);
            rsProduct = psProduct.executeQuery();
             if (rsProduct.next()) {
                 customer_name = rsProduct.getString(2);
             }

            // Step 1: Get product details
            psProduct = con.prepareStatement("SELECT * FROM products1 WHERE product_id = ?");
            psProduct.setInt(1, productId);
            rsProduct = psProduct.executeQuery();

            if (rsProduct.next()) {
                String productName = rsProduct.getString("name");
                double price = rsProduct.getDouble("price");
                int stock = rsProduct.getInt("stock");

                if (stock < quantity) {
                    out.println("<script>alert('Not enough stock available!');history.back();</script>");
                    return;
                }

                double total = price * quantity;

                // Step 2: Create orders_<farmerId> table if it doesn't exist
                Statement stmt = con.createStatement();
                String orderTable = "orders";
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS orders ("
                        + "order_id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "farmer_id INT NOT NULL ,"  
                        + "customer_id INT, "
                        + "product_id INT, "
                        + "product_name varchar(100), "
                        + "quantity INT, "
                        + "price DOUBLE, "
                        + "total DOUBLE, "
                        + "customer_name VARCHAR(100), "
                        + "order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

                // Step 3: Insert order
                String insertSQL = "INSERT INTO orders (farmer_id, product_name, product_id, quantity, price, total, customer_name, customer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                psInsertOrder = con.prepareStatement(insertSQL);
                psInsertOrder.setInt(1, farmerId);
                psInsertOrder.setString(2, productName);
                psInsertOrder.setInt(3, productId);
                psInsertOrder.setInt(4, quantity);
                psInsertOrder.setDouble(5, price);
                psInsertOrder.setDouble(6, total);
                psInsertOrder.setString(7, customer_name);
                psInsertOrder.setInt(8, customerid);
                psInsertOrder.executeUpdate();

                // Step 4: Update stock in products1
                psUpdateStock = con.prepareStatement("UPDATE products1 SET stock = stock - ? WHERE product_id = ?");
                psUpdateStock.setInt(1, quantity);
                psUpdateStock.setInt(2, productId);
                psUpdateStock.executeUpdate();

                out.println("<script>alert('Order placed successfully!');window.location='CustomerDashboard.jsp';</script>");
            } else {
                out.println("<script>alert('Product not found!');history.back();</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        } finally {
            try { if (rsProduct != null) rsProduct.close(); } catch (Exception e) {}
            try { if (psProduct != null) psProduct.close(); } catch (Exception e) {}
            try { if (psInsertOrder != null) psInsertOrder.close(); } catch (Exception e) {}
            try { if (psUpdateStock != null) psUpdateStock.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
