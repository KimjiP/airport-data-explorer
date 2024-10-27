package com.airport.entities;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@ToString
public class Countries implements Serializable {

    @Id
    private Integer id;

    @Column(unique = true)
    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;
//    @OneToMany(mappedBy = "countries", orphanRemoval = true, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    private List<Airports> airportses;

//    @Override
//    public String toString() {
//        return "Countries{" + "id=" + id + ", code=" + code + ", name=" + name + ", continent=" + continent + ", wikipedia_link=" + wikipedia_link + ", keywords=" + keywords + ", airportses=" + airportses.stream().map((t) -> {
//            return t.getId();
//        }).collect(Collectors.toList()) + '}';
//    }

}
