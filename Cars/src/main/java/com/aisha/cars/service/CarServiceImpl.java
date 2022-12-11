package com.aisha.cars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;
import com.aisha.cars.repos.CarRepository;
@Service
public class CarServiceImpl implements CarService {
@Autowired
CarRepository carRepository;
@Override
public car saveCar(car a) {
	return carRepository.save(a);
	}
	@Override
	public car updateCar(car a) {
	return carRepository.save(a);
	}
	@Override
	public void deleteCar(car a) {
	carRepository.delete(a);
	}
	 @Override
	public void deleteCarById(Long id) {
	carRepository.deleteById(id);
	}
	@Override
	public car getCar(Long id) {
	return carRepository.findById(id).get();
	}
	@Override
	public List<car> getAllCars() {
	return carRepository.findAll();
	}
	@Override
	public Page<car> getAllCarsParPage(int page, int size) {
		return carRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<car> findByNomCar(String nom) {
	return carRepository.findByNomCar(nom);
	}
	@Override
	public List<car> findByNomCarContains(String nom) {
	return carRepository.findByNomCarContains(nom);
	}

	@Override
	public List<car> findByGroupe(Groupe groupe) {
	return carRepository.findByGroupe(groupe);
	}
	@Override
	public List<car> findByGroupeIdGrp(Long id) {
	return carRepository.findByGroupeIdGrp(id);
	}
	@Override
	public List<car> findByOrderByNomCarAsc() {
	return carRepository.findByOrderByNomCarAsc();
	}
	@Override
	public List<car> trierCarsNoms() {
	return carRepository.trierCarsNoms();
	}
}