package br.edu.ifpb.domain;

import br.edu.ifpb.domain.cliente.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Clientes {

    void novo(Cliente cliente);

    List<Cliente> todos();

}
