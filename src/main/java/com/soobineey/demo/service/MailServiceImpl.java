package com.soobineey.demo.service;

import com.soobineey.demo.dao.MainDao;
import com.soobineey.demo.dto.MainDto;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Component
public class MailServiceImpl implements MailService {

  @NotNull
  JavaMailSender javaMailSender;

  public void setJavaMailSender(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @NotNull
  MainDao dao;

  @Override
  public boolean send(String subject, String text, String from, String to) {

    MimeMessage message = javaMailSender.createMimeMessage();

    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
      helper.setSubject(subject);
      helper.setText(text, true);
      helper.setFrom(from);
      helper.setTo(to);

      javaMailSender.send(message);
      return true;
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public int insertAuthCode(MainDto dto) {
    System.out.println("Pass insertAuthCode in MailServiceImpl");
    System.out.println(dto.getAuthCode());
    return dao.insertAuthCode(dto);
  }

  @Override
  public MainDto selectAuthCode(MainDto dto) {
    System.out.println("Pass selectAuthCode in MailServiceImpl");
    System.out.println("XUXUXXKAKAKSAKDJASKDJAKS");
    System.out.println(dto.getMemberEmail());
    System.out.println(dto.getCodeRegTime());

    return dao.selectAuthCode(dto);
  }
}
