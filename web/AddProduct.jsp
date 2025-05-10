<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f1f1f1; display: flex; justify-content: center; align-items: center; height: 100vh;">

    <div style="background-color: #fff; padding: 30px; border-radius: 12px; box-shadow: 0 0 15px rgba(0,0,0,0.1); width: 400px;">
        <h2 style="text-align: center; margin-bottom: 20px;">Add New Product</h2>

        <form action="AddProductServlet" method="post" enctype="multipart/form-data">

            <label for="name" style="display: block; margin-top: 15px; margin-bottom: 5px; font-weight: bold;">Product Name:</label>
            <input type="text" id="name" name="name" required
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 6px; box-sizing: border-box;">

            <label for="category" style="display: block; margin-top: 15px; margin-bottom: 5px; font-weight: bold;">Category:</label>
            <select id="category" name="category" required
                    style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 6px; box-sizing: border-box;">
                <option value="">Select</option>
                <option value="vegetable">Vegetable</option>
                <option value="fruit">Fruit</option>
            </select>

            <label for="price" style="display: block; margin-top: 15px; margin-bottom: 5px; font-weight: bold;">Price (?):</label>
            <input type="number" id="price" name="price" step="0.01" required
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 6px; box-sizing: border-box;">

            <label for="stock" style="display: block; margin-top: 15px; margin-bottom: 5px; font-weight: bold;">Stock Quantity:</label>
            <input type="number" id="stock" name="stock" required
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 6px; box-sizing: border-box;">

           
            <button type="submit"
                    style="margin-top: 20px; width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 6px; cursor: pointer; font-size: 16px;">
                Add Product
            </button>
        </form>
    </div>

</body>
</html>
