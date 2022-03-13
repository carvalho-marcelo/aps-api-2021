import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeputadoModule } from './deputado/deputado.module';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'deputado',
        loadChildren: () => DeputadoModule
    },
    {
        path: ':idLegislatura/deputado',
        loadChildren: () => DeputadoModule
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
