package at.ems.app;

import at.ems.domain.userManagement.Privilege;
import at.ems.domain.userManagement.Role;
import at.ems.domain.userManagement.User;
import at.ems.userManagement.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitUserData implements CommandLineRunner {
    @Autowired
    UserManagement userManagement;

    @Autowired
    RoleManagement roleManagement;

    @Autowired
    PrivilegeManagement privilegeManagement;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        User[] users = {
                new User("admin", "admin", "admin@ems.at", passwordEncoder.encode("123")),
                new User("user","user","user@ems.at", passwordEncoder.encode("123"))
        };

        Role[] roles = {
                new Role("ADMIN"),
                new Role("USER")
        };

        Privilege[] privileges = {
                new Privilege("ADMIN"),
                new Privilege("EDIT"),
                new Privilege("VIEW")
        };

        users[0].addRole(roles[0]);
        users[0].addRole(roles[1]);
        users[1].addRole(roles[1]);

        roles[0].addPrivilege(privileges[0]);
        roles[0].addPrivilege(privileges[1]);
        roles[0].addPrivilege(privileges[2]);
        roles[1].addPrivilege(privileges[2]);

        for (Role role : roles) {
            roleManagement.saveRole(role);
        }

        for (Privilege privilege : privileges) {
            privilegeManagement.savePrivilege(privilege);
        }

        for (User user : users) {
            userManagement.saveUser(user);
        }
    }
}
