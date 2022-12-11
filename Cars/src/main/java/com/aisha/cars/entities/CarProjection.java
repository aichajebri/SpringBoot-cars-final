package com.aisha.cars.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomCar", types = { car.class })
public interface CarProjection {
public String getNomCaString();
}