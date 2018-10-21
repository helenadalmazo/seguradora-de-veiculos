package br.udesc.curso.enums;

import java.util.Arrays;
import java.util.List;

//@NoArgsConstructor(access=AccessLevel.PRIVATE)
public enum Cobertura {
	PERDA_TOTAL(Servico.GUINCHO, Servico.TAXI, Servico.OFICINA),
	TERCEIROS(Servico.OFICINA),
	ASSISTENCIA(Servico.GUINCHO, Servico.COMBUSTIVEL),
	VIDROS(Servico.PARABRISA, Servico.RETROVISOR, Servico.LANTERNA),
	CARRO_RESERVA(Servico.CARRO_RESERVA, Servico.HOTEL);
	
	private List<Servico> servicos;
	
	private Cobertura(Servico...servicos) {
		this.servicos = Arrays.asList(servicos);
	}
}
