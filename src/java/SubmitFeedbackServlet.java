import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitFeedbackServlet")
public class SubmitFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String farmerId = request.getParameter("farmerId");
        String name = request.getParameter("customerName");
        String mobile = request.getParameter("customerMobile");
        String message = request.getParameter("message");
        int rating = Integer.parseInt(request.getParameter("rating"));

        Connection conn = null;
        Statement st = null;
        PreparedStatement ps = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(
                "jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true", "root", "root"
            );

            // Create feedback table if it doesn't exist
            String createTable = "CREATE TABLE IF NOT EXISTS feedback_" + farmerId + " (" +
                "feedback_id INT AUTO_INCREMENT PRIMARY KEY," +
                "customer_name VARCHAR(100)," +
                "customer_mobile VARCHAR(20)," +
                "rating INT," +
                "message TEXT," +
                "feedback_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
            st = conn.createStatement();
            st.executeUpdate(createTable);

            // Insert feedback
            String sql = "INSERT INTO feedback_" + farmerId + " (customer_name, customer_mobile, rating, message) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setInt(3, rating);
            ps.setString(4, message);
            ps.executeUpdate();

            // Send success response
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Thank you for your feedback!'); window.location='CustomerDashboard.jsp';</script>");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (Exception ignore) {}
        }
    }
}
