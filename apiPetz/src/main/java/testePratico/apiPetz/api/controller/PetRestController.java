package testePratico.apiPetz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testePratico.apiPetz.api.controller.dto.PetDTO;
import testePratico.apiPetz.api.domain.Pet;
import testePratico.apiPetz.api.mapper.DomainMapper;
import testePratico.apiPetz.api.mapper.PetMapper;
import testePratico.apiPetz.api.service.impl.PetServiceImp;
import testePratico.apiPetz.framework.controller.AbstractRestController;
import testePratico.apiPetz.framework.service.Service;

@RestController
@RequestMapping(PetRestController.BASE_URL)
public class PetRestController extends AbstractRestController<Pet, PetDTO, Integer> {

	static final String BASE_URL = "/pet";
	
	@Autowired
	private PetServiceImp petServiceImp;

	public static final PetMapper MAPPER = new PetMapper();
	  
	@Override
	public Service<Pet, Integer> service() {
		return petServiceImp;
	}
	
	
	@Override
	public String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected DomainMapper<Pet, PetDTO> getMapper() {
		return MAPPER;
	}
	
	@Override
	public Class<PetDTO> getClazz(){
		return PetDTO.class;
	}

}
