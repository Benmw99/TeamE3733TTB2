package Entities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;


public class Mailer implements Runnable {

    boolean isAgent; //true for agent mailer, false for Manufacturer
    Form to_inform;
    Agent to_send_to;
    String message;

    /**
     * @author Michael & Elizabeth
     */

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
    public Mailer(Agent to_inform, String message, Form form){
        to_send_to = to_inform;
        this.message = message;
        isAgent = true;
        this.to_inform = form;
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

            new FormExporter(to_inform);
            mailHelper(message, body, to_inform);

            message.setSubject("RE: TTB APP UPDATE");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mx) {
            mx.printStackTrace();
        }

    }

    private void mailHelper(MimeMessage message, String body, Form form) throws MessagingException {
        body += "\n Sincerely yours,";
        body += "The Ebony Elves' TTB Application";

        Multipart multi = new MimeMultipart();
        try {
            new FormExporter(form);
            File file = new File(getClass().getResource("/" + "output.docx").toURI());
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(body);
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(file);
            System.out.println(fds.getFile().getAbsolutePath());
            DataSource src = fds;
            attachmentBodyPart.setDataHandler(new DataHandler(src));
            attachmentBodyPart.setFileName("TTB Application Form [FOR REVIEW ONLY].docx");

            multi.addBodyPart(textBodyPart);
            multi.addBodyPart(attachmentBodyPart);

            message.setContent(multi);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Sends a message to an agent when they have a form updated
     * @param to_inform the agent to be emailed
     * @param msg the message to send
     */
    public void sendAgentMail(Agent to_inform, String msg, Form form) {
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
            mailHelper(message, body, form);

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
            sendAgentMail(this.to_send_to, message, to_inform);
        } else {
            sendMail(this.to_inform);
        }
    }
}