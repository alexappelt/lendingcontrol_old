<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>
<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaProduto.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Descrição</th>
					<th>Marca</th>
					<th>Cor</th>
					<th>Valor</th>
					<th>teste</th>
				</tr>
				<c:forEach var="c" items="${listaProduto}">
					<tr>
						<td>${c.descricao}</td>
						<td>${c.marca}</td>
						<td>${c.cor}</td>
						<td>${c.valor}</td>
					<%--<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dataNasc}"/></td> --%>
						<td><a href="produto/produtoEdit/${c.id}">Editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		
				<form action="/Project/produto/produtoSave" method="POST" modelAttribute="produto">
					<form:hidden path="produto.id" />
					<p>
						Descrição:
						<form:input path="produto.descricao" />

					</p>

					<p>
						Marca:
						<form:input path="produto.marca" />

					</p>
					
					<p>
						Cor:
						<form:input path="produto.cor" />

					</p>
					
					<p>
						Valor:
						<form:input path="produto.valor" />

					</p>
					
<!-- 					<p> -->
<!-- 					teste:  -->
<%-- 						<form:input type="date" path="cliente.dataNasc" /> --%>

<!-- 					</p> -->

					<input type="submit" value="Salvar" />

				</form>
			</div>

</body>
</html>