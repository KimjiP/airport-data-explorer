package com.airport.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Runways implements Serializable {

    @Id
    private Integer id;
    private Integer airportRef;
    private String airport_ident;
    private Integer length_ft;
    private Integer width_ft;
    private String surface;
    private Boolean lighted;
    private Boolean closed;
    private String le_ident;
    private Double le_latitude_deg;
    private Double le_longitude_deg;
    private Integer le_elevation_ft;
    private Double le_heading_degt;
    private String le_displaced_threshold_ft;
    private String he_ident;
    private String he_latitude_deg;
    private String he_longitude_deg;
    private String he_elevation_ft;
    private String he_heading_degT;
    private String he_displaced_threshold_ft;

}
