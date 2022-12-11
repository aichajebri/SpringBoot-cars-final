package com.aisha.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner {
@Autowired
private RepositoryRestConfiguration repositoryRestConfiguration;
public static void main(String[] args) {
SpringApplication.run(CarsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
repositoryRestConfiguration.exposeIdsFor(car.class, Groupe.class);
}
}
