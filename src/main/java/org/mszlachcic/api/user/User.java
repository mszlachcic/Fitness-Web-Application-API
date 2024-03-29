package org.mszlachcic.api.user;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.goal.Goal;
import org.mszlachcic.api.role.Role;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Getter
@Setter
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @NotBlank
    @Size(max = 20)
    private String lastName;
    private LocalDateTime dateOfBirth;
    @NotBlank
    @Size(max = 20)
    private String countryOfOrigin;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Goal> goalList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String firstName, String lastName, LocalDateTime dateOfBirth, String countryOfOrigin, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.countryOfOrigin = countryOfOrigin;
        this.email = email;
        this.password = password;
    }

    public User() {

    }
}
