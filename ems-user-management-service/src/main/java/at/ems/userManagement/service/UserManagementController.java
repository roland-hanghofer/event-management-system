package at.ems.userManagement.service;

import at.ems.domain.userManagement.User;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/users")
public interface UserManagementController {
    @GetMapping
    ResponseEntity<Collection<User>> getUsers();

    @GetMapping("/{email}")
    ResponseEntity<User> getUserByEmail(@PathVariable("email") String email);

    @PostMapping("/add")
    ResponseEntity<?> addUser(@RequestBody User newUser);

    @GetMapping("/enable/{email}")
    ResponseEntity<?> enableUser(@PathVariable("email") String email);

    @GetMapping("/disable/{email}")
    ResponseEntity<?> disableUser(@PathVariable("email") String email);

    @GetMapping("/delete/{email}")
    ResponseEntity<?> deleteUser(@PathVariable("email") String email);

    @PostMapping("/{email}/changePassword")
    ResponseEntity<?> changePassword(@RequestBody String email, @RequestBody String oldPassword, @RequestBody String newPassword);

}
