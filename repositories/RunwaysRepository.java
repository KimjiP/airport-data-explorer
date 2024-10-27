package com.airport.repositories;

import com.airport.entities.Runways;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.airport.entities.IReportTop;

public interface RunwaysRepository extends JpaRepository<Runways, Integer> {

    List<Runways> findByAirportRef(Integer airportRef);
    
        
    @Query("SELECT a.le_ident as key,COUNT(a.le_ident) as amount FROM Runways as a GROUP BY a.le_ident ORDER BY amount DESC")
    public List<IReportTop> getReportTopRunways();
}
