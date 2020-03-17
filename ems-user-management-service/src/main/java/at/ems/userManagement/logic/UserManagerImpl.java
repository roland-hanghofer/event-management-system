package at.ems.userManagement.logic;

import at.ems.data.userManagement.UserRepository;
import at.ems.domain.userManagement.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return getUser(email);
    }

    @Transactional
    @Override
    public void saveUser(User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new IllegalArgumentException(String.format("This Email is already taken: %s", newUser.getEmail()));
        }
        userRepository.save(newUser);
    }

    @Override
    public void enableUser(String email) {
        enableOrDisableUser(email, true);
    }

    @Override
    public void disableUser(String email) {
        enableOrDisableUser(email, false);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        userRepository.delete(getUser(email).get());
    }

    @Override
    @Transactional
    public void changePassword(String email, String oldPassword, String newPassword) {
        Optional<User> user = getUser(email);
        if (!user.get().getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException(String.format("Old password for user %s does not match", email));
        }
        user.get().setPassword(newPassword);//todo encrypt
    }

    // *************************************************************

    private  Optional<User> getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new IllegalArgumentException(String.format("User with email %s does not exist", email));
        }
        return user;
    }

    private void enableOrDisableUser(String email, boolean enabled) {
        Optional<User> user = getUser(email);
        user.get().setEnabled(enabled);
    }
}
