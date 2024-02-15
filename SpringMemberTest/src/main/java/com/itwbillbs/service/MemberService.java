package com.itwbillbs.service;

import java.util.List;

import com.itwbillbs.domain.MemberVO;

public interface MemberService {
	
	// 시간정보 조회
	public String getTime();
	// 회원정보 가입
	public void memberJoin(MemberVO vo);
	// 로그인 처리
	public MemberVO memberLogin(MemberVO vo);
	// 회원정보 조회
	public MemberVO memberInfo(String id);
	// 회원정보 수정
	public int memberUpdate(MemberVO vo);
	// 회원정보 삭제
	public int memberDelete(MemberVO vo);
	// 회원정보 리스트
	public List<MemberVO> memberList();
	
	
	
	
}
