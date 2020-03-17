package at.ems.userManagement.logic;

import at.ems.domain.userManagement.Privilege;
import at.ems.domain.userManagement.Role;

import java.util.Collection;

public interface PrivilegeManager {
    Collection<Privilege> findAll();

    void savePrivilege(Privilege privilege);

    Collection<Privilege> getPrivilegesForRoles(Collection<Role> roles);

    Collection<Privilege> getPrivilegesForRole(String roleName);

    void deletePrivilege(String n);
}
