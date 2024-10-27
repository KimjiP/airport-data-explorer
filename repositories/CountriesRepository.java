package com.airport.repositories;

import com.airport.entities.Countries;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.airport.entities.IReportTop;

public interface CountriesRepository extends JpaRepository<Countries, Integer> {

    Countries findCountriesByCode(String isoCountry);    
    
    @Query("SELECT a.isoCountry as isoCountry, COUNT(a.isoCountry) as amount FROM Airports as a GROUP BY a.isoCountry ORDER BY amount DESC")
    public List<IReportTop> getReportTopAirport();
}
