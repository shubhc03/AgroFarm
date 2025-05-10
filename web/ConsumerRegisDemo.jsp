<%@page import="java.sql.*;"%>

<%
  String s1=request.getParameter("name"); 
  String s2=request.getParameter("email"); 
  String s3=request.getParameter("password"); 
 
  String s4=request.getParameter("address"); 
  
    
    
try{
Class.forName("com.mysql.cj.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql:///vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

Statement st=con.createStatement();
int x=st.executeUpdate(
                           "insert into  customers(name,email,password,address)"+
                                   "values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')"
);

response.sendRedirect("clogin.jsp");
con.close();
}
catch(Exception e)
{
out.println(e);
}

%>