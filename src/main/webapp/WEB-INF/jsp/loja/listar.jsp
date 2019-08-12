<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Lista de Lojas
    </h1>


    <table>
     <tr>
        <th>
            Editar |
        </th>
         <th>
            Deletar |
        </th>
        <th>
            CNPJ |
        </th>
        <th>
            Número do andar |
        </th>
        <th>
            Tipo de Segmento
        </th>
      </tr>
      <c:forEach var="loja" items="${lojaList}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/loja/edit?id=${loja.id}">Edit</a>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/loja/delete?id=${loja.id}">Delete</a>
            </td>
            <td>
                ${loja.id}
            </td>
            <td>
                ${loja.cnpj}
            </td>
            <td>
                ${loja.numeroDoAndar}
            </td>
            <td>
                ${loja.tipoSegmento.id}
            </td>
        </tr>
      </c:forEach>
     </table>

      <br><br>

      <a href="<%=request.getContextPath()%>/loja/create">Criar uma Loja</a>

       <br><br>
       <a href="<%=request.getContextPath()%>/segmento/listar">Listar Segmento</a>

</center>
</body>
</html>
