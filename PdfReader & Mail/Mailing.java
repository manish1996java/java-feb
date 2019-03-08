package practice;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailing {

	public static void main(String[] args) {
	
		        //Setting up configurations for the email connection to the Google SMTP server using TLS
		        Properties props = new Properties();
		        props.put("mail.smtp.host", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");
		        //Establishing a session with required user details
		        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication("manishkumar.1996.pj@gmail.com", "your Password");
		            }
		        });
		        try {
		            //Creating a Message object to set the email content
		            MimeMessage msg = new MimeMessage(session);
		            //Storing the comma seperated values to email addresses
		            String to = "pp168210280@gmail.com";
		            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
		            addresses in an array of InternetAddress objects*/
		            InternetAddress[] address = InternetAddress.parse(to, true);
		           
		            //Setting the recepients from the address variable
		            msg.setRecipients(Message.RecipientType.TO, address);
		            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
		            msg.setSubject("Sample Mail : " + timeStamp);
		            msg.setSentDate(new Date());
		            msg.setText("hey sis wts up ..");
		            msg.setHeader("XPriority", "1");
		            
		            Multipart mailContent = new MimeMultipart();
		            
		            MimeBodyPart attachment = new  MimeBodyPart();
		            
		            //Create file object and pass the attachment path
		            File file = new File("D://Newpdf.pdf");
		            if(file.exists()) {
		            
		            	System.out.println("exists");
		            	
					attachment.attachFile(file);
					mailContent.addBodyPart(attachment);		            
		            
					msg.setContent(mailContent);
		            Transport.send(msg);
		            
		            System.out.println("done");
		            System.out.println("Mail has been sent successfully");
		            }
		        } catch (MessagingException mex) {
		            System.out.println("Unable to send an email" + mex);
		        } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		
		
		
		
		
		
		
		
//		String host = "smtp.gmail.com";
//		String userid = "manishkumar.1996.pj@gmail.com";
//		String password = "your password";
//			
//		
//		String from = userid;
//		String to = "vikrantbhadauriya2@gmail.com";
//		String subject = " no subject ";
//		String message = " hey bro wts up";
//		
//		InetAddress localhost;
//		try {
//			localhost = InetAddress.getLocalHost();
//		
//		System.out.println("local host : "+ localhost);
//		
//		Properties propt = new Properties();
//		propt.put("mail.smtp.host", host);
//		propt.put("mail.smtp.user", userid);
//		propt.put("mail.smtp.port", 587);
//		propt.put("mail.smtp.from", from);
//		propt.put("mail.smtp.auth", "true");
////		propt.put("mail.smtp.localhost",);
//		
//		
//		Session session = Session.getInstance(propt,null);
//		System.out.println("step 1 done");
//		
//		MimeMessage msg = new MimeMessage(session);
//		
////			msg.addHeader(name, value);
//			msg.setFrom(new InternetAddress(from));
//			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			msg.setSubject(subject);
//			msg.setText(message);
////			msg.setFileName();
//			msg.setSentDate(new Date());
//
//			System.out.println("step 2 done");	
//			
//			Transport transport = session.getTransport("smtp");
//			transport.connect(userid, password);
////			Transport.send(msg);
//			transport.sendMessage(msg, msg.getAllRecipients());
//			transport.close();
//			
//			System.out.println("step 3 done");
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//	}

}
}
