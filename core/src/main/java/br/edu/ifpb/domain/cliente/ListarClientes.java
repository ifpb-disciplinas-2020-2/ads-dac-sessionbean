package br.edu.ifpb.domain.cliente;

import br.edu.ifpb.domain.Clientes;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/03/2021, 10:24:50
 */
@Stateless
public class ListarClientes {

    @EJB
    private Clientes clientes;

    public List<Cliente> todos() {
        // cache
        return this.clientes.todos();
    }

}
