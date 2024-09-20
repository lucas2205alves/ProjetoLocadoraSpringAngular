import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {

  lista: Carro[] = [];

  constructor(){

    this.lista.push(new Carro(1, "ABC", "Marca"))
    this.lista.push(new Carro(2, "ABC", "Marca"))
    this.lista.push(new Carro(3, "ABC", "Marca"))

    // Se no momento que trocou de rota se foi enviado algum dado, se foi ele irá criar o novo objeto
    let carroNovo = history.state.carroNovo;
    let carroEditado = history.state.carroEditado;

    if(carroNovo){
      carroNovo.id = 1000
      this.lista.push(carroNovo)
    }

    if(carroEditado){
      let indice = this.lista.findIndex(x => {return x.id == carroEditado.id});
      this.lista[indice] = carroEditado;
    }
  }

  deleteById(){
    // implementar
  }
}
