     <%@page import="java.sql.*;"%>
        
        <%
        
        String s1=request.getParameter("u1");
        String s2=request.getParameter("u2");
        
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql:///vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
           Statement st=con.createStatement();
           
           ResultSet rs=st.executeQuery("select * from  customers where name='"+s1+"' AND password='"+s2+"'");
           
                   if(rs.next())
                   {
                       HttpSession session1=request.getSession();
                       int customer_id = rs.getInt("customer_id");
                       session1.setAttribute("customer_id",customer_id);
                   response.sendRedirect("CustomerDashboard.jsp");
                   }
        }
        catch(Exception e)
        {
        out.println(e);
        }
        
        %>
