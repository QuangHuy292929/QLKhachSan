package View;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;


public class EmailSender {
    public static void main(String[] args) {
        String host = "smtp.gmail.com";
        final String user = "nguyenquanghuy29085@gmail.com";
        final String password = "gbiw kvnu jbxy potq";

        String to = "quansang104@gmail.com";
        String subject = "HELLO";
        String body = "HELLO_2";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email đã được gửi thành công!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}