package com.aisha.cars.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aisha.cars.entities.Groupe;


public interface GrpService {

    List <Groupe> findAll();
    List<Groupe> getAllGroupes();
    Page<Groupe> getAllGroupesParPage(int page, int size);
    Groupe saveGroupe(Groupe g);
    Groupe updateGroupe(Groupe g);
    void deleteGroupe(Groupe g);
     void deleteGroupeById(Long id);
     Groupe getGroupe (Long idGrp);

}