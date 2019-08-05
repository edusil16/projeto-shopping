<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
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
        <select name="id_segmento">
            <c:forEach var="segmento" items="${listaSegmentos}">
                <option value="${segmento.id}">${segmento.name}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Save" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/loja/list">Listar Lojas</a>

</center>
</body>
</html>