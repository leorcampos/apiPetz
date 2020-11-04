package testePratico.apiPetz.framework.controller;

import java.io.Serializable;

import testePratico.apiPetz.framework.service.Service;

public interface RestController<E, ID extends Serializable> {

	public Service<E, ID> service();
}
