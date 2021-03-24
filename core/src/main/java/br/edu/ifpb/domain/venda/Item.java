package br.edu.ifpb.domain.venda;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 10:20:05
 */
public class Item {

    private String produto;
    private double valor;
    private int quantidade = 1;

    public Item(String produto) {
        this.produto = produto;
        this.valor = gerarValorRandomico();
    }
    public double getSubtotal(){
        return this.valor * this.quantidade;
    }

    private double gerarValorRandomico() {
        Random rnd = ThreadLocalRandom.current();
        return (double)rnd.nextInt(1500)/10;
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
