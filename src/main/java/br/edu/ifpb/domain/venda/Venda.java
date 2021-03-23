package br.edu.ifpb.domain.venda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 11:07:49
 */
public class Venda {

    private final List<Item> produtos = new ArrayList<>();
    private String cliente;

    public void adicionar(String produto) {
        Item item = new Item(produto);
        this.produtos.add(item);
    }

    public void incrementar(String produto) {
        this.produtos.stream()
            .filter(item -> item.getProduto().equals(produto))
            .findFirst()
            .get()
            .incrementar();
    }

    public void decrementar(String produto) {
        // TODO: verificar se a quantidade ficou igual a zero
        this.produtos.stream()
            .filter(item -> item.getProduto().equals(produto))
            .findFirst()
            .get()
            .decrementar();
    }

//    }
    public void remover(String produto) {
        Item item = new Item(produto);
        this.produtos.remove(item);

    }

    public List<Item> itens() {
        return Collections.unmodifiableList(
            produtos
        );
    }

    public void finalizar(String cliente) {
        //Qual o cliente que realizou a compra
        this.cliente = cliente;
        System.out.println("--- Carrinho de compras ---");
        this.produtos.forEach(
            p -> System.out.println(p.getProduto())
        );
        double total = this.produtos
            .stream()
            .mapToDouble(Item::getValor)
            .sum();
        System.out.println("--- Total da compra:" + total + " ---");
        System.out.println("--- Carrinho finalizado ---");
    }
}
