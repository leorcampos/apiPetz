package testePratico.apiPetz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testePratico.apiPetz.api.controller.dto.ClienteDTO;
import testePratico.apiPetz.api.domain.Cliente;
import testePratico.apiPetz.api.service.impl.ClienteServiceImp;
import testePratico.apiPetz.framework.controller.AbstractRestController;
import testePratico.apiPetz.framework.service.Service;

@RestController
@RequestMapping(ClienteRestController.BASE_URL)
public class ClienteRestController extends AbstractRestController<Cliente, Integer> {

	static final String BASE_URL = "/cliente";
	@Autowired
	private ClienteServiceImp clienteServiceImp;

	@Override
	public Service<Cliente, Integer> service() {
		return clienteServiceImp;
	}
	
	@Override 
	public Class<ClienteDTO>getClazz(){
		return ClienteDTO.class;
	}
	
	@Override
	public String getBaseURL() {
		return BASE_URL;
	}

}
