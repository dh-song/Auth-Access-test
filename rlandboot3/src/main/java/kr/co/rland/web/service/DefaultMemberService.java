package kr.co.rland.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService {
	
	@Autowired
	private MemberRepository repository;
	
	@Override
	public Member getByUserName(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValidMember(String uid, String pwd) {
		Member member = repository.finByUserName(uid);
		
		if (member == null) {
			System.out.println("null");
			return false;
		} else if (! member.getPwd().equals(pwd)) {
			System.out.println("not equals");
			return false;
		}
		

		
		return true;
	}

}
