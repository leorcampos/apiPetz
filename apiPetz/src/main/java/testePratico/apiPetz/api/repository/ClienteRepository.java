package testePratico.apiPetz.api.repository;

import org.springframework.stereotype.Repository;

import testePratico.apiPetz.api.domain.Cliente;
import testePratico.apiPetz.framework.persistencia.Dao;

@Repository
public interface ClienteRepository extends Dao<Cliente, Integer>{

}
