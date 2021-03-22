package br.edu.ifpb.web.jsf;

import br.edu.ifpb.application.CarrinhoDeCompras;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2021, 09:14:44
 */
@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

//    @EJB
    @Inject
    private CarrinhoDeCompras carrinho;
    private String produto;
    private String cliente;

    public String novo() {
        this.carrinho.adicionar(
            this.produto
        );
        this.produto = "";
        return null;
    }
    public String remover(String produto) {
        this.carrinho.remover(produto);
        return null;
    }
    public List<String> todosOsProdutos() {
        return this.carrinho.itens();
    }
    public String checkout() {
        this.carrinho.finalizar();
        // TODO: uma nova instância para o carrinho
//        this.carrinho = CDI.current()
//            .getBeanManager()
//            .getBeans("java:global/app/CarrinhoDeCompras");
        //logout
        logout();
        return "index?faces-redirect=true";
    }
    private void logout() {
        HttpSession session = (HttpSession) FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .getSession(true);
        session.invalidate();
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
