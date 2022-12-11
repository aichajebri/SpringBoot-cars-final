package com.aisha.cars.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aisha.cars.entities.Groupe;
import com.aisha.cars.repos.GrpRepository;


@Service
public class GrpServiceImpl implements GrpService {

    @Autowired
    private GrpRepository grpRepository;

    @Override
    public List <Groupe> findAll() {
        return grpRepository.findAll();
    }

	@Override
	public Groupe saveGroupe(Groupe g) {
		return grpRepository.save(g);
	}

	@Override
	public Groupe updateGroupe(Groupe g) {
		return grpRepository.save(g);
	}

	@Override
	public void deleteGroupe(Groupe g) {
		grpRepository.delete(g);
	}

	@Override
	public void deleteGroupeById(Long idGrp) {
		grpRepository.deleteById(idGrp);
	}

	@Override
	public Groupe getGroupe(Long idGrp) {
		return grpRepository.findById(idGrp).get();
	}

	@Override
	public List<Groupe> getAllGroupes() {
		return grpRepository.findAll();
	}

	@Override
	public Page<Groupe> getAllGroupesParPage(int page, int size) {
		return grpRepository.findAll(PageRequest.of(page, size));
	}

   
}