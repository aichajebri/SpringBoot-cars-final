package com.aisha.cars;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;
import com.aisha.cars.repos.CarRepository;
import com.aisha.cars.service.CarService;
@SpringBootTest
class CarsApplicationTests {
@Autowired
private CarRepository CarRepository;

@Autowired
private CarService CarService;

@Test
public void testCreateCar() {
car Anim = new car("BMW E36",100.0,"imgUrl",new Date());
CarRepository.save(Anim);
}
@Test
public void testFindCar()
{
car a = CarRepository.findById(1L).get(); 
System.out.println(a);
}
@Test
public void testUpdateCar()
{
car p = CarRepository.findById(1L).get();
p.setNomCar("BMW E36");
CarRepository.save(p);
}
@Test
public void testDeleteCar()
{
	CarRepository.deleteById(1L);;
}
 
@Test
public void testListerTousvs()
{
List<car> anims = CarRepository.findAll();
for (car a : anims)
{
System.out.println(a);
}
}
@Test
public void testFindByNomCarContains()
{
Page<car> anims = CarService.getAllCarsParPage(0,2);
System.out.println(anims.getSize());
System.out.println(anims.getTotalElements());
System.out.println(anims.getTotalPages());
anims.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (car p : prods.getContent()
{
System.out.println(p);
} */
}
@Test
public void testFindByNomCar()
{
List<car> anims = CarRepository.findByNomCar("BMW E36");
for (car a : anims)
{
System.out.println(a);
}
}
@Test
public void findByNomCarContains()
{
List<car> anims=CarRepository.findByNomCarContains("BMW");
for (car a : anims)
{
System.out.println(a);
} }


@Test
public void testfindByGroupe()
{
Groupe grp = new Groupe();
grp.setIdGrp(1L);
List<car> anims = CarRepository.findByGroupe(grp);
for (car a : anims)
{
System.out.println(a);
}
}
@Test
public void findByGroupeIdGrp()
{
List<car> anims = CarRepository.findByGroupeIdGrp(1L);
for (car a : anims)
{
System.out.println(a);
}
 }
@Test
public void testfindByOrderByNomCarAsc()
{
List<car> anims = CarRepository.findByOrderByNomCarAsc();
for (car a : anims)
{
System.out.println(a);
}
}
@Test
public void testTrierCarsNoms()
{
List<car> anims = CarRepository.trierCarsNoms();
for (car a : anims)
{
System.out.println(anims);
}
}
}
