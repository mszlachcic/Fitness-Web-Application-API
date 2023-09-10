package org.mszlachcic.api.route;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.address.Address;
import org.mszlachcic.api.checkpoint.Checkpoint;
import org.mszlachcic.api.user.User;
import org.mszlachcic.api.workout.Workout;
import org.mszlachcic.api.party.Party;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal distance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    private LocalDateTime date;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_routes",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<User> userList;
    @OneToMany(mappedBy = "route",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Checkpoint> checkpointList;
    @OneToMany(mappedBy = "route")
    private List<Workout> workouts;
    @OneToMany(mappedBy = "route")
    private List<Party> parties;
}

