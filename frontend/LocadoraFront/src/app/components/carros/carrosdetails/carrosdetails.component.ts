import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { Carro } from '../../../models/carro';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-carrosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './carrosdetails.component.html',
  styleUrl: './carrosdetails.component.scss'
})
export class CarrosdetailsComponent {

  carro: Carro = new Carro(0, "Carro", "Marca")
  router = inject(ActivatedRoute);
  router2 = inject(Router); // Redirecionamento
  constructor(){
    let id = this.router.snapshot.params['id'];
    if(id > 0){
      this.findById(id);
    }
  }
  
  save(){
    if(this.carro.id > 0){
      Swal.fire({
        title: 'Sucesso',
        text: 'Salvo com sucesso',
        icon: 'success',
        confirmButtonText: 'Ok'
      })
      this.router2.navigate(['admin/carros'], { state: {carroEditado: this.carro}})
    }else{
      Swal.fire({
        title: 'Editado',
        text: 'Editado com sucesso',
        icon: 'success',
        confirmButtonText: 'Ok'
      })
    this.router2.navigate(['admin/carros'], { state: {carroNovo: this.carro}})
  }
  }

  findById(id: number){
    // implementar busca no spring
    let carroRetornado: Carro = new Carro(id, "Teste Edição", "Marca");
    this.carro = carroRetornado;
  }
} 
