package com.soobineey.demo.dao;

import com.soobineey.demo.dto.MainDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainDao {

  // 회원가입
  public int insertMember(MainDto dto);

  // 로그인
  public MainDto selectMember(MainDto dto);

  // 이메일 인증코드
  public int insertAuthCode(MainDto dto);
  
  // 인증코드 가져오기
  public List<MainDto> selectAuthCode(MainDto dto);
}
