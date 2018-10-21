package br.udesc.curso.service.proposta.calculation;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class AssistenciaCalculation extends CoberturaCalculation{

	@Override
	float calcularValor(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
