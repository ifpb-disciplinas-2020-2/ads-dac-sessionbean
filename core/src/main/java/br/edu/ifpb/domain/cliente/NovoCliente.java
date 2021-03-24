package br.edu.ifpb.domain.cliente;

import br.edu.ifpb.domain.Clientes;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/03/2021, 10:18:58
 */
@Stateless
public class NovoCliente {

    @EJB
    private Clientes clientes;

    public void novo(Cliente cliente) {
        //validar cliente é válido e poder ser persistido
//        Objects.requireNonNull(cliente,"O cliente não pode ser nulo");
        if (cliente == null) {
            System.out.println("LOG -- Cliente nulo");
            return;
        }
        if (cliente.valido()) {
            clientes.novo(cliente);
        }
    }

}
