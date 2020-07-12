package com.soobineey.demo.controller;

import com.soobineey.demo.dto.MainDto;
import com.soobineey.demo.service.MailService;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@Component
public class MailController {

  @NotNull
  MailService mailService;

  // 인증코드 생성
  @RequestMapping(value = "/email", method = RequestMethod.GET)
  public ResponseEntity<String> randomNum(MainDto dto, @RequestParam String userEmail) {
    int randomAuthCode = new Random().nextInt(900000) + 100000;

    String authCode = String.valueOf(randomAuthCode);

    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String authCodeTime = format.format(date);

    dto.setMemberEmail(userEmail);
    dto.setAuthCode(authCode);
    dto.setCodeRegTime(authCodeTime);

    mailService.insertAuthCode(dto);

    return new ResponseEntity<String>(authCode, HttpStatus.OK);
  }
  // 인증코드 발송
  @RequestMapping(value = "/createEmailCheck", method = RequestMethod.GET)
  @ResponseBody
  public boolean createEmailCheck(@RequestParam String userEmail, @RequestParam int random, HttpServletRequest request) {

    // 이메일 인증코드 발송
//    HttpSession session = request.getSession(true);
    String authCode = String.valueOf(random);
//    session.setAttribute("authCode", authCode);
//    session.setAttribute("random", random);
    String subject = "인증코드 발송 메일";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("귀하의 인증 코드는" + authCode + "입니다.");

    return mailService.send(subject, stringBuilder.toString(), "soobineey@gmail.com", userEmail);
  }
  // 인증코드 확인
  @RequestMapping(value = "/emailAuth", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<String> emailAuth(@RequestParam String authCode, @RequestParam String email, MainDto dto) throws ParseException {

    boolean timeLimit = false;
    dto.setMemberEmail(email);

    mailService.selectAuthCode(dto);
    long ckTime = System.currentTimeMillis();

    System.out.print("Main? DTO : ");
    System.out.println(System.identityHashCode(dto));
    System.out.println("인증버튼 클릭");
    System.out.println(ckTime);
    System.out.println("인증코드 : " + dto.getAuthCode());
    System.out.println("인증코드 등록 시간 : " + dto.getCodeRegTime());
//    Date codeRegTimeFromDB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dto.getCodeRegTime());
//
//    long changCodeRegTimeFromDB = codeRegTimeFromDB.getTime();

//    timeLimit = ckTime - changCodeRegTimeFromDB <= 60000 ? false : true;

//    if (authCode.equals(dto.getAuthCode()) && timeLimit) {
    if (authCode.equals(dto.getAuthCode())) {
      return new ResponseEntity<String>("complete", HttpStatus.OK);
    } else {
      System.out.println("응 인증 실패~");
      return new ResponseEntity<String>("false", HttpStatus.OK);
    }
  }
}