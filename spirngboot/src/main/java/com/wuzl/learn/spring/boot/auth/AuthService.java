package com.wuzl.learn.spring.boot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("test")) {
//			return null;
			//要抛出异常
			 throw new UsernameNotFoundException(username+"不存在");
		}
		if (username.equals("admin")) {
			User user = new User(username, passwordEncoder.encode(username),
					AuthorityUtils.createAuthorityList("admin", "user"));
			return user;
		} else {
			User user = new User(username, passwordEncoder.encode(username),
					AuthorityUtils.createAuthorityList("user"));
			return user;
		}

	}

}
