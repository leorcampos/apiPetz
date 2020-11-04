package testePratico.apiPetz.api.repository;

import org.springframework.stereotype.Repository;

import testePratico.apiPetz.api.domain.Pet;
import testePratico.apiPetz.framework.persistencia.Dao;

@Repository
public interface PetRepository extends Dao<Pet, Integer>{

}
