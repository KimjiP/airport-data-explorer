package com.airport.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReportTopAirport {

    private Countries countries;
    private Integer amount;
}
