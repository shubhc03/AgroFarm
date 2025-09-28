<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Farmer's Market</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            /*background: url('c336a7a4-0d90-4906-9690-947a02dc3acd.png') no-repeat center center fixed;*/
            background-size: cover;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('agro2.png');
        }

        .container {
            display: flex;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
            width: 100%;
            max-width: 1400px;
        }

        .circle-link {
    width: 280px;
    height: 280px;
    border-radius: 50%;
    background-color: rgba(255, 204, 0, 0.9);
    box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px;
            transition: transform 0.3s;
        }

        .circle-link:hover {
            transform: scale(1.05);
        }

        .circle-link a {
            display: block;
            width: 100%;
            text-decoration: none;
            color: white;
            font-weight: bold;
            font-size: 24px;
            padding-bottom: 20px;
        }

        @media (max-width: 768px) {
            .circle-link {
                width: 220px;
                height: 220px;
            }

            .circle-link a {
                font-size: 20px;
            }
        }

        @media (max-width: 480px) {
            .container {
                flex-direction: column;
            }

            .circle-link {
                width: 200px;
                height: 200px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="circle-link">
            <a href="flogin.jsp">FARMER</a>
        </div>
        <div class="circle-link">
            <a href="CustomerDashboard.jsp">CONSUMER</a>
        </div>
    </div>
</body>
</html>
