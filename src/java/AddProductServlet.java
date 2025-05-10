import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.Part;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get form fields
        String productName = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
          HttpSession session1=request.getSession();
              String s1 = String.valueOf(session1.getAttribute("farmer_id"));


        // Get uploaded image
       
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load JDBC driver and connect to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true",
                "root", "root"
            );
            
            if (s1 == null || s1.equals("null")) {
    response.sendRedirect("flogin.jsp"); // or wherever the farmer login page is
    return;
}

            // SQL to insert product with image
         String sql = "INSERT INTO products1 (farmer_id, name, category, price, stock) VALUES (?, ?, ?, ?, ?)";

         ps = con.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt(s1));
         ps.setString(2, productName);
         ps.setString(3, category);
         ps.setDouble(4, price);
         ps.setInt(5, stock);
         
         
         int rows = ps.executeUpdate();

            if (rows > 0) {
               // out.println("data inserted");
                response.sendRedirect("ManageProduct.jsp");  // Redirect to product list page
            } else {
                out.println("<h3 style='color:red;'>Product addition failed. Please try again.</h3>");
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
