package com.chins.mall.backend.business.security.service;

import com.chins.mall.backend.provider.user.mgr.api.PermissionMgrApi;
import com.chins.mall.backend.provider.user.mgr.api.UserMgrApi;
import com.chins.mall.backend.provider.user.mgr.domain.Permission;
import com.chins.mall.backend.provider.user.mgr.domain.User;
import java.util.List;
import org.apache.dubbo.config.annotation.Reference;
import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Reference(version = "1.0.0")
  private UserMgrApi userMgrApi;

  @Reference(version = "1.0.0")
  private PermissionMgrApi permissionMgrApi;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    User userByName = userMgrApi.selectOne(s);

    if (null == userByName) {
      return null;
    }

    List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
    List<Permission> permissions = permissionMgrApi.selectListByUserId(userByName.getId());
    permissions.forEach(permission -> {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
      grantedAuthorities.add(grantedAuthority);
    });

    return new org.springframework.security.core.userdetails.User(userByName.getUsername(),
        userByName.getPassword(), grantedAuthorities);
  }
}
