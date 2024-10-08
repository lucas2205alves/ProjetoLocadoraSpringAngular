package br.com.projetoLocadora.Locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetoLocadora.Locadora.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

	public List<Carro> findByNomeStartsWith(String nome);
	
	@Query("FROM Carro WHERE ano > :ano")
	public List<Carro> findByAcimaAno(int ano);
	
	
}