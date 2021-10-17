import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConsultarDeputadoComponent } from './pages/consultar-deputado/consultar-deputado.component';
import { ConsultarGastosComponent } from './pages/consultar-gastos/consultar-gastos.component';

const routes: Routes = [
    {
        path: '',
        component: ConsultarDeputadoComponent
    },
    {
        path: 'gastos/:id',
        component: ConsultarGastosComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DeputadoRoutingModule { }
