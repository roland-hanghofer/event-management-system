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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName = "";
    @Column(nullable = false)
    private String lastName = "";
    @Column(nullable = false, unique = true)
    private String email = "";
    private String password = "";

    private boolean enabled = true;
    private boolean tokenExpired = false;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new HashSet<>();

    //***************************************************

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email.toLowerCase();
        this.password = password;
    }

    //***************************************************

    public void addRole(Role role) {
        role.addUser(this);
    }

    public void removeRole(Role role) {
        role.removeUser(this);
    }
}
