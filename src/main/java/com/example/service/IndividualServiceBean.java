package com.example.service;

import com.example.domain.Individual;
import com.example.domain.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class IndividualServiceBean implements IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    @Override
    public Collection<Individual> findAll() {
        ArrayList<Individual> result = new ArrayList<>(individualRepository.findAll());
        Collections.sort(result, new Comparator<Individual>() {
            public int compare(Individual c1, Individual c2) {
                return c1.getId().compareTo(c2.getId());
            }
        });
        return result;
    }

    @Override
    public Individual findOne(Long id) {
        return individualRepository.findById(id).orElse(null);
    }

    @Override
    public Individual create(Individual individual) {
        if (individual.getId() != null) {
            return null;
        }
        return individualRepository.save(individual);
    }

    @Override
    public Individual update(Individual individual) {
        return individualRepository.save(individual);
    }

    @Override
    public void delete(Individual individual) {
        individualRepository.delete(individual);
    }

    @Override
    public Individual createEmpty() {
        Random r = new Random();
        Individual individual = new Individual();
        individual.setName("A Name" + r.nextInt(10000));
        individual.setSsn("" + r.nextInt(10000) + "GH");
        individual.setDateOfBirth(new Date(0L));
        individual.setMobilePhone("555-555-5555");
        return individual;
    }

}
