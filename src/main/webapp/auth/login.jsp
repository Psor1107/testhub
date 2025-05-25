<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="idiomaSolicitado" value="${param.lingua}" />
<c:if test="${not empty idiomaSolicitado}">
    <fmt:setLocale value="${idiomaSolicitado}" />
    <c:set var="userLocaleInSession" value="${idiomaSolicitado}" scope="session" />
</c:if>
<c:if test="${empty idiomaSolicitado and not empty sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}">
    <fmt:setLocale value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" />
</c:if>

<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - TestHub</title>
    <style>
        :root {
            --deep-green: #283618;
            --light-cream: #FEFAE0;
            --light-orange: #DDA15E;
        }
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: var(--light-cream);
            color: var(--deep-green);
        }
        .header {
            background-color: var(--deep-green);
            color: var(--light-cream);
            padding: 20px;
            text-align: center;
        }
        .content {
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
        }
        .input {
            background-color: var(--light-orange);
            color: var(--deep-green);
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            font-weight: bold;
        }

        .card {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            margin: 20px 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .card label {
            color: #606C38;
        }   
         
        .error {
            color: red;
        }
    </style>
</head>
<body>

<div >
    <div class="header">
        <h2>Login</h2>
    </div>
 
    <a href="login.jsp?lingua=en" class="lang-button"><fmt:message key="ingles"/></a>
    <a href="login.jsp?lingua=pt" class="lang-button"><fmt:message key="portugues"/></a>

    <%
        String erro = (String) request.getAttribute("erro");
        if (erro != null) {
    %>
        <p class="error"><%= erro %></p>
    <% } %>

    <div class="content">
        <div class="card">
            <form action="<%=request.getContextPath()%>/login" method="post">
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email" required><br><br>
        
                <label for="senha"><fmt:message key="login.senha"/></label><br>
                <input type="password" id="senha" name="senha" required><br><br>
        
                <input class="input" type="submit" value="<fmt:message key="login.entrar"/>">   
            </form>
        </div>
    </div>
</div>

</body>
</html>
