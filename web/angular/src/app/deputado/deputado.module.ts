import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { LegislaturaService } from '../legislatura/service/legislatura-service';
import { DeputadoRoutingModule } from './deputado-routing.module';
import { ConsultarDeputadoComponent } from './pages/consultar-deputado/consultar-deputado.component';
import { DeputadoService } from './service/deputado-service';
import { ConsultarGastosComponent } from './pages/consultar-gastos/consultar-gastos.component';


@NgModule({
    declarations: [ConsultarDeputadoComponent, ConsultarGastosComponent],
    imports: [
        CommonModule,
        DeputadoRoutingModule,
        FormsModule,
        InputTextModule,
        HttpClientModule,
        ButtonModule,
        TableModule
    ],
    providers: [
        LegislaturaService,
        DeputadoService
    ]
})
export class DeputadoModule { }
