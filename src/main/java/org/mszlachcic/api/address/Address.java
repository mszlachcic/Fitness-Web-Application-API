package org.mszlachcic.api.address;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.route.Route;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @OneToMany(mappedBy = "address")
    private List<Route> routes;
}
