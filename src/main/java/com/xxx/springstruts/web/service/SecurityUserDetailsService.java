package com.xxx.springstruts.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.xxx.springstruts.web.entity.User;

public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		return new org.springframework.security.core.userdetails.User(username, 
				user.getPassword(), 
				user.getStatus()==1, 
				true, 
				true, 
				true, 
				getGrantedAuthorities(user));
	}
	
	public List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> list = new ArrayList<>();
		System.out.println("user->role"+user.getRole().getName());
		list.add(new SimpleGrantedAuthority(user.getRole().getName()));
		return list;
	}

}
