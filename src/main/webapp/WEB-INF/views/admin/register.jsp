<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h1>Register Account</h1><br>
<form action="/register" method="post">
 <table>
<tr>
<td>Name</td>
</tr>
<tr>
<td><input name="name" type="text"/> </td>
</tr>
<td>Address</td>
</tr>
<tr>
<td><input name="address" type="text"/> </td>
</tr>
<td>Email</td>
</tr>
<tr>
<td><input name="email" type="text"/> </td>
</tr>
<td>PhoneNumber</td>
</tr>
<tr>
<td><input name="phone_No" type="text"/> </td>
</tr>
<td>UserName</td>
</tr>
<tr>
<td><input name="username" type="text"/> </td>
</tr>
<td>Password</td>
</tr>
<tr>
<td><input name="password" type="text"/> </td>
</tr>
<td>ConfirmPassword</td>
</tr>
<tr>
<td><input name="confirmpassword" type="text"/> </td>
</tr>



</table> 
</br>

<input name="submit" value="Register" type="submit"/> 


</form> 

</body>
</html>-->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 





</style>

      
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>






	<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-family: sans-serif;
}

 body{
        background-image: url('https://i.pinimg.com/originals/b1/83/67/b18367603d1f83fc01c8b9128b4c1ba3.jpg') ;
        background-repeat: no-repeat;
        background-attachment: fixed;
           background-position: center center; 
           background-size: cover;
      height: 100%;

  padding: 5px;
  width: 100%;
      } 

.container {

	width: 100%;
	max-width: 650px;
	background: rgba(0, 0, 0, 0.5);
	padding: 28px;
	
	margin:  100px auto;
	border-radius: 10px;
	
}

.form-title {
	font-size: 26px;
	font-weight: 600;
	text-align: center;
	padding-bottom: 6px;
	color: white;
	text-shadow: 2px 2px 2px black;
	border-bottom: solid 1px white;
}

.main-user-info {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	padding: 20px 0;
}

.user-input-box:nth-child(2n) {
	justify-content: end;
}

.user-input-box {
	display: flex;
	flex-wrap: wrap;
	width: 50%;
	padding-bottom: 15px;
}

.user-input-box label {
	width: 95%;
	color: white;
	font-size: 20px;
	font-weight: 400;
	margin: 5px 0;
}

.user-input-box input {
	height: 40px;
	width: 95%;
	border-radius: 7px;
	outline: none;
	border: 1px solid grey;
	padding: 0 10px;
}

.form-submit-btn input {
	cursor: pointer;
}

.form-submit-btn {
	margin-top: 40px;
}

.form-submit-btn input {
	display: block;
	width: 100%;
	margin-top: 10px;
	font-size: 20px;
	padding: 10px;
	border: none;
	border-radius: 3px;
	color: rgb(209, 209, 209);
	background: rgba(63, 114, 76, 0.7);
}

.form-submit-btn input:hover {
	background: rgba(56, 204, 93, 0.7);
	color: rgb(255, 255, 255);
}

@media ( max-width : 600px) {
	.container {
		min-width: 280px;
	}
	.user-input-box {
		margin-bottom: 12px;
		width: 100%;
	}
	.user-input-box:nth-child(2n) {
		justify-content: space-between;
	}
	.main-user-info {
		max-height: 380px;
		overflow: auto;
	}
	.main-user-info::-webkit-scrollbar {
		width: 0;
	}
}
</style>
<body>
<center>
	<div class="container">
		<h1 class="form-title">Sign Up as Seller</h1>
		<form action="/admin/register" method="post">
		
			<div class="main-user-info">
			
				<div class="user-input-box">
					<label for="fullName">Full Name</label> <input type="text" required
						id="fullName" name="name" placeholder="Enter Full Name" />
				</div>
				<div class="user-input-box">
					<label for="username">Username</label> <input type="text" required pattern="[A-Za-z]{3,10}"  title="User name must be between 3-10 characters!!"
						id="username" name="username" placeholder="Enter Username" />
				</div>
				<div class="user-input-box">
					<label for="email">Email</label> <input type="email" id="email" required
						name="email" placeholder="Enter Email" />
				</div>
				<div class="user-input-box">
					<label for="phoneNumber">Phone Number</label> <input type="text" required
						id="phoneNumber" name="contact" pattern="^\d{10}$"  title="Invalid Phone number!!"
						placeholder="Enter Phone Number" />
				</div>
				<div class="user-input-box">
					<label for="password">Password</label> <input type="password" required
						id="password" name="pass" placeholder="Enter Password"  pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!" />
				</div>
				<div class="user-input-box">
					<label for="confirmPassword">Confirm Password</label> <input
						type="password" id="confirmPassword" name="cnfmpass" required
						placeholder="Confirm Password" />
				</div>
				<div class="user-input-box">
					<label for="confirmPassword">Address</label> <input
						type="text" id="address" name="address" required
						placeholder="Address" />
				</div>
			</div>
			
    <c:if test="${not empty error }">
        <div style="color:red;"><h3>${error}</h3></div><br/>
        </c:if>
        
         <c:if test="${not empty error }">
        <div style="color:red;"><h3>${userna}</h3></div><br/>
        </c:if>
        
        
			<div class="form-submit-btn">
				<input type="submit" value="Submit and Back to Login">
			</div>
		</form>

		<div class="form-submit-btn">
			<form action="/index" method="get">
				<input type="submit" value="Cancel">
			</form>
		</div>

		</form>
	</div>
	</center>
</body>
</html>

<!-- 

	<div class="container">
		<h1>Admin Registration Form:</h1>
		<div class="card">
			<div class="card-body">
				<form action="/admin/register" method="post">

					<div class="form-group row">
						<label for="name" class="col-sm-2 col-form-label"> Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								placeholder="Enter name">
						</div>
					</div>




					<div class=" form-group row">
						<label for="email" class="col-sm-2 col-form-label"> Email</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email"
								placeholder="Enter Email">
						</div>
					</div>

					<div class=" form-group row">
						<label for="username" class="col-sm-2 col-form-label">
							Username</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="username"
								placeholder="Enter Username">
						</div>
					</div>


					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="pass"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group row">
						<label for="cnfmpass" class="col-sm-2 col-form-label">Confirm
							Password</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="cnfmpass"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group row">
						<label for="address" class="col-sm-2 col-form-label">Address</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="address"
								placeholder="Enter Address">
						</div>
					</div>

					<div class="form-group row">
						<label for="contact" class="col-sm-2 col-form-label">Contact
							No</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="contact"
								placeholder="Enter Contact Address">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Submit and
						Back to Login</button>

				</form>
				<br />
				<form action="/index" method="get">
					<button type="submit" class="btn btn-primary">Cancel</button>
				</form>
			</div>
		</div>
	</div>-->


