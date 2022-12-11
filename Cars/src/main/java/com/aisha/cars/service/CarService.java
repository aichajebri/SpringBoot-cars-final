package com.aisha.cars.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;
public interface CarService {
car saveCar(car a);
car updateCar(car a);
void deleteCar(car a);
 void deleteCarById(Long id);
car getCar(Long id);
List<car> getAllCars();
Page<car> getAllCarsParPage(int page, int size);
List<car> findByNomCar(String nom);
List<car> findByNomCarContains(String nom);
List<car> findByGroupe (Groupe groupe);
List<car> findByGroupeIdGrp(Long id);
List<car> findByOrderByNomCarAsc();
List<car> trierCarsNoms();
}