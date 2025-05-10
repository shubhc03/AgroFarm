
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class CLogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session
        HttpSession session = request.getSession(false); // false: do not create if it doesn't exist
        if (session != null) {
            session.invalidate();
        }

        // Redirect to login page
        response.sendRedirect("clogin.jsp"); // or any other login/homepage
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // handle both GET and POST
    }
}
