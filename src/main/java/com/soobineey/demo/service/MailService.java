package com.soobineey.demo.service;

import com.soobineey.demo.dto.MainDto;

import java.util.List;

public interface MailService {

  // 이메일
  public boolean send(String subject, String text, String from, String to);

  // 이메일 인증코드 저장
  public int insertAuthCode(MainDto dto);
  
  // 인증코드 불러오기
  public List<MainDto> selectAuthCode(MainDto dto);
}


