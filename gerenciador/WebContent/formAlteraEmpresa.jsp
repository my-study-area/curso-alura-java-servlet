<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi��o de Empresas</title>
</head>
<body>

<form action="" method="post">
	Nome: <input type="text" name="empresa" value="${empresa.nome}" /> <br />
	Data Abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" /> <br />
	<input type="submit" value="Editar"/>
</form>
</body>
</html>