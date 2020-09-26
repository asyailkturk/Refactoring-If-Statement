package com.trendyol.toyrobot.controller;

import com.trendyol.toyrobot.domain.Country;
import com.trendyol.toyrobot.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @GetMapping
    public Collection<Country> getCountries() {
        return countryService.findAll();
    }

    @GetMapping("/code/{countryCode}")
    public Country getCountryByCode(@PathVariable("countryCode") String countryCode) {
        return countryService.getCountryByCode(countryCode);
    }
}
