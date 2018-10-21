package br.udesc.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Apolice;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.ClienteRepository;
import br.udesc.curso.service.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaService propostaService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/enviar")
	public Apolice enviar(@RequestBody PropostaVO proposta) {
	//	Cliente cliente = clienteRepository.findById(proposta.getCliente().getId()).get();
		Cliente cliente = clienteRepository.findByCpf(proposta.getCliente().getCpf());
		proposta.setCliente(cliente);
		return propostaService.calcular(proposta);
	}
}
