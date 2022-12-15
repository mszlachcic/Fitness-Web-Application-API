package org.mszlachcic.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime postDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Route route;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "party_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id"))
    private List<User> users;
}
