<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<body>
<center>
    <h1>
         Editar Lojas
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/loja/editar">
        CNPJ:

        <input type="text" name="CNPJ"  value="${loja.cnpj}">
        <br><br>
        Número do andar:
        <input type="number" name="Número do Andar" value="${loja.numerodoandar}">
        <br><br>
        Tipo de Segmento:
        <select name="idSegmento" >
            <c:forEach var="segmento" items="${listaSegmento}">
                <option value="${segmento.id}" ${segmento.id == loja.tiposegmento.id ? 'selected' : ''}>${segmento.tiposegmento}</option>
            </c:forEach>

        </select>
        <br><br>
        <input type="hidden" name="idLoja" value="${loja.id}">
        <input type="submit" value="Salvar" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/lojas/listar">Listar Lojas</a>


</center>
</body>
</html>
