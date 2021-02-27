<%@page import="java.util.List,br.com.alura.gerenciador.servlet.Empresa"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Lista de empresas</h1>
<%
	List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
%>
	<ul>
		<% for (Empresa empresa : empresas) { %>
		<li> <%= empresa.getNome() %> </li>
		<% } %>
	</ul>
</body>
</html>
