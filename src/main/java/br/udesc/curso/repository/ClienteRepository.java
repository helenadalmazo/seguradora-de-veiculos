package br.udesc.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.udesc.curso.model.Cidade;
import br.udesc.curso.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByCidade_nome(String cidadeNome);
	
	List<Cliente> findByNomeContaining(String nome);
	
	List<Cliente> findByResideComFaixaRiscoTrue();
	
	Cliente findByCpf(String cpf);
	
}
