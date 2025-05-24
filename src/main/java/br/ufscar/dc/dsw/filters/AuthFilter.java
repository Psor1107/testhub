package br.ufscar.dc.dsw.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // Aqui serão todas as rotas, menos as de estrategia, pois um visitante pode acessa-las
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/auth/login.jsp";
        String loginServlet = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("usuarioLogado") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI) || request.getRequestURI().equals(loginServlet);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + "/css")
                || request.getRequestURI().startsWith(request.getContextPath() + "/js")
                || request.getRequestURI().startsWith(request.getContextPath() + "/images");

        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(req, res);
        } else {
            response.sendRedirect(loginURI);
        }
    }
}
