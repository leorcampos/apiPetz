package testePratico.apiPetz.api.mapper;

import testePratico.apiPetz.api.controller.dto.PetDTO;
import testePratico.apiPetz.api.domain.Pet;

public class PetMapper implements DomainMapper<Pet, PetDTO> {

	@Override
	public Pet toDomain(PetDTO dto) {
		Pet pet = new Pet();
		return updateDomain(pet, dto);
	}

	@Override
	public Pet updateDomain(Pet pet, PetDTO dto) {
		pet.setId(dto.getId());
		pet.setNome(dto.getNome());
		pet.setTipo(dto.getTipo());
		pet.setIdade(dto.getIdade());
		
		return pet;
	}

	@Override
	public PetDTO fromDomain(Pet pet) {
		
		PetDTO petDTO = new PetDTO();
		petDTO.setId(pet.getId());
		petDTO.setNome(pet.getNome());
		petDTO.setTipo(pet.getTipo());
		petDTO.setIdade(pet.getIdade());
		
		return petDTO;
	}

	
}
