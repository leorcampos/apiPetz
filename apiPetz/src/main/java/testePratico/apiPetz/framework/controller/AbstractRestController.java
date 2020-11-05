package testePratico.apiPetz.framework.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import testePratico.apiPetz.api.mapper.DomainMapper;
import testePratico.apiPetz.framework.util.ObjectConvert;

public abstract class AbstractRestController<E, T, ID extends Serializable> implements RestController<E, ID>{

	
	protected Class<?> clazz;
	protected String baseUrl;
	
	@PostMapping
	protected ResponseEntity<?> create(@RequestBody T dto){
		var domain = getMapper().toDomain(dto);
		service().save(domain);
		return ResponseEntity.status(HttpStatus.CREATED).body(getMapper().fromDomain(domain));
	}
	
	@PutMapping(value="/{id}")
	protected ResponseEntity<?> update(@RequestBody T dto){
		service().merge(getMapper().toDomain(dto));
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping(value="/{id}")
	protected ResponseEntity<Void> delete(@PathVariable("id") ID id, RedirectAttributes redirectAttributes){
		service().delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping(value="/{id}")
	protected ResponseEntity<?> find (@PathVariable("id") ID id){
		T entity = getMapper().fromDomain((E) service().findById(id));
		var objeto = ObjectConvert.parserObjeto(entity, getClazz());
		return ResponseEntity.status(HttpStatus.OK).body(objeto);
	}
	
	@GetMapping
	protected ResponseEntity<List<?>> find (){
		List<?> list = (List<?>) ObjectConvert.parserListObjeto(service().findAll(), getClazz());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	protected Class <?> getClazz(){
		return clazz;
	}
	
	protected String getBaseURL() {
		return clazz.getSimpleName().toLowerCase();
	}
	
	protected abstract DomainMapper<E, T> getMapper();
}
