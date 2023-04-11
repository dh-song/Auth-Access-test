package kr.co.rland.web.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private Long id;
	private String userName;
	private String pwd;
	private String email;
	private String roleId;
	
}
