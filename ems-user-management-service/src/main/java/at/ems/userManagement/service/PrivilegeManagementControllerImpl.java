package at.ems.userManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.userManagement.Privilege;
import at.ems.userManagement.logic.PrivilegeManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PrivilegeManagementControllerImpl implements PrivilegeManagementController {
    @Autowired
    private PrivilegeManagement privilegeManagement;

    @Override
    public ResponseEntity<Collection<Privilege>> getPrivileges() {
        return RestUtils.request(() -> privilegeManagement.findAll());
    }

    @Override
    public ResponseEntity<Collection<Privilege>> getPrivilegesForRole(String roleName) {
        return RestUtils.request((rn)-> privilegeManagement.getPrivilegesForRole(rn), roleName);
    }

    @Override
    public ResponseEntity<?> addPrivilege(Privilege newPrivilege) {
        return RestUtils.voidRequest((np) -> privilegeManagement.savePrivilege(np), newPrivilege);
    }

    @Override
    public ResponseEntity<?> deletePrivilege(String name) {
        return RestUtils.voidRequest((n) -> privilegeManagement.deletePrivilege(n), name);
    }
}
