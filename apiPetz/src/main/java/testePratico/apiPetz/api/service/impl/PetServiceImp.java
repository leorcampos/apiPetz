package testePratico.apiPetz.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testePratico.apiPetz.api.controller.dto.PetDTO;
import testePratico.apiPetz.api.domain.Pet;
import testePratico.apiPetz.api.repository.PetRepository;
import testePratico.apiPetz.api.service.PetService;
import testePratico.apiPetz.framework.persistencia.Dao;
import testePratico.apiPetz.framework.service.ServiceImpl;

@Service
public class PetServiceImp extends ServiceImpl<Pet, Integer> implements PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public Dao<Pet, Integer> getDao() {
		return petRepository;
	}

}
