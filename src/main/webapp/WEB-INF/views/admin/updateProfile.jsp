<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1> Admin Profile Update:</h1>
  <div class="card">
   <div class="card-body">
    <form action="/admin/updateProfile/${user.id}" method="post">
    
    <input type="hidden" name="id" value="${user.id}" />
    <input type="hidden" name="pass" value="${user.pass}" />
        <input type="hidden" name="role" value="${user.role}" />
            <input type="hidden" name="cnfmpass" value="${user.cnfmpass}" />
     <div class="form-group row">
      <label for="name" class="col-sm-2 col-form-label">
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="name"
        value="${user.name}">
      </div>
     </div>

     
     

     <div class=" form-group row">
      <label for="email" class="col-sm-2 col-form-label">
       Email</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="email"
         value="${user.email}">
      </div>
     </div>
     
      <div class=" form-group row">
      <label for="username" class="col-sm-2 col-form-label">
       Username</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="username"
         value="${user.username}">
      </div>
     </div>
     

     <!-- <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="pass"
        placeholder="Enter Password">
      </div>
     </div>
     
     <div class="form-group row">
      <label for="cnfmpass" class="col-sm-2 col-form-label">Confirm Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="cnfmpass"
        placeholder="Enter Password">
      </div>
     </div> -->

     <div class="form-group row">
      <label for="address" class="col-sm-2 col-form-label">Address</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="address"
         value="${user.address}">
      </div>
     </div>

     <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact
       No</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="contact"
         value="${user.contact}">
      </div>
     </div>

     <button type="submit" class="btn btn-primary"  name="submit" >submit</button>
    
    </form>
    
    <br/>
      <form action="/admin/adminhome/${user.id}" method="get">
     <button type="submit" class="btn btn-primary">Cancel</button>
     </form>

</body>
</html>