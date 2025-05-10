<!-- FarmerRegister.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Farmer Registration</title>
    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #d4fc79, #96e6a1);
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        input, select, textarea {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        h2 {
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Farmer Registration Form</h2>
        <form action="RegisterFarmerServlet" method="post" enctype="multipart/form-data">
            <input type="text" name="FullName" placeholder="Full Name" required>

            <input type="email" name="Email" placeholder="Email Address" required>

            <input type="password" name="Password" placeholder="Password" required>

            <input type="text" name="Location" placeholder="Farm Location" required>

            <label for="shopImage">Upload Shop Image:</label>
            <input type="file" name="ShopImage" accept="image/*" required>

            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
