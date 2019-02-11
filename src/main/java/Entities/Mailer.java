package Entities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mailer {

    public Mailer(){

    }

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

            String body = "Hello " + to_inform.getMailingAddress().getName();
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
}