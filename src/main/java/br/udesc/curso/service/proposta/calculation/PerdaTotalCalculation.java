package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class PerdaTotalCalculation extends CoberturaCalculation {

	@Override
	float calcularValor(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0; //proposta.getVeiculo().getValor() * calcularPercentualVeiculo(proposta);
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposta) {
		// TODO Auto-generated method stub
		
		float percentual;
		
		int idade = new Date().getYear() - proposta.getCliente().getNascimento().getYear();
		
		if(idade < 24) {
			percentual = 0.05f;
		} else if (idade >= 24 && idade < 40) {
			percentual = 0.03f;
		} else {
			percentual = 0.01f;
		}
		
		return percentual;
	}

}
