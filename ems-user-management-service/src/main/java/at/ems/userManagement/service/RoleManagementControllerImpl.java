package at.ems.userManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.userManagement.Role;
import at.ems.userManagement.logic.RoleManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RoleManagementControllerImpl implements RoleManagementController {
    @Autowired
    private RoleManagement roleManagement;

    @Override
    public ResponseEntity<Collection<Role>> getRoles() {
        return RestUtils.request(() -> roleManagement.findAll());
    }

    @Override
    public ResponseEntity<Role> getRoleByName(String name) {
        return RestUtils.request((n) -> roleManagement.getRoleByName(n).get(), name);
    }

    @Override
    public ResponseEntity<Collection<Role>> getRolesForUser(String email) {
        return RestUtils.request((e) -> roleManagement.getRolesForUser(e), email);
    }

    @Override
    public ResponseEntity<?> addRole(Role newRole) {
        return RestUtils.voidRequest((r) -> roleManagement.saveRole(r), newRole);
    }

    @Override
    public ResponseEntity<?> deleteRole(String name) {
        return RestUtils.voidRequest((n)-> roleManagement.deleteRole(n), name);
    }
}
