package br.edu.ifpb.infra;

import br.edu.ifpb.domain.chat.Chat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/03/2021, 09:30:39
 */
public class ServiceLocator {

    public static Chat loockup(String recurso) {
        try {
            //ip
            //port
// {java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory,
// java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl,
// java.naming.factory.url.pkgs=com.sun.enterprise.naming}
            Properties props = new Properties();
            props.setProperty("org.omg.CORBA.ORBInitialHost","host-core");
            props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
            props.setProperty("java.naming.factory.initial","com.sun.enterprise.naming.impl.SerialInitContextFactory");
            Context context = new InitialContext(props);
            return (Chat) context.lookup(recurso);
            
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;

    }
}
