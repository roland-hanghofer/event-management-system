package at.ems.userManagement.logic;

import at.ems.data.userManagement.RoleRepository;
import at.ems.data.userManagement.UserRepository;
import at.ems.domain.userManagement.Role;
import at.ems.domain.userManagement.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class RoleManagementImpl implements RoleManagement{
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Collection<Role> getRolesForUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getRoles();
        }
        return new ArrayList<>();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(String name) {
        roleRepository.delete(getRole(name).get());
    }

    // *************************************************************

    private  Optional<Role> getRole(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (!role.isPresent()) {
            throw new IllegalArgumentException(String.format("Role with name %s does not exist", role));
        }
        return role;
    }
}
