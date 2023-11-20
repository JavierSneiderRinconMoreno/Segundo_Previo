<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movimientos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity=" sha384-gg0yROIXCbv3Xipma34MD+dH/1fQ784/j6cY/ITQUOhcWr7×93voR×T2MZwIT" crossorigin="anonymous">
</head>
<body>

 <img src="descarga.png" alt="Banco">
 
 <h2>MOVIMIENTOS</h2>
 
 <div class="row">
		<!-- <div class="alert alert-success" *ngIf= 'message'>({message}}</div> -->
		<div class="container">
		
		<hr>
		
		<table class="table table-bordered">
		<thead>
			<tr>
			<th>Movimento</th>
			<th></th>
			
		</tr>
		</thead>
		<tbody>
			<!-- for (todo todo: todo ) { -->
			
			<c:forEach  var = "bill" items="${listBill}"> 
			 
			<tr>
			<td>
				<c:out value="${bill.date}"/>
				<c:out value="${bill.observation}"/>
				
			</td>
			<td>
				$ <c:out value="${usuario.value}"/>
			</td>
			
				<a href="edit?id=<c:out value="${usuario.id}"/> ">Editar </a>
&nbsp;&nbsp;&nbsp;&nbsp;
				 <a href="delete?id=<c:out value="${usuario.id}"/> ">Eliminar </a> 
			</td>
			</tr>		
		</c:forEach>	
			
		</tbody>
		
		</table>
	</div>
 
 
 

</body>
</html>