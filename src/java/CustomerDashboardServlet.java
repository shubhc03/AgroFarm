import model.Product;
import model.Farmer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerDashboard")
public class CustomerDashboardServlet extends HttpServlet {

    public static Connection initializeDatabase() throws Exception {
        String jdbcURL = "jdbc:mysql://localhost:3306/agro_farm";
        String dbUser = "root";
        String dbPassword = "yourpassword"; // change this

        Class.forName("com.mysql.jdbc.Driver"); // For MySQL 5.x
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = initializeDatabase();
            List<Farmer> farmers = new ArrayList<>();

            String query = "SELECT * FROM farmer";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Farmer farmer = new Farmer();
                farmer.setId(rs.getInt("farmer_id"));
                farmer.setName(rs.getString("name"));
                farmer.setLocation(rs.getString("location"));
                farmer.setShopImage(rs.getString("shop_image"));

                // Load products for this farmer
                String productQuery = "SELECT * FROM product WHERE farmer_id = ?";
                PreparedStatement pst = conn.prepareStatement(productQuery);
                pst.setInt(1, farmer.getId());
                ResultSet productRs = pst.executeQuery();

                List<Product> products = new ArrayList<>();
                while (productRs.next()) {
                    Product p = new Product();
                    p.setName(productRs.getString("name"));
                    p.setImage(productRs.getString("image"));
                    p.setPrice(productRs.getDouble("price"));
                    products.add(p);
                }

                farmer.setProducts(products);
                farmers.add(farmer);
            }

            request.setAttribute("farmers", farmers);
            request.getRequestDispatcher("customer_dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
