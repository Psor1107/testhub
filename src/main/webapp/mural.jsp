<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <p>Plataforma de Gerenciamento de Testes Exploratórios</p>
    </div>
    
    <div class="nav-bar">
        <a href="/testhub/app/listar"><button class="button">Projetos</button></a>
        <button class="button">Sessões</button>
        <button class="button">Estratégias</button>
        <button class="button">Login</button>
    </div>
    
    <div class="content">
        <div class="card">
            <h2>Bem-vindo ao TestHub!</h2>
            <p>Gerencie suas sessões de teste de forma eficiente e colaborativa</p>
        </div>
        
        <div class="card">
            <h3>Últimas Atividades</h3>
            <div style="display: flex; gap: 20px; margin-top: 15px;">
                <div style="flex: 1; padding: 15px; background-color: var(--light-cream); border-radius: 8px;">
                    <h4>Projetos Ativos</h4>
                    <p>3 projetos em andamento</p>
                </div>
                
                <div style="flex: 1; padding: 15px; background-color: var(--light-cream); border-radius: 8px;">
                    <h4>Sessões Recentes</h4>
                    <p>5 sessões concluídas</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>