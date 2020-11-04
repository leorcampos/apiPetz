package testePratico.apiPetz.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testePratico.apiPetz.api.domain.Cliente;
import testePratico.apiPetz.api.repository.ClienteRepository;
import testePratico.apiPetz.api.service.ClienteService;
import testePratico.apiPetz.framework.persistencia.Dao;
import testePratico.apiPetz.framework.service.ServiceImpl;

@Service
public class ClienteServiceImp extends ServiceImpl<Cliente, Integer> implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Dao<Cliente, Integer> getDao() {
		return clienteRepository;
	}

}
