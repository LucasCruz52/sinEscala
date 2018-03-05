package br.huufs.sinEscala.DAO.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleAcesso implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if ((session.getAttribute("USUARIOLogado") != null)
                || (req.getRequestURI().endsWith("loginUsuario.jsf"))
                || (req.getRequestURI().contains("javax.faces.resource/"))) {

            

                //redireciona("/Logado.xhtml", response);
            
            chain.doFilter(request, response);
        }

        else {
            redireciona("/dashboard.xhtml", response);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    private void redireciona(String url, ServletResponse response)
            throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }
}