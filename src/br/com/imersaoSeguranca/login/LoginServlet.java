package br.com.imersaoSeguranca.login;

import br.com.imersaoSeguranca.bd.Conexao;
import br.com.imersaoSeguranca.jdbc.UsuarioJDBC;
import br.com.imersaoSeguranca.modelo.Usuario;
import br.com.imersaoSeguranca.rest.UsuarioRest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        session.setMaxInactiveInterval(300);
        String usuario = null;
        if (session != null ){
            usuario = (String) session.getAttribute("login");
        }
        String senha = req.getParameter("senha");
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        Usuario objUsuario = usuarioJDBC.efetuaLogin(req.getParameter("login"), req.getParameter("senha"));
        Conexao conec = new Conexao();
        Connection conexao = conec.abrirConexao();


    }
}
