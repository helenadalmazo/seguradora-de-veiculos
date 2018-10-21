package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {

	@Autowired
	private CoberturaCalculationFactory coberturaCalculationFactory;
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	public Apolice calcular(PropostaVO proposta) {
		float result = 0f;
		
		for(Cobertura c : proposta.getCoberturas()) {
			CoberturaCalculation calculation = 
					coberturaCalculationFactory.build(c);
			result = result + calculation.calcular(proposta);
		}
		
		Apolice apolice = new Apolice();
		apolice.setCliente(proposta.getCliente());
		apolice.setCoberturas(proposta.getCoberturas());
		apolice.setVeiculo(proposta.getVeiculo());
		apolice.setPreco(result);
		apoliceRepository.save(apolice);
		
		return apolice;
	}
}
