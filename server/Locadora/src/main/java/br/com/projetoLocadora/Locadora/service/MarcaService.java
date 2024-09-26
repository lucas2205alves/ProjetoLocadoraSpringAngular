package br.com.projetoLocadora.Locadora.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoLocadora.Locadora.entity.Marca;
import br.com.projetoLocadora.Locadora.repository.MarcaRepository;


@Service
public class MarcaService {
    @Autowired
	private MarcaRepository marcaRepository;
	

	public String save (Marca marca) {
		this.marcaRepository.save(marca);
		return "Carro cadastrado com sucesso";
	}

	public String update (Marca marca, long id) {
		marca.setId(id);
		this.marcaRepository.save(marca);
		return "Atualizado com sucesso";
	}
	
	public Marca findById (long id) {
		Optional<Marca> optional = this.marcaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Marca> findAll () {
		
		return this.marcaRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.marcaRepository.deleteById(id);
		return "Marca deletada com sucesso!";
	}
	
	
	public List<Marca> findByNome(String nome){
		return this.marcaRepository.findByNomeStartsWith(nome);
	}
}
