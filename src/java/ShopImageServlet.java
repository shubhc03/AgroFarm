import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ShopImageServlet")
public class ShopImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int farmerId = Integer.parseInt(request.getParameter("farmer_id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

            PreparedStatement ps = con.prepareStatement("SELECT shop_image FROM farmers WHERE farmer_id = ?");
            ps.setInt(1, farmerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                byte[] imageData = rs.getBytes("shop_image");
                response.setContentType("image/jpeg");
                OutputStream out = response.getOutputStream();
                out.write(imageData);
                out.flush();
                out.close();
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
