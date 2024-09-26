package br.com.projetoLocadora.Locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetoLocadora.Locadora.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
    public List<Marca> findByNomeStartsWith(String nome);
	
	@Query("FROM Carro WHERE ano > :ano")
	public List<Marca> findByAcimaAno(int ano);
}
