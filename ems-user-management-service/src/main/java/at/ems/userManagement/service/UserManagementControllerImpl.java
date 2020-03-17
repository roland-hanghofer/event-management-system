package at.ems.userManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.userManagement.User;
import at.ems.userManagement.logic.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@Slf4j
@RestController
public class UserManagementControllerImpl implements UserManagementController {
    @Autowired
    private UserManager userManager;

    @Override
    public ResponseEntity<Collection<User>> getUsers() {
        return RestUtils.request(() -> userManager.getUsers());
    }

    @Override
    public ResponseEntity<User> getUserByEmail(String email) {
        return RestUtils.request((e) -> userManager.getUserByEmail(e).get(), email);
    }

    @Override
    public ResponseEntity<?> addUser(User newUser) {
        return RestUtils.voidRequest((u)-> userManager.saveUser(u), newUser);
    }

    @Override
    public ResponseEntity<?> enableUser(String email) {
        return RestUtils.voidRequest((e) -> userManager.enableUser(e), email);
    }

    @Override
    public ResponseEntity<?> disableUser(String email) {
        return RestUtils.voidRequest((e) -> userManager.disableUser(e), email);
    }

    @Override
    public ResponseEntity<?> deleteUser(String email) {
        return RestUtils.voidRequest((e) -> userManager.deleteUser(e), email);
    }

    @Override
    public ResponseEntity<?> changePassword(String email, String oldPassword, String newPassword) {
        return RestUtils.voidRequest((e, oldPwd, newPwd) -> userManager.changePassword(e, oldPwd, newPwd), email, oldPassword, newPassword);
    }

// *************************************************************
}
