import { Component, inject } from '@angular/core';
import { Carro } from '../../../models/carro';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CarroService } from '../../../services/carro.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {

  lista: Carro[] = [];
  carroService = inject(CarroService);
  erro: any;
  constructor(){

   this.findAll()
  }

  findAll(){
    this.carroService.findAll().subscribe({
      next: lista =>{ // Retorno positivo
        this.lista = lista;
      },
      error: erro => { // Ocorrer erro
          alert("Erro");
      }
    })

  }

  deleteById(carro: Carro) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar esse carro?',
      icon: 'warning',
      showConfirmButton: true,
      showDenyButton: true,
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não',
    }).then((result) => {
      if (result.isConfirmed) {


        this.carroService.delete(carro.id).subscribe({
          next: mensagem => { //quando o back retornar o que se espera
            Swal.fire({
              title: mensagem,
              icon: 'success',
              confirmButtonText: 'Ok',
            });

            this.findAll();
          },
          error: erro => { //quando ocorrer qualquer erro (badrequest, exceptions..)
            Swal.fire({
              title: 'Ocorreu um erro',
              icon: 'error',
              confirmButtonText: 'Ok',
            });
          }
        });


      }
    });
  }
}
