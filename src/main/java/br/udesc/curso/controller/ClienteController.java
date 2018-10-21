package br.udesc.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Cidade;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.CidadeRepository;
import br.udesc.curso.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeRepository repositoryCidade;
	
	@PostMapping("/salvar")
	public Cliente salvar(@RequestBody Cliente cliente) {
		Cidade cidade = repositoryCidade.findById(cliente.getCidade().getId()).get();
		cliente.setCidade(cidade);
		return repository.saveAndFlush(cliente);
	}
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/encontrar/{id}")
	public Cliente encontrar(@PathVariable("id") long id) {
		if(repository.findById(id).isPresent())
			return repository.findById(id).get();
		else
			return null;
	}
	
	@DeleteMapping("deletar/{id}")
	public void deletar(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("buscar/porCidade/{id}")
	public List<Cliente> buscarPorCidade(@PathVariable("id") long id) {
		Cidade cidade = repositoryCidade.findById(id).get();
		return repository.findByCidade_nome(cidade.getNome());
	}
	
	@GetMapping("buscar/likeNome/{nome}")
	public List<Cliente> buscarLikeNome(@PathVariable("nome") String nome) {
		return repository.findByNomeContaining(nome);
	}
	
	@GetMapping("buscar/resideFaixaRisco")
	public List<Cliente> buscarCidadeCliente() {
		return repository.findByResideComFaixaRiscoTrue();
	}
}
