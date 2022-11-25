<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<title>HomeMade Spices and Snacks</title>
<style>
     body{
        background-image: url('https://th.bing.com/th/id/R.13ff4c94a06cd0d31160fdb169e2ac57?rik=rPUGN%2b%2b%2bmAQyqw&riu=http%3a%2f%2fwww.jimahoffman.com%2fBlender%2fblendertextures%2ftexture%2fwood%2fboards3_vcyc.jpg&ehk=%2b3OJpU6XbOJU%2f%2fxJfjxp8llvH%2fn3ku0OaHlY20NAKJg%3d&risl=1&pid=ImgRaw&r=0');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
          background-size: cover;
          op
      }
      
       .container{
        background-image:url('https://www.24mantra.com/wp-content/uploads/2020/11/824x465-155.png');'
        background-repeat: no-repeat;
        
       
         background-size: cover;
       
      }
      
      
    </style>
</head>
<body>
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
<form action="/products/updateproduct/${product.id}" method="post">
<input type="hidden" name="id" value="${product.id }" />

 <div class="jumbotron container border border-info">
		<h3 style = "color:white;">Update Existing Product</h3>
		
                <div class="col-sm-3">				
					<div class="form-group">
						<label for="price"style = "color:white;">Price</label> 
						<input type="number" class="form-control border border-warning"  name="price" value="${product.price}">
					</div>
					</div>
					<div class="col-sm-3">
					<div class="form-group">
						<label for="weight"style = "color:white;">Weight in grams</label> 
						<input type="number" class="form-control border border-warning"  name="weight" value="${product.weight}">
					</div>
					</div>
					<div class="col-sm-3">
					<div class="form-group">
						<label for="weight"style = "color:white;">Available Quantity</label> 
						<input type="number" class="form-control border border-warning"  name="quantity" value="${product.quantity}">
					</div>
					
					
				</div>
				
				<div class="col-sm-5"><br>
				<div class="form-group">
						<label for="description"style = "color:white;">Product Description</label>
						  <textarea class="form-control border border-warning" rows="4" name="productDescription"  value="${product.productDescription}"></textarea>
						<!--  <input class="form-control border border-warning" type="text" name="productDescription" placeholder="Product Details" ></input>-->
						
					  </div>
					<!--  <p>Product Image</p>
					<div class="custom-file">
						<input type="file" class="custom-file-input" name="productImage" accept="image/jpeg, image/png" id="productImage" onchange="loadfile(event)" /> 
						<label class="custom-file-label border border-warning" for="productImage">Choose file</label>
						
					 </div>-->
					  <!--  <div class="form-group">
						<img src="Product Images/one.jpg" alt="Hello" id="imgPreview" height="100px" width="100px"
							style="margin-top: 20px" >
					</div>
					<input type="hidden" name="imgName">
					<input type="submit" class="btn btn-primary" value="save">-->
					<table>
		<tr>
		<td>
		<div >
		<input type="submit" class="btn btn-primary" name="submit" value="Save"/>
		</td>
		</div>
		<td>
		<input type="submit" class="btn btn-primary"  name="submit" value="Cancel" />
		</td>
		</tr>
		</table>
				</div>
				
			</div>
			
			
		</form>
		
		
	</div> 

</form>

</html>