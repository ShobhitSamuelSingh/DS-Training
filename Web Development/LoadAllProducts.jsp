<%@page import="service.ProductServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="entities.Product"%>
<%@page import="service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<style>
html {
  scroll-behavior: smooth;
}

#section1 {
  background-color: pink;
}

#section2 {

  background-color: yellow;
}
#section3 {
  background-color: pink;
}

#section4 {

  background-color: yellow;
}
#section5 {
  background-color: pink;
}


    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        padding: 20px;
        color: #333;
    }

    .container {
        max-width: 1000px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    

    a {
        text-decoration: none;
        color: #007bff;
    }

    a:hover {
        text-decoration: underline;
    }
    .container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 10px;
            /* Adjust this value to control the spacing between divs */
        }

        .grid-item {
            padding: 20px;
            border: 1px solid #ccc;
            text-align: center;
        }

        #mybutton {
            position: relative;
            top: 0;
            right: 0;
        }

        #projecttitle1 {
            padding-left: 5%;
            padding-right: 70%;
            text-size-adjust: 2rem;
        }
        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background: transparent;
            border: 2px solid #4c8bf5;
            border-radius: 8px;
            padding: 10px;
            font-size: 16px;
            color: #4c8bf5;
            cursor: pointer;
        }

      //  /* Style the dropdown arrow icon */
        select::-ms-expand {
            display: none;
        }

        select::after {
            content: '\25BE';
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 16px;
            color: #4c8bf5;
        }

        /* Style the options */
        option {
            background-color: #f1f9ff;
            color: #4c8bf5;
        }

        /* Style the selected option */
        option:checked {
            background-color: #4c8bf5;
            color: #fff;
        }

        /* Style the container for the selected value */
        p {
            font-size: 18px;
            color: #4c8bf5;
            margin-top: 20px;
        }

        /* Style the span for the selected value */
        #selectedCategory {
            font-weight: bold;
            color: #4c8bf5;
        }
        #myTopBtn {
		  display: none;
		  position: fixed;
		  bottom: 20px;
		  right: 30px;
		  z-index: 99;
		  font-size: 18px;
		  border: none;
		  outline: none;
		  background-color: red;
		  color: white;
		  cursor: pointer;
		  padding: 15px;
		  border-radius: 4px;
		}
		
		#myTopBtn:hover {
		  background-color: #555;
		}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="Static/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary" id="indexnav">
        <a class="navbar-brand" href="#" id="projecttitle1">e-MART</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
           		<a class="nav-item nav-link" href="#" id="zerobar">User</a>
                <a class="nav-item nav-link active" href="../../Login/LoginStatic/login.html" id="onebar">Login<span
                        class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="../../index.html">Home</a>
                <a class="nav-item nav-link" href="Products.html" id="twobar">Products</a>
                <a class="nav-item nav-link" href="cart.html" id="threebar">Checkout</a>
            </div>
        </div>
    </nav>




    <select id="categoryDropdown">
	    <option value="">-- Please select --</option>
	    <option value="Electronics">Electronics</option>
	    <option value="Clothing and Accessories">Clothing and Accessories</option>
	    <option value="Household and Kitchen Appliances">Household and Kitchen Appliances</option>
	    <option value="Toys and Games">Toys and Games</option>
	    <option value="Groceries">Groceries</option>
	</select>
	
	<script>
	    document.getElementById("categoryDropdown").addEventListener("change", function() {
	        var selectedCategory = this.value;
	        document.getElementById("selectedCategory").textContent = selectedCategory;
	        if (selectedCategory) {
	            window.location.href = "LoadAllProducts.jsp?choice=" + encodeURIComponent(selectedCategory);
	        } else {
	            window.location.href = "LoadAllProducts.jsp"; // Redirect to the same page without the choice parameter
	        }
	    });
	</script>

    <p>You selected: <span id="selectedCategory">None</span></p>
    <h1>Products</h1>
    
  
 <div class="main" >
		<div class="container">
			<% 
		    String choice="Electronics";

		    ProductService productService = new ProductServiceImplementation();
		    List<Product> prodList = productService.findProductsService();
		   // String choice = request.getParameter("choice");
/* 		    List<Product> prodList;
		    String choice="Electronics"; */
/* 		    if (choice.equals("Electronics")) {
	            prodList = productService.findCategoryProductsService(choice);
	        } */
	        %>
			
           <% for(Product prod : prodList) { %>
  
           
           <div class="grid-item" , class="card" style="width: 18rem;">
           <img class="card-img-top"
               src="<%= prod.getProductImage() %>"
               alt="Card image cap">
           <div class="card-body">
               <h5 class="card-title"><%=prod.getProductName()%></h5>
               <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                   card's content.</p>
               <a href="cart.jsp?productId=<%=prod.getProductId()%>" class="btn btn-primary">Add to Cart</a>
           </div>
      		</div>
      		
           <% } %>
		    </div>
		    
</div>





   
    <a href="index.html">Go Back Home</a>
</body>
</html>

