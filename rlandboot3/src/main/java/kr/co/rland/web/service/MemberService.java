package kr.co.rland.web.service;

import kr.co.rland.web.entity.Member;

public interface MemberService {

	Member getByUserName(String uid);

	Boolean isValidMember(String uid, String pwd);

}
