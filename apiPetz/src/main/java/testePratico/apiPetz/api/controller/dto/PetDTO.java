package testePratico.apiPetz.api.controller.dto;

import java.io.Serializable;

public class PetDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String especie; 
	private String animal;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
}
