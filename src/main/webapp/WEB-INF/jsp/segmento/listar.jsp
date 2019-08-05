<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Lista de Segmentos
    </h1>


    <table>
     <tr>
        <th>
            Editar
        </th>
        <th>
            Id
        </th>
        <th>
            Tipo de Segmentos
        </th>
      </tr>
      <c:forEach var="segmento" items="${listaSegmentos}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/segmento/editar?id=${segmento.id}">Editar</a>
            </td>
            <td>
                <c:out value="${segmento.id}" />
            </td>
            <td>
                <c:out value="${segmento.tipoSegmento}" />
            </td>
        </tr>
      </c:forEach>
     </table>

      <br><br>
      <a href="<%=request.getContextPath()%>/segmento/create">Adicionar Segmento</a>
      <br><br>
       <a href="<%=request.getContextPath()%>/loja/list">Listar Lojas</a>
</center>
</body>
</html>