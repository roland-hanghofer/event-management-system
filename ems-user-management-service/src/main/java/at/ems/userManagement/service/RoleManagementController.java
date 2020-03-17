package at.ems.userManagement.service;

import at.ems.domain.userManagement.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/roles")
public interface RoleManagementController {
    @GetMapping()
    ResponseEntity<Collection<Role>> getRoles();

    @GetMapping("/{name}")
    ResponseEntity<Role> getRoleByName(@PathVariable("name") String name);

    @GetMapping("/forUser/{email}")
    ResponseEntity<Collection<Role>> getRolesForUser(@PathVariable("email") String email);

    @PostMapping("/add")
    ResponseEntity<?> addRole(@RequestBody Role newRole);

    @GetMapping("/delete/{name}")
    ResponseEntity<?> deleteRole(@PathVariable("name") String name);
}
