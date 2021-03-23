package br.edu.ifpb.domain.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/03/2021, 08:01:29
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Remote(Chat.class)
//@Lock(LockType.WRITE)
public class ChatOnline implements Chat {

    private List<String> mensagens = new ArrayList<>();

    @Lock(LockType.WRITE)
    @Override
    public void nova(String mensagem) {
        // Alteramos o estado dos atributos do objeto. (mensagens) 
        this.mensagens.add(mensagem);
    }

    @Lock(LockType.READ)
    @Override
    public List<String> historico() {
        // Não alteramos o estado dos atributos do objeto 
        return Collections.unmodifiableList(
            mensagens
        );
    }
}
