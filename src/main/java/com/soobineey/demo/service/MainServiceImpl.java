package com.soobineey.demo.service;

import com.soobineey.demo.dao.MainDao;
import com.soobineey.demo.dto.MainDto;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@RequiredArgsConstructor
@Component
public class MainServiceImpl implements MainService {

  @NotNull
  MainDao dao;

  @Override
  public int insertMember(MainDto dto) {
    System.out.println("Pass insertMember in MainServiceImpl");
    return dao.insertMember(dto);
  }

  @Override
  public MainDto selectMember(MainDto dto) {
    System.out.println("Pass selectMember in MainServiceImpl");

    return dao.selectMember(dto);
  }

//  @Override
//  public boolean verifyRecaptcha(String response) {
//
//    final String SECRET_KEY = "6LcTUa4ZAAAAAEOs4hOYluQfjoeDnIFGlbEfl0LM";
//    final String RE_URL = "";
//
//    URL obj = new URL(R)
//    return false;
//  }
}
