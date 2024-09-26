package br.com.projetoLocadora.Locadora.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Classes de teste sem função no front-end
@Entity 	
@Getter		
@Setter		
@NoArgsConstructor	
@AllArgsConstructor	
public class Proprietario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;

	private String nome;
	
	private double preco;

	@ManyToMany(mappedBy="proprietarios")
	@JsonIgnoreProperties("proprietarios")
	private List<Carro> carros;

}