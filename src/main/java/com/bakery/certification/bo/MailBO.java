package com.bakery.certification.bo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bakery.certification.domain.Mail;
import com.bakery.certification.mapper.MailMapper;

@Service
public class MailBO {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailMapper mailMapper;
	
	public static String getCertificationCode() {
		Random rand = new Random();
		String strRand = "";
		for (int i = 0; i < 8; i++) {
			strRand += rand.nextInt(10);
		}
		return strRand;
	}
	
	
	public Mail createMailAndChangePassword(String email, String str) {
        Mail mail = new Mail();
        mail.setAddress(email);
        mail.setTitle("[베이커리] 비밀번호 재설정 인증 코드 입니다.");
        mail.setMessage("안녕하세요. 베이커리 비밀번호 재설정 인증 코드 관련 이메일 입니다." + " 인증코드는 "
                + str + " 입니다.");
        
        return mail;
    }
	
	// MailDto를 바탕으로 실제 이메일 전송
    public void mailSend(Mail mail) {
        System.out.println("전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getAddress());
        message.setSubject(mail.getTitle());
        message.setText(mail.getMessage());
        message.setFrom("chaeykery@naver.com");
        message.setReplyTo("chaeykery@naver.com");
        System.out.println("message"+message);
        javaMailSender.send(message);
    }
    
    //인증코드 업데이트
    public void insertCertificationCode(String certificationCode, int userId){
    	mailMapper.insertCertificationCode(certificationCode, userId);
    	
    }
    
//    public  selectCertification(String code) {
//    	
//    }
}
