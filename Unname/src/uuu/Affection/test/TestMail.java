package uuu.Affection.test;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

public class TestMail {
    public static void main(String[] args) {
        //以下為寄件所需的SMTP伺服器與帳號設定，這裡使用gmail的SMTP Server
        String host = "smtp.gmail.com";
        int port = 587;
        final String username = "lixiaochen5438@gmail.com";
        final String password = "@Aa65438";//your password

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        
        try {
            //以下建立message物件作為mail的內容
            Message message = new MimeMessage(session);
            InternetAddress from;
            try {
                from = new InternetAddress(username, "Affection-會員通知", "utf-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TestMail.class.getName()).log(Level.SEVERE, null, ex);
                from = new InternetAddress(username);
            }
            message.setFrom(from);//虛擬寄件人            
            String receiverEmail = "lixiaochen5438@gmail.com";//收件人地址，請改成你的email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail)); 
            message.setSubject("測試寄信.");
            message.setText("Dear Li: \n\nAffection-會員通知。\n這是一個email測試，\n不須回覆信件!");

            Transport transport = session.getTransport("smtp");
            //Transport transport = getMailSession.getTransport("smtp");
            transport.connect(host, port, username, password);
            Transport.send(message);
            System.out.println("寄送email結束.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
