/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contato;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

@ManagedBean
@SessionScoped
public class ContatoController {
    
private Contato contato;

    public ContatoController() {      
        if (this.contato == null) {
            this.contato = new Contato();
        }
    }
    
    
    public String enviaEmail(){
        System.out.println(getContato().getNome());
                try{
            String host ="smtp.live.com" ;
            String user = "contatoestacionamento@hotmail.com";
            String pass = "estacionamento123";
            String to = "contatoestacionamento@hotmail.com";
            String from = "contatoestacionamento@hotmail.com";
            String subject = "Formulario de contato";
            String messageText = "Nome: " + getContato().getNome()
                               + "<br>Email: " + getContato().getEmail()
                               + "<br>Assunto: " + getContato().getAssunto()
                               + "<br>Mensagem: " + getContato().getMensagem();
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            //msg.setText(messageText);
            msg.setContent(messageText, "text/html; charset=utf-8");

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("Mensagem enviado com sucesso!");
           this.contato = new Contato();
           return "index?faces-redirect=true&erro=false";  
        }catch(Exception ex)
        {
            System.out.println("Ocorreu um erro ao enviar o email: "+ex);
        }
          return "index?faces-redirect=true&erro=true";     
                
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
