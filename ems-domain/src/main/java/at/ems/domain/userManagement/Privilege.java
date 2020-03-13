package at.ems.domain.userManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "roles")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles = new HashSet<>();

    //***************************************************

    public Privilege(String name) {
        this.name = name;
    }

    //***************************************************

    public void addRole(Role role) {
        role.addPrivilege(this);
    }

    public void removeRole(Role role) {
        role.removePrivilege(this);
    }
}
