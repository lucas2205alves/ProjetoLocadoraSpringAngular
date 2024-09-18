import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {

  lista: Carro[] = [];

  constructor(){
    let carro: Carro = new Carro();
    carro.id = 1;
    carro.nome = "abc";
    carro.marca = "abc";

    let carro2: Carro = new Carro();
    carro2.id = 2;
    carro2.nome = "abc";
    carro2.marca = "marca2";

    let carro3: Carro = new Carro();
    carro3.id = 3;
    carro3.nome = "abc";
    carro3.marca = "marca";

    this.lista.push(carro)
    this.lista.push(carro2)
    this.lista.push(carro3)
  }
}
