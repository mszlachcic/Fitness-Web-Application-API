package org.mszlachcic.api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Country {

    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<City> cityList;
}
