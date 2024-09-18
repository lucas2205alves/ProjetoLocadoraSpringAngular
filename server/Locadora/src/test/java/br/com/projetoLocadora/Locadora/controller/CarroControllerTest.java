package br.com.projetoLocadora.Locadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import br.com.projetoLocadora.Locadora.entity.Carro;

@SpringBootTest
public class CarroControllerTest {
    
    @Autowired
    CarroController carroController;


    // Teste básico
    @Test
    void retornoLista(){
        ResponseEntity<List<Carro>> retorno = this.carroController.findAll();
        assertEquals(200, retorno.getStatusCode().value());
    }

    // Teste de Integração
    @Test
    void retornoCadastro(){
        Carro carro = new Carro();
        carro.setNome("ABC");
        carro.setAno(2000);
        ResponseEntity<String> retorno = this.carroController.save(carro);
        assertEquals(200, retorno.getStatusCode().value());
    }

    @Test
    void cadastroComNomeInvalido(){
        Carro carro = new Carro();
        carro.setNome("");
        ResponseEntity<String> retorno = this.carroController.save(carro);
        assertEquals(400, retorno.getStatusCode().value());
    }

    @Test
    void cadastroComAnoInvalido(){
        Carro carro = new Carro();
        carro.setAno(0);
        ResponseEntity<String> retorno = this.carroController.save(carro);
        assertEquals(400, retorno.getStatusCode().value());
    }
}

