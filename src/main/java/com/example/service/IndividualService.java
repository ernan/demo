package com.example.service;

import com.example.domain.Individual;

import java.util.Collection;

public interface IndividualService {

    Collection<Individual> findAll();

    Individual createEmpty();

    Individual create(Individual individual);

    Individual update(Individual individual);

    void delete(Individual individual);

    Individual findOne(Long id);
}
