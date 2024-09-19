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
  }

  deletar(){
    // implementar
  }
}
