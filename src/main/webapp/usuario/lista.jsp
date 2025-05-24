<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>
    <h1>Usuários</h1>
    <a href="usuarios/novo">Novo Usuário</a>
    <table border="1">
        <tr>
            <th>ID</th><th>Nome</th><th>Email</th><th>Tipo</th><th>Ações</th>
        </tr>
        <c:forEach var="u" items="${listaUsuarios}">
            <tr>
                <td>${u.id}</td>
                <td>${u.nome}</td>
                <td>${u.email}</td>
                <td>${u.role}</td>
                <td>
                    <a href="usuarios/edita?id=${u.id}">Editar</a> |
                    <a href="usuarios/remove?id=${u.id}">Deletar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
