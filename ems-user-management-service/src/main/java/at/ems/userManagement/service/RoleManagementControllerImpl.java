package at.ems.userManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.userManagement.Role;
import at.ems.userManagement.logic.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RoleManagementControllerImpl implements RoleManagementController {
    @Autowired
    private RoleManager roleManager;

    @Override
    public ResponseEntity<Collection<Role>> getRoles() {
        return RestUtils.request(() -> roleManager.findAll());
    }

    @Override
    public ResponseEntity<Role> getRoleByName(String name) {
        return RestUtils.request((n) -> roleManager.getRoleByName(n).get(), name);
    }

    @Override
    public ResponseEntity<Collection<Role>> getRolesForUser(String email) {
        return RestUtils.request((e) -> roleManager.getRolesForUser(e), email);
    }

    @Override
    public ResponseEntity<?> addRole(Role newRole) {
        return RestUtils.voidRequest((r) -> roleManager.saveRole(r), newRole);
    }

    @Override
    public ResponseEntity<?> deleteRole(String name) {
        return RestUtils.voidRequest((n)-> roleManager.deleteRole(n), name);
    }
}
