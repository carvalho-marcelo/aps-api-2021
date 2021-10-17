import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import ptBr from '@angular/common/locales/pt';
import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { MultiSelectModule } from 'primeng/multiselect';
import { TableModule } from 'primeng/table';
import { LegislaturaService } from '../legislatura/service/legislatura-service';
import { PipesModule } from '../shared/util/pipes/pipes.module';
import { DeputadoRoutingModule } from './deputado-routing.module';
import { ConsultarDeputadoComponent } from './pages/consultar-deputado/consultar-deputado.component';
import { ConsultarGastosComponent } from './pages/consultar-gastos/consultar-gastos.component';
import { DeputadoService } from './service/deputado-service';

registerLocaleData(ptBr);

@NgModule({
    declarations: [ConsultarDeputadoComponent, ConsultarGastosComponent],
    imports: [
        CommonModule,
        DeputadoRoutingModule,
        FormsModule,
        InputTextModule,
        HttpClientModule,
        ButtonModule,
        TableModule,
        PipesModule,
        MultiSelectModule,
        CardModule
    ],
    providers: [
        LegislaturaService,
        DeputadoService,
        { provide: LOCALE_ID, useValue: 'pt' }
    ]
})
export class DeputadoModule { }
