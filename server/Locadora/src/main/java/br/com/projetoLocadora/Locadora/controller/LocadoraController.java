package br.com.projetoLocadora.Locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoLocadora.Locadora.entity.Entrada;
import br.com.projetoLocadora.Locadora.entity.Resultado;
import br.com.projetoLocadora.Locadora.service.LocadoraService;

@Controller
@RequestMapping("/calculos")
public class LocadoraController {
    
    @Autowired
    private LocadoraService locadoraService;

    @GetMapping("/somar")
    public ResponseEntity<Resultado> somar(@RequestBody Entrada entrada){

        try {
            Resultado resultado = this.locadoraService.somar(entrada);
            return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
