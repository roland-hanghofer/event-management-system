package at.ems.userManagement.logic;

import at.ems.domain.userManagement.User;

import java.util.Collection;
import java.util.Optional;

public interface UserManagement {
    Collection<User> getUsers();

    Optional<User> getUserByEmail(String email);

    void saveUser(User newUser);

    void enableUser(String email);

    void disableUser(String email);

    void deleteUser(String email);

    void changePassword(String email, String oldPassword, String newPassword);
}
