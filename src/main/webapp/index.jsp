<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.model.Projeto" %>
<%
    List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
%>
<a href="/testhub/app"><button class="button">Voltar ao mural</button></a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
    </tr>
    <%
        if (projetos != null) {
            for (Projeto p : projetos) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getNome() %></td>
        <td><%= p.getDescricao() %></td>
    </tr>
    <%
            }
        }
    %>
</table>