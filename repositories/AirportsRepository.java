package com.airport.repositories;

import com.airport.entities.Airports;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.airport.entities.IReportTop;

public interface AirportsRepository extends JpaRepository<Airports, Integer> {

    List<Airports> findAirportsByIsoCountry(String isoCountry);

    @Query("SELECT a.isoCountry as key, COUNT(a.isoCountry) as amount FROM Airports as a GROUP BY a.isoCountry ORDER BY amount DESC")
    public List<IReportTop> getReportTopAirport();
}
