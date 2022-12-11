package com.aisha.cars.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.repos.GrpRepository;
import com.aisha.cars.service.GrpService;

import java.util.List;

@RestController
@RequestMapping("/api/grp")
@CrossOrigin("*")
public class GroupeRESTController {
	@Autowired
	GrpRepository grpRepository;
	@Autowired
	GrpService grpService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Groupe> getAllGroupes() {
	return grpService.getAllGroupes();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Groupe createGroupe(@RequestBody Groupe grp) {
	return grpService.saveGroupe(grp);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Groupe updateGroupe(@RequestBody Groupe grp) {
	return grpService.updateGroupe(grp);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteGroupe(@PathVariable("id") Long id)
	{
		grpService.deleteGroupeById(id);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Groupe getCategorieById(@PathVariable("id") Long id) {
	return grpRepository.findById(id).get();
	}
}
