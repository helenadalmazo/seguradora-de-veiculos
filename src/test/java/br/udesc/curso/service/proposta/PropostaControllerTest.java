package br.udesc.curso.service.proposta;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.udesc.curso.controller.PropostaController;
import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropostaControllerTest {

	@Autowired
	private PropostaController propostaController;
	
	PropostaVO propostaVO;
	
	@Before
	public void setup() {
		
		Cliente cliente = Cliente.builder()
				.nascimento(new Date(2000-1900, 10, 1))
				.cpf("12345678911")
				.build();
		
		Veiculo veiculo = Veiculo.builder()
				.placa("ABC-9099")
				.valor(10000)
				.anoFabricacao(2000)
				.build();
		
		Set<Cobertura> coberturas = new HashSet<>();
		coberturas.add(Cobertura.PERDA_TOTAL);
		
		propostaVO = PropostaVO.builder()
				.cliente(cliente)
				.veiculo(veiculo)
				.coberturas(coberturas)
				.build();
	}
	
	@Test
	public void calculaPropostaVOPeloController() {
		
		float valor = propostaController.enviar(propostaVO).getPreco();
		
		Assert.assertEquals(500, valor, 0);
	}
}
