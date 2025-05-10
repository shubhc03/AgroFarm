

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/RegisterFarmerServlet")
@MultipartConfig
public class RegisterFarmerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get form fields
        String name = request.getParameter("FullName");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String location = request.getParameter("Location");

        // Get uploaded image
        Part imagePart = request.getPart("ShopImage");
        InputStream imageStream = imagePart.getInputStream();

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load JDBC driver and connect to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true",
                "root", "root"
            );

            // SQL to insert farmer with image
            String sql = "INSERT INTO farmers (name, email, password, location, shop_image) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, location);
            ps.setBlob(5, imageStream);  // Save image as BLOB

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("flogin.jsp");
            } else {
                out.println("<h3 style='color:red;'>Registration failed. Please try again.</h3>");
            }

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
