package at.ems.domain.userManagement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges = new HashSet<>();

    //***************************************************

    public Role(String name) {
        this.name = name;
    }

    //***************************************************

    public void addUser(User user) {
        user.getRoles().add(this);
        users.add(user);
    }

    public void removeUser(User user) {
        user.getRoles().remove(this);
        users.remove(user);
    }

    public void addPrivilege(Privilege privilege) {
        privilege.getRoles().add(this);
        privileges.add(privilege);
    }

    public void removePrivilege(Privilege privilege) {
        privilege.getRoles().remove(this);
        privileges.remove(privilege);
    }
}
