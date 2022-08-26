package com.example.devadmintask.controller;

import com.example.devadmintask.domain.City;
import com.example.devadmintask.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityRepository repo;

    //Create new city
    @PutMapping
    public void createCity (@RequestBody City city) {
        repo.save(city);
    }

    //Find city by ID
    @GetMapping("/{id}")
    public City findCity (@PathVariable long id) {
        return repo.findById(id).get();
    }

    //Find all
    @GetMapping
    public List<City> findAllCities() {
        return repo.findAll();
    }

    //Update existing city
    @PatchMapping("/{id}")
    public void updateCity (@RequestBody City updatedCity, @PathVariable long id) {

        City cityFromDB = repo.findById(id).get();

        //Replace each field
        if (updatedCity.getName()!=null) {
            cityFromDB.setName(updatedCity.getName());
        }
        if (updatedCity.getCountryCode()!=null) {
            cityFromDB.setCountryCode(updatedCity.getCountryCode());
        }
        if (updatedCity.getDistrict()!=null) {
            cityFromDB.setDistrict(updatedCity.getDistrict());
        }
        if (updatedCity.getPopulation()>0) {
            cityFromDB.setPopulation(updatedCity.getPopulation());
        }

        repo.save(cityFromDB);

    }

    //Delete city
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id) {
        repo.deleteById(id);
    }

}