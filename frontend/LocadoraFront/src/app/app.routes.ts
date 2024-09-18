import { Routes } from '@angular/router';
import { CarroslistComponent } from './components/carros/carroslist/carroslist.component';
import { LoginComponent } from './components/layout/login/login.component';
import { CarrosdetailsComponent } from './components/carros/carrosdetails/carrosdetails.component';


export const routes: Routes = [
    {path: "", redirectTo: "login", pathMatch:"full"},
    {path: "login", component: LoginComponent},
    {path: "admin", component: LoginComponent, children:[
        {path: "carros", component: CarroslistComponent},
        {path: "carros/new", component: CarrosdetailsComponent},
        {path: "carros/edit/:id", component: CarrosdetailsComponent}
    ]}
];
