package com.demo.oauth2.config.auth;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author Tiger
 * @date 2019-12-17
 * @see com.demo.oauth2.config.auth
 **/
@Order
@Component("permission")
public class PermissionCheck {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        boolean hasPermission = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (antPathMatcher.match(authority.getAuthority(), request.getRequestURI())) {
                hasPermission = true;
                break;
            }
        }
        return hasPermission;
    }
}
