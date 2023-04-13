package kr.co.rland.web.config;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class RlandUserDetails implements UserDetails{
	
	private Long id;
	private String email;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	public RlandUserDetails() {
		super();
	}


	public RlandUserDetails(Long id, String email, String username, String password,
			List<GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	
	}
	
	
	@Override
	public String toString() {
		return "RlandUserDetails [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", authorities=" + authorities + "]";
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
