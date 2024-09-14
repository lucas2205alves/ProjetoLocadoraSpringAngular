package br.com.projetoLocadora.Locadora.service;

import org.springframework.stereotype.Service;

import br.com.projetoLocadora.Locadora.entity.Entrada;
import br.com.projetoLocadora.Locadora.entity.Resultado;

@Service
public class LocadoraService {
    public Resultado somar(Entrada entrada){

        Resultado resultado = new Resultado();
        int soma = 0;

        if(entrada.getLista() != null)
        for(int i=0; i<entrada.getLista().size(); i++){
            soma += entrada.getLista().get(i);
        }

    resultado.setSoma(soma);
    return null;
    }
}
