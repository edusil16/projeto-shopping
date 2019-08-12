<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
 <meta charset="UTF-8">
</head>
<body>
<center>
    <h1>
         Criar uma nova Loja
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/loja/create">

        CNPJ:
        <input type="text" name="cnpj"  >
        <br><br>

        Número do Andar:
        <input type="number" name="numerodoandar" >
        <br><br>

        Tipo de Segmento:
        <select name="id_lojasegmento">
            <c:forEach var="segmento" items="${listaSegmentos}">
                <option value="${segmento.id}">${segmento.tipoSegmento}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Salvar" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/loja/listar">Listar Lojas</a>

</center>
</body>
</html>