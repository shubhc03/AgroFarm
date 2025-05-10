import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String farmerId = request.getParameter("farmerId");
        String orderIdStr = request.getParameter("orderId");

        if (farmerId == null || orderIdStr == null || farmerId.isEmpty() || orderIdStr.isEmpty()) {
            response.getWriter().println("<h3>Error: Missing farmer ID or order ID.</h3>");
            return;
        }

        int orderId = Integer.parseInt(orderIdStr);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true", "root", "root"
            );

            String deleteSQL = "DELETE FROM orders_" + farmerId + " WHERE order_id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setInt(1, orderId);
            ps.executeUpdate();

            conn.close();

            // Show alert and redirect using JavaScript
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('Order marked as delivered!');");
            out.println("window.location.href = 'ViewOrders.jsp?farmerId=" + farmerId + "';");
            out.println("</script>");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
