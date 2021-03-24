package br.edu.ifpb.web;

import br.edu.ifpb.domain.cliente.Cliente;
import br.edu.ifpb.domain.cliente.ListarClientes;
import br.edu.ifpb.domain.cliente.NovoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDeClientes",urlPatterns = {"/clientes"})
public class ControladorDeClientes extends HttpServlet {

    @Inject
    private NovoCliente novoCliente;
    @Inject
    private ListarClientes listarClientes;

    // Listar todos os clientes
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Listagem com SessionBeans  </h1>");
            listarClientes(out);
            out.println("<h4> versão: pós-api </h4>");
            out.println("</body>");
            out.println("</html>");
        }
    }

// Criar um novo Cliente
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Cliente cliente = new Cliente(cpf,nome);
        this.novoCliente.novo(cliente);
        response.sendRedirect("clientes");
    }

    private void listarClientes(final PrintWriter out) {
        this.listarClientes
            .todos()
            .forEach(c
                -> out.println("<p>" + c.getNome() + "</p>")
            );
    }

}
// container web (tomcat, jetty,..) -> gerenciar ciclo de vida de uma servlet
// container aplicação (payara, glassfish, widlfy..) -> gerenciar a aplicação (lógica de negócio)
