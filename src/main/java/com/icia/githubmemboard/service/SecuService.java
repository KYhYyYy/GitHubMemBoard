package com.icia.githubmemboard.service;

import com.icia.githubmemboard.dao.SecuDAO;
import com.icia.githubmemboard.dto.SecuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
public class SecuService {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private SecuDAO dao;

    @Autowired
    private PasswordEncoder pwEnc;

    @Autowired
    private JavaMailSender mailSender;

    // 가입
    public ModelAndView secuJoin(SecuDTO secu) {
        // 아이디, 비밀번호, 이메일
        System.out.println("암호화 전 비밀번호 확인 : " + secu.getSecuPw());
        // [1] 우리가 입력한 패스워드
        // [2] 암호화
        // [3] 암호화된 패스워드를 SecuDTO에 다시 저장

        // 암호화 완성
        secu.setSecuPw(pwEnc.encode(secu.getSecuPw()));

        System.out.println("암호화 후 비밀번호 확인 : " + secu.getSecuPw());

        // int result는 가입여부 확인하기 위해
        dao.secuJoin(secu);

        mav.setViewName("index");

        return mav;
    }

    // 로그인
    public ModelAndView secuLogin(SecuDTO secu) {
        // [1] 입력한 아이디로 db에 저장된 비밀번호와 이메일 검색
        SecuDTO secu1 = dao.secuLogin(secu);

        // [2] 입력한 비밀번호와 db에 저장된 (암호화)비밀번호를 매칭
        // 1111 1234 <=> $2a$10$6.D.ayzhzUJTPNFyvSDyaeRhSp0Y0EJiTTQ6ZKDO/qApujYrnMszS

        // pwEnc.matches() 타입은 boolean => true or false
        if (pwEnc.matches(secu.getSecuPw(), secu1.getSecuPw())){
            System.out.println("비밀번호 일치!");
            mav.setViewName("index");

            // 이메일 발송

            // 임의의 문자 6자리 생성(보안코드)
            String uuid = UUID.randomUUID().toString().substring(1,7);

            // 보낼 메세지 생성(html형식)
            String str = "<h2>안녕하세요. 인천일보 아카데미 입니다.</h2>"
                    + "<p>로그인에 성공하셨습니다. 인증번호는 " + uuid + "입니다.</p>";

            MimeMessage mail = mailSender.createMimeMessage();

            try {
                // 메일 보내기 설정
                mail.setSubject("스프링부트 이메일 인증테스트"); // 메일 제목
                mail.setText(str,"UTF-8","html");  // 내용, 인코딩방식, 타입(형식)
                mail.addRecipient(Message.RecipientType.TO, new InternetAddress(secu1.getSecuEmail())); // 받는 사람

                // 메일 전송
                mailSender.send(mail);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("비밀번호 불일치!");
            mav.setViewName("index");
        }

        return mav;
    }
}
