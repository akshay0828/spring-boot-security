<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="w-100" align="center">
	<h2>List of Products</h2>

	<table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Photo</th>
            <th>Price</th>
            <th>Buy</th>
        </tr>
        <c:forEach var="pro" items="${pro}">
            <tr>
                <td>${pro.id }</td>
                <td>${pro.weight }</td>
               
                <td>${pro.price }</td>
                <td>${pro.quantity }</td>
                <td>${pro.productDescription }</td>
                
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>