



<html>
    <head>
      <!--  <script type="text/javascript">
            function demo()
            {
                x=confirm("Are u sure");
                if(x)
                {
                    alert("Data Deleted.....!");
                }
                else
                {
                    alert("Data Not Deleted....!");
                }
            }  -->
        <title>Edit Product</title>
        </head>
        <body style="background-image: url('agro2.png');">
            <%@include file="menu.jsp"%>
            
        <center> <h1>Edit Product</h1></center>
                <form action="DeleteProductDemoServlet" style="border-radius: Box; background: rgba(255, 255, 255, 0.1); padding:20px; box-shadow: 0px,0px,0px,0.3px; height: 100 vh; background-size: cover;">
                <label style="display: block; margin-bottom: 10px; margin-left: 80px; font-weight: bold; font-size: 30px;">Enter Product No. :</label>
                <input type="text" name="delete" style="width: 20%; padding: 12px; margin-left: 360px; margin-top:-50px; margin-bottom: 15px; border: 1px solid #bbb; border-radius: 10px; box-sizing: border-box;">
                <input type="submit" value="Delete" style="background-color: greenyellow; color: green; border: none; padding: 14px; width: 10%; border-radius: 10px; cursor: pointer; font-size: 18px; transition: background-color 0.3s ease; ">
                <h2 style="margin-top: 20px; background-color: grey; display: inline-block;">
                <a href="UpdateProduct.jsp" style="background-color: greenyellow; color: green; border: none; padding: 14px; width: 10%; border-radius: 10px; cursor: pointer; font-size: 18px; transition: background-color 0.3s ease; ">Update Product</a>
                </form>
          
        </body>
        </html>