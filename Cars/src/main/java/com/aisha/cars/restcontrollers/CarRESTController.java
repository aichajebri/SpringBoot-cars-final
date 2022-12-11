package com.aisha.cars.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.cars.entities.car;
import com.aisha.cars.service.CarService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarRESTController {
@Autowired
CarService carService;
@RequestMapping(path="all",method = RequestMethod.GET)
public List<car> getAllCars() {
return carService.getAllCars();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public car getCarById(@PathVariable("id") Long id) {
return carService.getCar(id);
 }
@RequestMapping(method = RequestMethod.POST)
public car createCar(@RequestBody car car) {
return carService.saveCar(car);
}
@RequestMapping(method = RequestMethod.PUT)
public car updateCar(@RequestBody car car) {
return carService.updateCar(car);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteCar(@PathVariable("id") Long id)
{
    carService.deleteCarById(id);
}
@RequestMapping(value="/carsgrp/{idGrp}",method = RequestMethod.GET)
public List<car> getCarsByGrpId(@PathVariable("idGrp") Long idGrp) {
return carService.findByGroupeIdGrp(idGrp);
}
@RequestMapping(value="/carsByName/{nom}",method = RequestMethod.GET)
public List<car> findByNomCarContains(@PathVariable("nom") String nom) {
return carService.findByNomCarContains(nom);
}

}
