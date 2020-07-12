package com.soobineey.demo.dto;

import lombok.Data;

@Data
public class MainDto {

  private String memberId;
  private String memberPw;
  private String memberEmail;
  private String memberJoinDate;
  private String authCode;
  private String codeRegTime;


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberPw() {
    return memberPw;
  }

  public void setMemberPw(String memberPw) {
    this.memberPw = memberPw;
  }

  public String getMemberEmail() {
    return memberEmail;
  }

  public void setMemberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
  }

  public String getMemberJoinDate() {
    return memberJoinDate;
  }

  public void setMemberJoinDate(String memberJoinDate) {
    this.memberJoinDate = memberJoinDate;
  }

  public String getAuthCode() {
    System.out.println("selectAuthCode get dto");
    System.out.println("getAuthCode" + System.identityHashCode(this));
    return authCode;
  }

  public void setAuthCode(String authCode) {
    System.out.println("selectAuthCode set dto");
    System.out.println("setAuthCode" + System.identityHashCode(this));
    this.authCode = authCode;
  }

  public String getCodeRegTime() {
    System.out.println("selectCodeRegTime get dto");
    System.out.println(System.identityHashCode(this));
    return codeRegTime;
  }

  public void setCodeRegTime(String codeRegTime) {
    System.out.println("selectCodeRegTime set dto");
    System.out.println(System.identityHashCode(this));
    this.codeRegTime = codeRegTime;
  }
}
