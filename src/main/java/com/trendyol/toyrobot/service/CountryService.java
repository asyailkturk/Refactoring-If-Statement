package com.trendyol.toyrobot.service;

import com.trendyol.toyrobot.domain.Country;
import com.trendyol.toyrobot.repository.CountryRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country save(Country country) {
        try {
            return countryRepository.save(country);
        } catch (ConstraintViolationException e) {
            LOGGER.info("Country already exist with code: {}", country.getCode());
            throw new RuntimeException("Country already exist");
        }
    }

    public Collection<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country getCountryByCode(String countryCode) {
        return countryRepository.findCountryByCode(countryCode).orElseThrow(RuntimeException::new);
    }
}
