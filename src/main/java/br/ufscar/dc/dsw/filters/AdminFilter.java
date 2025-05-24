package br.ufscar.dc.dsw.filters;

import br.ufscar.dc.dsw.model.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/usuarios/*"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String contextPath = request.getContextPath();
        String path = request.getRequestURI().substring(contextPath.length());

        // Lista de rotas que devem ser protegidas
        boolean rotaProtegida = path.equals("/usuarios/novo")
                || path.equals("/usuarios/edita")
                || path.equals("/usuarios/remove");

        if (rotaProtegida) {
            Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogado") : null;

            if (usuario != null && "ADMIN".equals(usuario.getRole())) {
                chain.doFilter(req, res);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Acesso restrito a administradores.");
            }
        } else {
            // Se não for rota protegida, permite o acesso
            chain.doFilter(req, res);
        }
    }
}
