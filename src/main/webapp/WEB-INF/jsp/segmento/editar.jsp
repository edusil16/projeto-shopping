<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<center>
    <h1>
         Editar Segmento
    </h1>

     ${message}

    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/segmento/editar">
        Name:

        <input type="text" name="tiposegmento" value="${editarPage.tipoSegmento}"  >

        <br><br>
        <input type="hidden" name="id" value="${editarPage.id}"  >

        <input type="submit" value="Salvar" />
    </form>

     <br><br>
     <a href="<%=request.getContextPath()%>/segmento/listar">Lista de Segmentos</a>


</center>
</body>
</html>
