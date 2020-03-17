package at.ems.userManagement.logic;

import at.ems.data.userManagement.PrivilegeRepository;
import at.ems.domain.userManagement.Privilege;
import at.ems.domain.userManagement.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PrivilegeManagerImpl implements PrivilegeManager {
    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleManager roleManager;

    @Override
    public Collection<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    @Override
    public void savePrivilege(Privilege privilege) {
        privilegeRepository.save(privilege);
    }

    @Override
    @Transactional
    public Collection<Privilege> getPrivilegesForRoles(Collection<Role> roles) {
        return  privilegeRepository.findAll()
                .stream()
                .filter(p -> containsRole(p.getRoles(), roles))
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Collection<Privilege> getPrivilegesForRole(String roleName) {
        return roleManager.getRoleByName(roleName).get().getPrivileges();
    }

    @Override
    @Transactional
    public void deletePrivilege(String n) {
        Optional<Privilege> privilege = privilegeRepository.findByName(n);
        if (privilege.isPresent()) {
            privilegeRepository.delete(privilege.get());
        }
    }

    private boolean containsRole(Collection<Role> r1, Collection<Role> r2) {
        return r1.stream()
                .anyMatch(r -> r2.contains(r));
    }
}
