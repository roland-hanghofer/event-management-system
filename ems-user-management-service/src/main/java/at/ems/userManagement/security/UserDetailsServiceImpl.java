package at.ems.userManagement.security;

import at.ems.domain.userManagement.Role;
import at.ems.userManagement.logic.PrivilegeManager;
import at.ems.userManagement.logic.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PrivilegeManager privilegeManager;

    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<at.ems.domain.userManagement.User> user = userManager.getUserByEmail(email);

        if (!user.isPresent()) {
            return null;
        }

        return new User(
                user.get().getEmail(),
                user.get().getPassword(),
                user.get().isEnabled(),
                true, true,
                true,
                Collections.emptyList()
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        return privilegeManager.getPrivilegesForRoles(roles).stream()
                .map(privilege -> privilege.getName())
                .collect(Collectors.toList());
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        return privileges
                .stream()
                .map(privilege -> new SimpleGrantedAuthority((privilege)))
                .collect(Collectors.toList());
    }
}
