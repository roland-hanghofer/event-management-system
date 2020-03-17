package at.ems.userManagement.logic;

import at.ems.domain.userManagement.Role;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Optional;

public interface RoleManagement {
    Collection<Role> findAll();

    Optional<Role> getRoleByName(String name);

    Collection<Role> getRolesForUser(String email);

    void saveRole(Role role);

    void deleteRole(String name);
}
