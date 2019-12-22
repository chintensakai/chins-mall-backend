package com.chins.mall.backend.security.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final String USERNAME = "admin";
  private static final String PASSWORD = "$2a$10$Ji7b2tJSmKClopQdsj0gL.T3fc1fxN4g7h1RG3PJsjMoonAF198QS";

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
    return new User(USERNAME, PASSWORD, grantedAuthorityList);
  }
}