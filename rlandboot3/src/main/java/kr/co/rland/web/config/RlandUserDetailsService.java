package kr.co.rland.web.config;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.repository.MemberRepository;
@Service
public class RlandUserDetailsService implements UserDetailsService {
	
		@Autowired
		private MemberRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = repository.finByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		RlandUserDetails user = new RlandUserDetails();
		user.setId(member.getId());
		user.setPassword(member.getPwd());
		user.setEmail(member.getEmail());
		user.setUsername(member.getUserName());
		user.setAuthorities(authorities);
		return user;
	}

}
