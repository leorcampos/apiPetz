package testePratico.apiPetz.api.mapper;

import testePratico.apiPetz.api.controller.dto.ClienteDTO;
import testePratico.apiPetz.api.domain.Cliente;

public class ClienteMapper implements DomainMapper<Cliente, ClienteDTO> {

	PetMapper petMapper = new PetMapper();
	
	
	@Override
	public Cliente toDomain(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		return updateDomain(cliente, dto);
	}

	@Override
	public Cliente updateDomain(Cliente cliente, ClienteDTO dto) {
		cliente.setId(dto.getId());
		cliente.setNome(dto.getNome());
		cliente.setPet(petMapper.toDomain(dto.getPet()));
		
		return cliente;
	}

	@Override
	public ClienteDTO fromDomain(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setPet(petMapper.fromDomain(cliente.getPet()));
		
		return clienteDTO;
	}
}
