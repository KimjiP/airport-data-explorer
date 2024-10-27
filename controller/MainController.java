package com.airport.controller;

import com.airport.entities.Airports;
import com.airport.entities.Countries;
import com.airport.entities.Runways;
import com.airport.repositories.AirportsRepository;
import com.airport.repositories.CountriesRepository;
import com.airport.repositories.RunwaysRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.airport.entities.ReportTopAirport;
import java.util.ArrayList;
import com.airport.entities.IReportTop;
import com.airport.entities.ReportTopRunway;

@Controller
public class MainController {

    @Autowired
    private AirportsRepository airportsRepository;
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private RunwaysRepository runwaysRepository;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<Countries> conCountrieses = countriesRepository.findAll();
        model.addAttribute("countries", conCountrieses);

        return "index";
    }

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("persons", "persons");

        return "personList";
    }

    @RequestMapping(value = {"/searchcountry"}, method = RequestMethod.GET)
    public String searchCountry(Model model, @RequestParam(name = "countryid") int id,
            @RequestParam(name = "countrycode") String code) {
        List<Airports> airports = airportsRepository.findAirportsByIsoCountry(code);
        model.addAttribute("airports", airports);
        List<Countries> conCountrieses = countriesRepository.findAll();
        model.addAttribute("countries", conCountrieses);
        Optional<Countries> opCountry = countriesRepository.findById(id);
        if (opCountry.isPresent()) {
            model.addAttribute("country", opCountry.get());
        }

        return "index";
    }

    @RequestMapping(value = {"/runways"}, method = RequestMethod.GET)
    public String searchRunways(Model model, @RequestParam(name = "id") int airportRefId) {
        List<Runways> runways = runwaysRepository.findByAirportRef(airportRefId);
        model.addAttribute("runways", runways);
        Optional<Airports> opAirport = airportsRepository.findById(airportRefId);
        if (opAirport.isPresent()) {
            model.addAttribute("airport", opAirport.get());
        }
        return "runways";
    }

    @RequestMapping(value = {"/report"}, method = RequestMethod.GET)
    public String getReport(Model model) {
        List<IReportTop> reportTopAirport = airportsRepository.getReportTopAirport();
        List<IReportTop> topSubList = reportTopAirport.subList(0, 10);
        List<ReportTopAirport> reportTopAirports = new ArrayList<>();
        for (IReportTop iReportTopAirport : topSubList) {
            Countries country = countriesRepository.findCountriesByCode(iReportTopAirport.getKey());
            reportTopAirports.add(new ReportTopAirport(country, iReportTopAirport.getAmount()));
        }
        List<ReportTopAirport> reportLowAirports = new ArrayList<>();

        List<IReportTop> lowSubList = reportTopAirport.subList(reportTopAirport.size() - 10, reportTopAirport.size());
        for (IReportTop iReportTopAirport : lowSubList) {
            Countries country = countriesRepository.findCountriesByCode(iReportTopAirport.getKey());
            reportLowAirports.add(new ReportTopAirport(country, iReportTopAirport.getAmount()));
        }

        List<IReportTop> iReportTopRunways = runwaysRepository.getReportTopRunways();
        List<ReportTopRunway> reportTopRunways = new ArrayList<>();
        for (IReportTop iReportTopRunway : iReportTopRunways.subList(0, 10)) {
            reportTopRunways.add(new ReportTopRunway(iReportTopRunway.getKey(), iReportTopRunway.getAmount()));
        }
        model.addAttribute("reporttopairport", reportTopAirports);
        model.addAttribute("reportlowairport", reportLowAirports);
        model.addAttribute("reporttoprunways", reportTopRunways);

        return "report";
    }
}
