package com.aisha.cars.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.entities.car;
import com.aisha.cars.service.CarService;
import com.aisha.cars.service.GrpService;
@Controller
public class CarController {
@Autowired
CarService carService;
@Autowired
GrpService grpService;


@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
modelMap.addAttribute("car", new car());
modelMap.addAttribute("mode", "new");
return "formCar";
}
@RequestMapping("/saveCar")
public String saveCar(ModelMap modelMap,@Valid car car,
BindingResult bindingResult)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
System.out.println(car);
if (bindingResult.hasErrors()) return "formCar";
carService.saveCar(car);
return "redirect:/ListeCars";
}

@RequestMapping("/showCreateGrp")
public String showCreateGrp(ModelMap modelMap)
{
modelMap.addAttribute("groupes", new Groupe());
modelMap.addAttribute("mode", "new");
return "formGroupe";
}
@RequestMapping("/saveGroupe")
public String saveGroupe(@ModelAttribute("groupe") Groupe groupe,ModelMap modelMap) throws ParseException 
{
Groupe saveGroupe = grpService.saveGroupe(groupe);
return "redirect:/ListeGrp";
}


@RequestMapping("/ListeGrp")
public String ListeGrp(ModelMap modelMap)
{
List <Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
return "ListeGrp";
}

@RequestMapping("/ListeCars")
public String ListeCars(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
Page<car> anims = carService.getAllCarsParPage(page, size);
modelMap.addAttribute("cars", anims);
 modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "ListeCars";
}


@RequestMapping("/supprimerCar")
public String supprimerCar(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	carService.deleteCarById(id);
Page<car> anims = carService.getAllCarsParPage(page, 
size);
modelMap.addAttribute("cars", anims);
modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "ListeCars";
}
@RequestMapping("/supprimerGroupe")
public String supprimerGroupe(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
grpService.deleteGroupeById(id);
List<Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
return "ListeGrp";
}

@RequestMapping("/modifierCar")
public String modifierCar(@RequestParam("id") Long id,ModelMap modelMap)
{
car a= carService.getCar(id);
List<Groupe> grps = grpService.findAll();
grps.remove(a.getGroupe());
modelMap.addAttribute("groupes", grps);
modelMap.addAttribute("car", a);
modelMap.addAttribute("mode", "edit");
return "formCar";
}
@RequestMapping("/updateCar")
public String updateCar(@ModelAttribute("car") car car,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateAjout = dateformat.parse(String.valueOf(date));
	 car.setDateAjout(dateAjout);
	 
	 carService.updateCar(car);
	 List<car> anims = carService.getAllCars();
	 modelMap.addAttribute("cars", anims);
	return "ListeCars";
	}
@RequestMapping("/modifierGroupe")
public String editerGroupe(@RequestParam("id") Long id,ModelMap modelMap)
{
Groupe g= grpService.getGroupe(id);
modelMap.addAttribute("groupes", g);
modelMap.addAttribute("mode", "edit");
return "formGroupe";
}
@RequestMapping("/updateGroupe")
public String updateGroupe(@ModelAttribute("groupe") Groupe groupe,ModelMap modelMap) throws ParseException {
	grpService.updateGroupe(groupe);
	 List<Groupe> grps = grpService.findAll();
	 modelMap.addAttribute("groupes", grps);
	return "ListeGrp";
	}


@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
List<car> anims =carService.findByNomCar(nom);
modelMap.addAttribute("cars",anims);
modelMap.addAttribute("mode", "SearchNomP");
return "ListeCars";
}
@RequestMapping("/searchGrp")
public String recherGrp(@RequestParam("grp") Long grp,ModelMap modelMap)
{
Groupe grps = new Groupe();
grps.setIdGrp(grp);
List<Groupe> grps2 = grpService.findAll();
modelMap.addAttribute("groupes", grps2);
List<car> anims = carService.findByGroupe(grps);
modelMap.addAttribute("cars",anims);
modelMap.addAttribute("mode", "Searchgrp");
return "ListeCars";
}
}