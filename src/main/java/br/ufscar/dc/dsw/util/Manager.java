package br.ufscar.dc.dsw.util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Manager {

    private HttpServletRequest req;
    private HttpServletResponse resp;

    public Manager() {
    }

    public Manager(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void post(int mural) throws IOException, ServletException {

    }

    public void list(int mural) throws IOException, ServletException {

    }

    public void error(String rota) throws IOException, ServletException {

    }
}