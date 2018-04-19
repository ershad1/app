package com.app.auth.security.auth;

import com.app.auth.entity.Privilege;
import com.app.auth.entity.Role;
import com.app.auth.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                getAuthoritiess(user.getRole())
        );
    }

    private static Collection<? extends GrantedAuthority> getAuthoritiess(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getLabel()));
//        role.getPrivileges().stream()
//                .map(p -> new SimpleGrantedAuthority(p.getLabel()))
//                .forEach(authorities::add);

        Collection<Privilege> privileges = role.getPrivileges();
        for (Privilege privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getLabel()));
        }

        return authorities;
    }

}
