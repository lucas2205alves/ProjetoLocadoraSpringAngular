package br.com.projetoLocadora.Locadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoLocadora.Locadora.entity.Carro;
import br.com.projetoLocadora.Locadora.repository.CarroRepository;


@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	

	public String save (Carro carro) {
		this.verificarNomeAnoCarro(carro.getNome(), carro.getAno());
		this.carroRepository.save(carro);
		return "Carro cadastrado com sucesso";
	}
	
	// Regra de negócio no Service
	public void verificarNomeAnoCarro(String nome, int ano){
		if(nome.equals(""))
			throw new RuntimeException();
		if(ano == 0)
			throw new RuntimeException();
		if(nome.equals("Gol") && ano > 2022)
			throw new RuntimeException();
	}

	public String update (Carro carro, long id) {
		this.verificarNomeAnoCarro(carro.getNome(), carro.getAno());
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Atualizado com sucesso";
	}
	
	public Carro findById (long id) {
		
		Optional<Carro> optional = this.carroRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Carro> findAll () {
		
		return this.carroRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.carroRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNomeStartsWith(nome);
	}
	
	public List<Carro> findByAcimaAno(int ano){
		return this.carroRepository.findByAcimaAno(ano);
	}
	
	
}