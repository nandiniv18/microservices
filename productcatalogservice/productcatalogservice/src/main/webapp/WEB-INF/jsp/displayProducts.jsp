<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Product List Title</title> 
<style>
                  table,th,td
                   {
                    font-family: Ariel;
                    font-size:16px;
                    border:1px solid black;
                    border-color: black;
                    border-width: 1px;
                    border-collapse: collapse;
                    padding: 3px;
                   }
                   th{
                       background-color: lightskyblue;
                   }
                   </style>
</head>

<body>
	<div class="container">
		<table > 
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${datalist}' var="list">
					<tr>
						<td>${list.name}</td>
						<td>${list.description}</td>
						<td>${list.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>

</html>