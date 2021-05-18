<%@page import="edu.unoesc.project.models.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Produto</title>
</head>
<body>
	<%
		ArrayList<Produto> listaProduto;
  
  		if (session.getAttribute("listaProduto") == null)
  			listaProduto = new ArrayList();
  		else 
  			listaProduto = (ArrayList) session.getAttribute("listaProduto");
  		
  		System.out.print("\n-> "+ request.getParameter("minhaVariavel")+ "\n\n");
  		int indexProdutoParaEditar = Integer.valueOf(request.getParameter("minhaVariavel")); //pegando o parametro
  		Produto c = listaProduto.get(indexProdutoParaEditar); //pegando o cliente a ser editado.
  		
  	 %>
	
	<form action="manipulaProduto" method="post">
		<p>Descrição: <input type="text" name="descricao" value="<%= c.getDescricao() %>"></p>
		<p>Marca: <input type="text" name="marca" value="<%= c.getMarca() %>"></p>
		<p>Cor: <input type="text" name="cor" value="<%= c.getCor() %>"></p>
		
		<input type="hidden" name="indice" value="<%= indexProdutoParaEditar%>">
		<input type="submit">
	</form>

</body>
</html>