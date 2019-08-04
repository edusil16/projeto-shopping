<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Projeto Shopping</title>
</head>
<body>
<center>
        <h1>

            Criar um tipo de Segmento para as Lojas do Shopping

        </h1>
<form method="post" action="<%=request.getContextPath(%>/segmento/create">

	Nome do Segmento:

	<input type="text" name="tiposegmento">

	<br><br>

	<input type="submit" name="Salvar" />

</form>

<br><br>
	<a href="<%=request.getContextPath()%>/segmento/listar">Listar Segmentos</a>
</center>
</body>
</html>