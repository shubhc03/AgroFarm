import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

@MultipartConfig(maxFileSize = 16177215) // 16MB
@WebServlet("/UploadProductServlet")
public class UploadProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // ✅ Get user ID from session using correct attribute name
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            out.println("<h3 style='color:red;'>Session expired or user not logged in!</h3>");
            return;
        }

        int userId = (Integer) session.getAttribute("user_id");

        // ✅ Get form data
        String productName = request.getParameter("u1");
        String description = request.getParameter("u2");
        int stock = Integer.parseInt(request.getParameter("u3"));
        int price = Integer.parseInt(request.getParameter("u4"));

        // ✅ Get image file
        Part imagePart = request.getPart("image");
        InputStream imageStream = imagePart.getInputStream();

        // ✅ Database config
        String dbURL = "jdbc:mysql:///Arpit07?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUser = "root";
        String dbPass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // ✅ Dynamic table name
            String tableName = "product_" + userId;

            // ✅ Insert product into the correct table
            String sql = "INSERT INTO " + tableName + " (product_name, description, stock, price, IMG) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, productName);
            stmt.setString(2, description);
            stmt.setInt(3, stock);
            stmt.setInt(4, price);
            stmt.setBlob(5, imageStream);

            int row = stmt.executeUpdate();

            if (row > 0) {
               // out.println("<h3 style='color:green;'>Product uploaded successfully!</h3>");
                
                response.sendRedirect("ManageProduct.jsp");
            } else {
                out.println("<h3 style='color:red;'>Failed to upload product.</h3>");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}
