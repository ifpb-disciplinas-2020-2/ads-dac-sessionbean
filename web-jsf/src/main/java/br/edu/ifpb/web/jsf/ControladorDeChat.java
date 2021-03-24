package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.chat.Chat;
import br.edu.ifpb.infra.ServiceLocator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/03/2021, 08:18:42
 */
@Named
@RequestScoped
public class ControladorDeChat {

//    @Inject
//    @EJB
    private Chat chat;
    private String mensagem;

    @PostConstruct
    public void init(){
//          Portable JNDI names for EJB ChatOnline: [java:global/app/ChatOnline, 
//java:global/app/ChatOnline!br.edu.ifpb.domain.chat.Chat]|#]
        this.chat = ServiceLocator.loockup("java:global/core/ChatOnline!br.edu.ifpb.domain.chat.Chat");
    }
    public String enviar() {
        this.chat.nova(
            this.mensagem
        );
        this.mensagem = "";
        return null;
    }

    public List<String> todasAsMensagens() {
        return this.chat.historico();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
