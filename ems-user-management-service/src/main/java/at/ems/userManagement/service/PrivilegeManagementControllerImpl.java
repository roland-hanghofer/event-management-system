package at.ems.userManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.userManagement.Privilege;
import at.ems.userManagement.logic.PrivilegeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PrivilegeManagementControllerImpl implements PrivilegeManagementController {
    @Autowired
    private PrivilegeManager privilegeManager;

    @Override
    public ResponseEntity<Collection<Privilege>> getPrivileges() {
        return RestUtils.request(() -> privilegeManager.findAll());
    }

    @Override
    public ResponseEntity<Collection<Privilege>> getPrivilegesForRole(String roleName) {
        return RestUtils.request((rn)-> privilegeManager.getPrivilegesForRole(rn), roleName);
    }

    @Override
    public ResponseEntity<?> addPrivilege(Privilege newPrivilege) {
        return RestUtils.voidRequest((np) -> privilegeManager.savePrivilege(np), newPrivilege);
    }

    @Override
    public ResponseEntity<?> deletePrivilege(String name) {
        return RestUtils.voidRequest((n) -> privilegeManager.deletePrivilege(n), name);
    }
}
