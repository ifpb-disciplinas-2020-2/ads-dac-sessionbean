package br.edu.ifpb.domain.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/03/2021, 08:33:04
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SalaDeBatePapo {

    private List<String> mensagens = new ArrayList<>();
    private Object lock  = new Object();
    public void nova(String mensagem) {
        System.out.println("outra linha...");
        synchronized (lock) {
            // Alteramos o estado dos atributos do objeto. (mensagens) 
            this.mensagens.add(mensagem);
        }
        System.out.println("outra linha...");
    }

    public List<String> historico() {
        // Não alteramos o estado dos atributos do objeto 
        return Collections.unmodifiableList(
            mensagens
        );
    }
    //    public synchronized void nova(String mensagem) {
//        // Alteramos o estado dos atributos do objeto. (mensagens) 
//        this.mensagens.add(mensagem);
//    }
//    public void nova(String mensagem) {
//        synchronized (this) {
//            // Alteramos o estado dos atributos do objeto. (mensagens) 
//            this.mensagens.add(mensagem);
//        }
//        System.out.println("outra linha...");
//    }
//    public void nova(String mensagem) {
//        synchronized (mensagens) {
//            // Alteramos o estado dos atributos do objeto. (mensagens) 
//            this.mensagens.add(mensagem);
//        }
//        System.out.println("outra linha...");
//    }
}
