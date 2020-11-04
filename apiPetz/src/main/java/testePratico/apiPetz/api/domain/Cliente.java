package testePratico.apiPetz.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

@Entity
@SequenceGenerator(name="cliente_seq", sequenceName="cliente_sequence", allocationSize=1)
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator ="cliente_seq")
	@Column(name="id_cliente")
	private Integer id;
	
	@Column(name="nome_cliente")
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pet")
	private Pet pet;
	
	
}
