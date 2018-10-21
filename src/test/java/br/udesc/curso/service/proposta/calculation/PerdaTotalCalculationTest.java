package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.junit.Test;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import junit.framework.Assert;

public class PerdaTotalCalculationTest {
	
	@Test
	public void testeVidaLoka() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(2000-1900, 10, 1));
		
		Veiculo veiculo = Veiculo.builder().build(); //new Veiculo();
		veiculo.setAnoFabricacao(1995);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		veiculo.setValor(10000);
		
		PropostaVO proposta = PropostaVO.builder().build(); //new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(500, valor, 0);
	}

	@Test
	public void testeTiozao() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1980-1900, 10, 1));
		
		Veiculo veiculo = Veiculo.builder().build(); //new Veiculo();
		veiculo.setAnoFabricacao(2010);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		veiculo.setValor(25000);
		
		PropostaVO proposta = PropostaVO.builder().build(); //new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(500, valor, 0);
	}
	
	@Test
	public void testeVovo() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1950-1900, 10, 1));
		
		Veiculo veiculo = Veiculo.builder().build(); //new Veiculo();
		veiculo.setAnoFabricacao(2018);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		veiculo.setValor(40000);
		
		PropostaVO proposta = PropostaVO.builder().build(); //new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(500, valor, 0);
	}
}
