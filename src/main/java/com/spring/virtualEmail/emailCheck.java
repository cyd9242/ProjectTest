package com.spring.virtualEmail;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class emailCheck {
	Thread thread = new Thread();
	@SuppressWarnings("static-access")
	public void sendEmail(String vEmail, String authNum) {
		String host = "smtp.gmail.com"; // smtp 서버
		String subject = "가상홈페이지에 요청하신 인증번호를 알려드립니다.";
		String fromName = "가상홈페이지 관리자";
		String from = "yongdeuk4098@gmail.com"; // 보내는 메일
		String to = vEmail;
		String content = "요청하신 인증번호를<br/>발송해드립니다.<br/><br/> 아래의 인증번호를 인증번호 입력창에 입력해 주세요.<br/><br/>인증번호 [" + authNum + "]<br/><br/>가상홈페이지를 이용해 주셔서 감사합니다.<br/>더욱 편리한 서비스를 제공하기 위해 항상 최선을 다하겠습니다.";
		System.out.println("to : " + to);
		try {
			Properties props = new Properties();
			// Gmail SMTP 사용시
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port","465"); // 587 //465
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getInstance(props, 
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("yongdeuk4098@gmail.com", "wkwjs@4098");
						}
			});
			
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 보내는 사람 설정
			
			InternetAddress[] address = { new InternetAddress(to) };
			message.setRecipients(Message.RecipientType.TO, address); // 받는 사람설정
			message.setSubject(subject);
			message.setSentDate(new java.util.Date()); // 보내는 날짜 설정
			message.setContent(content, "text/html;charset=utf-8");
			Transport.send(message);
			
		} catch(MessagingException me) {
			me.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String RandoNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<= 6; i++) {
			int n = (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
}
