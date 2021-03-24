package br.edu.ifpb.api;

import br.edu.ifpb.domain.cliente.Cliente;
import br.edu.ifpb.domain.cliente.ListarClientes;
import br.edu.ifpb.domain.cliente.NovoCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/03/2021, 11:23:22
 */
@Path("clientes")
@Stateless
public class ResourcesCliente {

    @Inject
    private NovoCliente novoCliente;
    @Inject
    private ListarClientes listarClientes;

    @POST
    @Consumes("application/json")
    public Response criarCliente(Cliente cliente) {
        novoCliente.novo(cliente);
        return Response.ok(cliente).build();
    }

    @GET
    @Produces("application/json")
    public List<Cliente> todos() {
        return listarClientes.todos();
    }
}
