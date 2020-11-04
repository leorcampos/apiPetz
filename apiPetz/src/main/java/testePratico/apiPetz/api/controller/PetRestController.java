package testePratico.apiPetz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import testePratico.apiPetz.api.domain.Pet;
import testePratico.apiPetz.api.service.impl.PetServiceImp;
import testePratico.apiPetz.framework.controller.AbstractRestController;
import testePratico.apiPetz.framework.service.Service;

@RestController
public class PetRestController extends AbstractRestController<Pet, Integer> {

	static final String BASE_URL = "/pet";
	@Autowired
	private PetServiceImp petServiceImp;

	@Override
	public Service<Pet, Integer> service() {
		return petServiceImp;
	}
	
	@Override
	public String getBaseURL() {
		return BASE_URL;
	}

}
