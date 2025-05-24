<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <h1>${usuario == null ? "Novo" : "Editar"} Usuário</h1>
    <form action="usuarios/${usuario == null ? 'insere' : 'atualiza'}" method="post">
        <input type="hidden" name="id" value="${usuario.id}" />
        Nome: <input type="text" name="nome" value="${usuario.nome}" required/><br/>
        Email: <input type="email" name="email" value="${usuario.email}" required/><br/>
        Senha: <input type="password" name="senha" value="${usuario.senha}" required/><br/>
        Tipo:
        <select name="role">
            <option value="ADMIN" ${usuario.role == 'ADMIN' ? 'selected' : ''}>Admin</option>
            <option value="TESTER" ${usuario.role == 'TESTER' ? 'selected' : ''}>Tester</option>
        </select><br/>
        <input type="submit" value="Salvar"/>
    </form>
    <a href="../usuarios">Voltar</a>
</body>
</html>
