package br.edu.ifpb.application;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 10:20:05
 */
public class Item {

    private String produto;
    private double valor = 10.7;

    public Item(String produto) {
        this.produto = produto;
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
