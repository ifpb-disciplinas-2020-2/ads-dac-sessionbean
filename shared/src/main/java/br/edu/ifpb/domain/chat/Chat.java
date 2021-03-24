package br.edu.ifpb.domain.chat;

import java.util.List;
//import javax.ejb.Remote;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/03/2021, 08:51:58
 */
//@Remote
public interface Chat {

    List<String> historico();
    void nova(String mensagem);
    
}
