<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - TestHub</title>
    <style>
        /* Seu CSS aqui */
        .error {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login</h2>

    <%
        String erro = (String) request.getAttribute("erro");
        if (erro != null) {
    %>
        <p class="error"><%= erro %></p>
    <% } %>

    <form action="<%=request.getContextPath()%>/login" method="post">
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" required><br><br>

        <label for="senha">Senha:</label><br>
        <input type="password" id="senha" name="senha" required><br><br>

        <input type="submit" value="Entrar">
    </form>
</div>

</body>
</html>
