<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="idioma.jspf" %>

<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TestHub - Plataforma de Testes Exploratórios</title>
    <style>
        :root {
            --dark-green: #606C38;
            --deep-green: #283618;
            --light-cream: #FEFAE0;
            --light-orange: #DDA15E;
            --dark-orange: #BC6C25;
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
        
        .nav-bar {
            background-color: var(--dark-green);
            padding: 15px;
            display: flex;
            justify-content: center;
            gap: 20px;
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
        
        .button:hover {
            background-color: var(--dark-orange);
            color: var(--light-cream);
        }
        
        .content {
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
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
    <div class="header">
        <h1>TestHub</h1>
        <p><fmt:message key="plataformaGerenc"/></p>
    </div>
    
    <div class="nav-bar">
        <a href="/testhub/app/listar"><button class="button"><fmt:message key="projetos"/></button></a>
        <button class="button"><fmt:message key="sessões"/></button>
        <button class="button"><fmt:message key="estrategias"/></button>
        <a href="/testhub//auth/login.jsp"><button class="button">Login</button></a>
    </div>
    <a href="mural.jsp?lingua=en" class="lang-button"><fmt:message key="ingles"/></a>
    <a href="mural.jsp?lingua=pt" class="lang-button"><fmt:message key="portugues"/></a>
    
    <div class="content">
        <div class="card">
            <h2><fmt:message key="bemvindo"/></h2>
            <p><fmt:message key="gerencie"/></p>
        </div>
        
        <div class="card">
            <h3><fmt:message key="ultimasAtiv"/></h3>
            <div style="display: flex; gap: 20px; margin-top: 15px;">
                <div style="flex: 1; padding: 15px; background-color: var(--light-cream); border-radius: 8px;">
                    <h4><fmt:message key="projAtiv"/></h4>
                    <p><fmt:message key="3projAnd"/></p>
                </div>
                
                <div style="flex: 1; padding: 15px; background-color: var(--light-cream); border-radius: 8px;">
                    <h4><fmt:message key="sessoesRec"/></h4>
                    <p><fmt:message key="5sessocesConc"/></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>