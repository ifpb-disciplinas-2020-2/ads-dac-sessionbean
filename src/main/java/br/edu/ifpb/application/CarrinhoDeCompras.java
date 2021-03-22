package br.edu.ifpb.application;

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
    private List<String> produtos = new ArrayList<>();
    public void adicionar(String produto){
        this.produtos.add(produto);
    }
    public void remover(String produto){
        this.produtos.remove(produto);
            
    }
    public List<String> itens(){
        return Collections.unmodifiableList(
            produtos
        );
    }
    @Remove
    public void finalizar(){
        System.out.println("--- Carrinho de compras ---");
        this.produtos.forEach(System.out::println);
//        this.produtos = new ArrayList<>();
        System.out.println("--- Carrinho finalizado ---");
    }
}
