import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SendFeedbackServlet")
public class SendFeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customer_id") == null) {
            out.println("<script>alert('Please login first.'); window.location='ConsumerLogin.jsp';</script>");
            return;
        }

        int customerId = Integer.parseInt(session.getAttribute("customer_id").toString());
        String farmerIdStr = request.getParameter("farmer_id");
        String message = request.getParameter("message");
        String ratingStr = request.getParameter("rating");

        if (farmerIdStr == null || ratingStr == null || message == null || message.trim().isEmpty()) {
            out.println("<script>alert('Invalid input. Please fill all fields.'); history.back();</script>");
            return;
        }

        try {
            int farmerId = Integer.parseInt(farmerIdStr.trim());
            int rating = Integer.parseInt(ratingStr.trim());

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vishalji?useSSL=false", "root", "root"
            );

         

            // Insert feedback
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO feedback (farmer_id, customer_id, message, rating) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, farmerId);
            ps.setInt(2, customerId);
            ps.setString(3, message);
            ps.setInt(4, rating);
            ps.executeUpdate();

            out.println("<script>alert('Feedback submitted successfully!'); window.location='CustomerDashboard.jsp';</script>");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('Error: " + e.getMessage() + "'); history.back();</script>");
        }
    }
}
