import { Routes } from '@angular/router';
import { CarroslistComponent } from './components/carroslist/carroslist.component';

export const routes: Routes = [
    {path: "", redirectTo: "carros", pathMatch:"full"},
    {path: "carros", component: CarroslistComponent}
];
