package br.udesc.curso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.udesc.curso.enums.EstadoCivil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Veiculo {

	private int anoFabricacao;
	
	@Column(length=8)
	private String placa;
	
	private float valor;
	
	private boolean blindado;

	private boolean importado;
}
