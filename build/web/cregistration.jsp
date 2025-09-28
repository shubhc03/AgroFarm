<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumer Registration</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f9f9f9;">
    <div style="width: 100%; max-width: 500px; margin: 30px auto; padding: 20px; background: #fff; border: 1px solid #ccc; border-radius: 10px;">
        <h2 style="text-align: center; color: #333;">Consumer Registration</h2>
        <form action="ConsumerRegisDemo.jsp">
            <div style="margin-bottom: 15px;">
                <label for="name" style="display: block; margin-bottom: 5px; font-weight: bold;">Full Name:</label>
                <input type="text" id="name" name="name" placeholder="Enter your full name" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
            </div>
            
    
            <div style="margin-bottom: 15px;">
                <label for="email" style="display: block; margin-bottom: 5px; font-weight: bold;">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
            </div>
            <div style="margin-bottom: 15px;">
                <label for="phone" style="display: block; margin-bottom: 5px; font-weight: bold;">Phone Number:</label>
                <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
            </div>
            <div style="margin-bottom: 15px;">
                <label for="gender" style="display: block; margin-bottom: 5px; font-weight: bold;">Gender:</label>
                <input type="radio" id="male" name="gender" value="male" required> <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female" required> <label for="female">Female</label>
                <input type="radio" id="other" name="gender" value="other" required> <label for="other">Other</label>
            </div>
            <div style="margin-bottom: 15px;">
                <label for="dob" style="display: block; margin-bottom: 5px; font-weight: bold;">Date of Birth:</label>
                <input type="date" id="dob" name="date" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
            </div>
            <div style="margin-bottom: 15px;">
                <label for="address" style="display: block; margin-bottom: 5px; font-weight: bold;">Address:</label>
                <textarea id="address" name="address" placeholder="Enter your address" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;"></textarea>
            </div>
            <div style="margin-bottom: 15px;">
                <label for="password" style="display: block; margin-bottom: 5px; font-weight: bold;">Password:</label>
                <input type="password"  name="password" placeholder="Enter your password" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
            </div>
            <div style="margin-bottom: 15px;">
                <input type="checkbox" id="terms" name="terms" onclick="toggleSubmitButton()"> 
                <label for="terms">I agree to the <a href="#" style="color: #007bff;">terms and conditions</a>.</label>
            </div>
            <button type="submit" id="submitButton" style="width: 100%; padding: 10px; background-color: #007bff; color: #fff; border: none; border-radius: 5px; font-size: 16px;" disabled>Register</button>
        </form>
    </div>

    <script>
        // Enable or disable the submit button based on the terms checkbox
        function toggleSubmitButton() {
            const termsCheckbox = document.getElementById('terms');
            const submitButton = document.getElementById('submitButton');
            submitButton.disabled = !termsCheckbox.checked;
        }

        // Additional validation can be added here
        function validateForm() {
            const dob = document.getElementById('dob').value;
            if (!dob) {
                alert("Please select your date of birth.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
