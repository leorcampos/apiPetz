package testePratico.apiPetz.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="pet_seq", sequenceName="pet_sequence", allocationSize=1)
public class Pet {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator ="pet_seq")
	@Column(name="id_pet")
	private Integer id;
	
	@Column(name="nome_pet")
	private String nome;
	
	@Column(name="especie")
	private String especie;
	
	@Column(name="animal")
	private String animal;
}
