package Entities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mailer implements Runnable {

    boolean isAgent; //true for agent mailer, false for Manufacturer
    Form to_inform;
    Agent to_send_to;
    String message;

    /**
     * @author Michael & Elizabeth
     */

  //  public Mailer(){

    //}

    /**
     * The constructor for a manufacturer inform thread Mailer
     * @param form the form which has been updated
     */
    public Mailer(Form form){
        to_inform = form;
        isAgent = false;
    }

    /**
     * The constructor for an agent inform thread Mailer
     * @param to_inform
     * @param message
     */
    public Mailer(Agent to_inform, String message){
        to_send_to = to_inform;
        this.message = message;
        isAgent = true;
    }

    /**
     * Informs the comopany that their form has been updated
     * @param to_inform the form which has been updated, which has the company to be informed.
     */
    public void sendMail(Form to_inform) {
        String host = "smtp.gmail.com";
        String from = "TTBTEAME@gmail.com";
        String pass = "michaelclements";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        try {
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            InternetAddress toAddress = new InternetAddress();

                toAddress = new InternetAddress(to_inform.getEmail());
            System.out.println(Message.RecipientType.TO);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            String body = "Hello ";
            body += ",\n";
            body += "There are updates on your form! Please use the TTB Application to check your status.\n";
            body += "Your form's current status is " + to_inform.getApprovalStatus().toString();
            body += "\n Sincerely yours,";
            body += "The Ebony Elves' TTB Application";
            message.setText(body);
            message.setSubject("RE: TTB APP UPDATE");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mx) {
            mx.printStackTrace();
        }

    }

    /**
     * Sends a message to an agent when they have a form updated
     * @param to_inform the agent to be emailed
     * @param msg the message to send
     */
    public void sendAgentMail(Agent to_inform, String msg) {
        String host = "smtp.gmail.com";
        String from = "TTBTEAME@gmail.com";
        String pass = "michaelclements";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        try {
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            InternetAddress toAddress = new InternetAddress();

            toAddress = new InternetAddress(to_inform.getLogin());
            System.out.println(Message.RecipientType.TO);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            String body = "Hello ";
            body += ",\n";
            body += "You have been assigned a new form. Please log in and check your TTB Form Queue.\n";
            body += "The sending agent has specified the following message: \n";
            body += msg + "\n";
            body += "\n Sincerely yours,";
            body += "The Ebony Elves' TTB Application";
            message.setText(body);
            message.setSubject("RE: TTB QUEUE UPDATE");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mx) {
            mx.printStackTrace();
        }
    }

    @Override
    public void run() {
        if(this.isAgent){
            sendAgentMail(this.to_send_to, message);
        } else {
            sendMail(this.to_inform);
        }
    }
}