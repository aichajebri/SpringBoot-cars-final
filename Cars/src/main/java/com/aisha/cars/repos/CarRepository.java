package com.aisha.cars.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;
@RepositoryRestResource(path="rest")
public interface CarRepository extends JpaRepository<car, Long> {
	List<car> findByNomCar(String nom);
	 List<car> findByNomCarContains(String nom);
	 @Query("select a from car a where a.groupe = ?1")
	 List<car> findByGroupe (Groupe groupe);
	 List<car> findByGroupeIdGrp(Long id);
	 List<car> findByOrderByNomCarAsc();
	 @Query("select a from car a order by a.nomCar ASC")
	 List<car> trierCarsNoms();
}