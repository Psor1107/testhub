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

<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.model.Projeto" %>
<%
    List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
%>

<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
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
        
        .content {
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
        }

        .button {
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
        
    </style>
</head>
<body>
    <div class="content">
        <a href="index.jsp?lingua=en" class="lang-button"><fmt:message key="ingles"/></a>
        <a href="index.jsp?lingua=pt" class="lang-button"><fmt:message key="portugues"/></a>
        <br/>
        <br/>
    
        <a href="/testhub/app"><button class="button"><fmt:message key="voltarmural"/></button></a>
        <div class="card">
            <table border="1">
                <tr>
                    <th><fmt:message key="id"/></th>
                    <th><fmt:message key="nome"/></th>
                    <th><fmt:message key="desc"/></th>
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
        </div>    
    </div>
</body>
</html>