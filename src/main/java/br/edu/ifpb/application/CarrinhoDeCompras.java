package br.edu.ifpb.application;

import br.edu.ifpb.domain.venda.Item;
import br.edu.ifpb.domain.venda.Venda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 09:09:33
 */
@Stateful
public class CarrinhoDeCompras {

//    private List<Item> produtos = new ArrayList<>();
    private String cliente;
    
    // TODO: toda a lógica para a classe Venda
    private Venda venda = new Venda();

    public void adicionar(String produto) {
        this.venda.adicionar(produto);
//        Item item = new Item(produto);
//        this.produtos.add(item);
    }

    public void incrementar(String produto) {
        this.venda.incrementar(produto);
    }

    public void decrementar(String produto) {
        this.venda.decrementar(produto);
    }

//    }
    public void remover(String produto) {
        this.venda.remover(produto);
    }

    public List<Item> itens() {
        return this.venda.itens();
    }

    @Remove
    public void finalizar(String cliente) {
        this.venda.finalizar(cliente);
        // TODO: processar pagamento
        // TODO: enviar confirmação do pedido
    }
}
