<html>
    <head>
        
     
<style type="text/css">
    div{
       background-color:rgba(0,0,0,.5);
        font-size:30px;
        color:white;
        width:200px;
       
        height:200px;
        text-align:center;
        text-shadow: 20px 20px 20px white;
        margin-bottom: 5px;
        float:left;
        margin-left:200px;
        margin-top: 200px;
        box-shadow:15px 15px 15px black;
         transition: transform 0.3s ease, background-color 0.3s ease;
    }
    div:hover{
     background-color:rgba(0,0,0,.8);
        color:white;
        font-size:60px;
       transform: scale(1.1);
    text-shadow: 20px 20px 20px blue;
    
    }
</style>
<body style="background-image: url('agro2.png'); background-size:100% 100%; background-repeat: no-repeat;">
        </head>
        <body>
         <%String s1=request.getParameter("farmer_id");%>
            <i>
           
                <div><B><a href="ManageProduct.jsp">Manage Product</a></B></div>
             <div><B><a href="ViewOrders.jsp?farmerId=<%= s1 %>">View Orders</a></B></div>
              <div><B><a href="MandiRates.jsp?farmerId=<%= s1 %>">Mandi Rates</a></B></div>
               <div><B><a href="WeatherUpdates.jsp?farmerId=<%= s1 %>">Weather updates</a></B></div>
               <div><B><a href="LearningResources.jsp?farmerId=<%= s1 %>">Learning Resources</a></B></div>
               <div><B><a href="ViewFeedback.jsp?farmerId=<%=  s1 %>">View Feedback</a></B></div>
               <div><B><a href="PaymentHistory.jsp">Payment History</a></B></div>
               
            </body>
    </html>