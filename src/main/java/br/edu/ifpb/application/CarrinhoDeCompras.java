package br.edu.ifpb.application;

import br.edu.ifpb.domain.venda.Item;
import br.edu.ifpb.domain.venda.Venda;
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

    private String cliente;
    
    private final Venda venda = new Venda();

    public void adicionar(String produto) {
        this.venda.adicionar(produto);
    }

    public void incrementar(String produto) {
        this.venda.incrementar(produto);
    }

    public void decrementar(String produto) {
        this.venda.decrementar(produto);
    }

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
