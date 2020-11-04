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

import testePratico.apiPetz.framework.util.ObjectConvert;

public abstract class AbstractRestController<T, ID extends Serializable> implements RestController<T, ID>{

	protected Class<Object> clazz;
	protected String baseURL;
	
	@PostMapping
	protected ResponseEntity<?> create(@RequestBody T entity){
		service().save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(ObjectConvert.parserObjeto(entity, getClazz()));
	}
	
	@PutMapping(value="/{id}")
	protected ResponseEntity<?> update(@RequestBody T entity){
		service().merge(entity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping(value="/{id}")
	protected ResponseEntity<Void> delete(@PathVariable("id") ID id, RedirectAttributes redirectAttributes){
		service().delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping(value="/{id}")
	protected ResponseEntity<?> find (@PathVariable("id") ID id){
		T entity = service().findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ObjectConvert.parserObjeto(entity, getClazz()));
	}
	
	@GetMapping
	protected ResponseEntity<List<?>> find (){
		List<?> list = ObjectConvert.parserListObjeto(service().findAll(), getClazz());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	protected Class<?> getClazz(){
		return clazz;
	}
	
	protected String getBaseURL() {
		return clazz.getSimpleName().toLowerCase();
	}
}
