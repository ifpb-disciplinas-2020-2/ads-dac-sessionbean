package br.edu.ifpb.domain.venda;

import java.util.Random;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 10:20:05
 */
public class Item {

    private String produto;
    private double valor = new Random().nextDouble() * 10;
    private int quantidade = 1;

    public Item(String produto) {
        this.produto = produto;
    }

    public void incrementar() {
        this.quantidade++;
    }
    
    public void decrementar() {
        this.quantidade--;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
