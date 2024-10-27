package com.airport.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class Airports implements Serializable {

    @Id
    private Integer id;
    private String ident;
    private String type;
    private String name;
    private Double latitude_deg;
    private Double longitude_deg;
    private Integer elevation_ft;
    private String continent;
    private String isoCountry;
    private String iso_region;
    private String municipality;
    private String scheduled_service;
    private String gps_code;
    private String iata_code;
    private String local_code;
    private String home_link;
    private String wikipedia_link;
    private String keywords;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    @JoinColumn(name = "iso_country", referencedColumnName = "code")
//    private Countries countries;

//    @Override
//    public String toString() {
//        return "Airports{" + "id=" + id + ", ident=" + ident + ", type=" + type + ", name=" + name + ", latitude_deg=" + latitude_deg + ", longitude_deg=" + longitude_deg + ", elevation_ft=" + elevation_ft + ", continent=" + continent + ", iso_region=" + iso_region + ", municipality=" + municipality + ", scheduled_service=" + scheduled_service + ", gps_code=" + gps_code + ", iata_code=" + iata_code + ", local_code=" + local_code + ", home_link=" + home_link + ", wikipedia_link=" + wikipedia_link + ", keywords=" + keywords + ", countries=" + countries + '}';
//    }

}
