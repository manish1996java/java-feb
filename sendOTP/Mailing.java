package com.bmpl.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Mailing {
	
	public static boolean sendMail(String email,String otp) {
		
      
       
	   boolean isSent = false;
	   String pass;
       Scanner scan = new Scanner(System.in);
		
       System.out.println("Enter your password");
       pass = scan.nextLine();
		
		Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("manishkumar.1996.pj@gmail.com", pass);
            }
        });
        try {
        	
            MimeMessage msg = new MimeMessage(session);
            
           
            String to = email;
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
           
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject("Sample Mail : " + timeStamp);
            msg.setSentDate(new Date());
            msg.setText("Your OTP is:"+otp);
            msg.setHeader("XPriority", "1");
            
//            Multipart mailContent = new MimeMultipart();
//            
//            MimeBodyPart attachment = new  MimeBodyPart();
//            
//            //Create file object and pass the attachment path
//            File file = new File("D://Newpdf.pdf");
//            if(file.exists()) {
//            
//            	System.out.println("exists");
//			attachment.attachFile(file);
//			
//			
//			mailContent.addBodyPart(attachment);		            
//            
//			msg.setContent(mailContent);
            Transport.send(msg);
            
            System.out.println("done");
            System.out.println("Mail has been sent successfully");
            return isSent=true;
            
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
		return isSent;	

}
}

