import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DisplayImageServlet")
public class DisplayImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("product_id"));

        String dbURL = "jdbc:mysql:///vishalji?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUser = "root";
        String dbPass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String tableName = "products";
            String sql = "SELECT IMG FROM " + tableName + " WHERE product_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("IMG");
                response.setContentType("image/jpeg");
                response.setContentLength(imageBytes.length);
                OutputStream out = response.getOutputStream();
                out.write(imageBytes);
                out.close();
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
