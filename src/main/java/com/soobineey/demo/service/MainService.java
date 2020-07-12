package com.soobineey.demo.service;

import com.soobineey.demo.dto.MainDto;

import java.util.List;

public interface MainService {

  public int insertMember(MainDto dto);

  public MainDto selectMember(MainDto dto);



}
