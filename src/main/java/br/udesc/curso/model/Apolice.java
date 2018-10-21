package br.udesc.curso.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.enums.Servico;
import lombok.Data;

@Data
@Entity
public class Apolice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Veiculo veiculo;
	
	@ElementCollection(targetClass=Cobertura.class)
	@Enumerated(EnumType.STRING)
	private Set<Cobertura> coberturas;
	
	private float preco;
	
	@Temporal(TemporalType.DATE)
	private Date inicioVigencia;
	
	@Temporal(TemporalType.DATE)
	private Date fimVigencia;
}
