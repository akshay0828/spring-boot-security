<!doctype html>
<%@page import="java.sql.*"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<title>Document</title>

<style>
     body{
        background-image: url('https://th.bing.com/th/id/R.13ff4c94a06cd0d31160fdb169e2ac57?rik=rPUGN%2b%2b%2bmAQyqw&riu=http%3a%2f%2fwww.jimahoffman.com%2fBlender%2fblendertextures%2ftexture%2fwood%2fboards3_vcyc.jpg&ehk=%2b3OJpU6XbOJU%2f%2fxJfjxp8llvH%2fn3ku0OaHlY20NAKJg%3d&risl=1&pid=ImgRaw&r=0');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
          background-size: cover;
          
      }
      
       .container{
        background-image:url('https://www.24mantra.com/wp-content/uploads/2020/11/824x465-155.png');'
        background-repeat: no-repeat;
        
       
         background-size: cover;
       
      }
      
      
    </style>
</head>
<body>
<div class="c1">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				th:src="@{/images/logo.png}" src="../static/images/logo.png"
				width="auto" height="40" class="d-inline-block align-top" alt="" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto"></ul>
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="/adminhome" >Home Page</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/logout" >Logout</a></li>

				</ul>

			</div>
		</div>
	</nav><br>
	<div class="container">
	<div >
	
		<h3 style = "color:white;">Add a new Product</h3>
		<form action="/admin/products" method="post">
			<!--  <div class="row">-->
			<br>
			<br>
				<div class="col-sm-3">
					<div class="form-group" >
						<label for="price" style = "color:white;">Price</label> 
						<input type="number" class="form-control border border-warning" required name="price" min="1" placeholder="Price">
					</div>
				</div>
				<br>
				<br>
					<div class="col-sm-3">
					<div class="form-group">
						<label for="weight" style = "color:white;">Weight in grams</label> 
						<input type="number" class="form-control border border-warning" required name="weight" min="1" placeholder="Weight">
					</div>
					</div>
					<br>
				<br>
					<div class="col-sm-3">
					<div class="form-group">
						<label for="weight" style = "color:white;">Available Quantity</label> 
						<input type="number" class="form-control border border-warning" required name="quantity" min="1" placeholder="Quantity">
					</div>
					</div>
					<br>
				<br>
					
					
				<!-- </div> -->
				
				<div class="col-sm-5"><br>
				<div class="form-group">
						<label for="description" style = "color:white;" >Product Description</label>
						  <textarea class="form-control border border-warning" rows="4" name="productDescription" placeholder="Product Details" value= "no product details"></textarea>
						<!--  <input class="form-control border border-warning" type="text" name="productDescription" placeholder="Product Details" ></input>-->
						
					</div>
					<br>
				<br>
					<!--  <p>Product Image</p>
					<div class="custom-file">
						<input type="file" class="custom-file-input" name="productImage" accept="image/jpeg, image/png" id="productImage" onchange="loadfile(event)" /> 
						<label class="custom-file-label border border-warning" for="productImage">Choose file</label>
						
					</div>
					<div class="form-group">
						<img src="Product Images/one.jpg" alt="Hello" id="imgPreview" height="100px" width="100px"
							style="margin-top: 20px" >
					</div>
					<input type="hidden" name="imgName">
					<br>-->
					<input type="submit" class="btn btn-primary">
				</div>
			</div>
			
		</form>
	</div>
	</div>
	
	

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
		<script type="text/javascript">
						var loadFile = function(event) {
							var image = document.getElementById('imgPreview');
							image.src = URL.createObjectURL(event.target.files[0]);
						};
						</script>
						
						</div>
</body>
</html></html>