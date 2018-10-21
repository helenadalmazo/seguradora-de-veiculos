package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class VidroCalculation extends CoberturaCalculation {

	@Override
	float calcularValor(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposta) {
		// TODO Auto-generated method stub
		float percentual;
		
		int idadeVeiculo = new Date().getYear() - proposta.getVeiculo().getAnoFabricacao();
		
		if (idadeVeiculo < 3) {
			percentual = 0.0075f;
		} else if (idadeVeiculo >= 3 && idadeVeiculo < 5) {
			percentual = 0.0055f;
		} else if (idadeVeiculo >= 5 && idadeVeiculo < 10) {
			percentual = 0.0025f;
		} else {
			percentual = 0.0075f;
		}
		
		if(proposta.getVeiculo().isBlindado()) {
			if(proposta.getVeiculo().isImportado()) {
				percentual = percentual + 0.0075f;
			} else {
				percentual = percentual + 0.005f;
			}
			
		} else {
			if(proposta.getVeiculo().isImportado()) {
				percentual = percentual + 0.0065f;
			} else {
				//percentual
			}
		}
		
		return percentual;
	}

}
