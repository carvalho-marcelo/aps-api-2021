import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import ptBr from '@angular/common/locales/pt';
import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { MultiSelectModule } from 'primeng/multiselect';
import { TableModule } from 'primeng/table';
import { MensagemModule } from '../shared/components/mensagem/mensagem.module';
import { PipesModule } from '../shared/util/pipes/pipes.module';
import { DeputadoRoutingModule } from './deputado-routing.module';
import { ConsultarDeputadoComponent } from './pages/consultar-deputado/consultar-deputado.component';
import { ConsultarGastosComponent } from './pages/consultar-gastos/consultar-gastos.component';
import { ModalDenunciaGastoComponent } from './pages/modal-denuncia-gasto/modal-denuncia-gasto.component';
import { DeputadoService } from './service/deputado-service';

registerLocaleData(ptBr);

@NgModule({
    declarations: [ConsultarDeputadoComponent, ConsultarGastosComponent, ModalDenunciaGastoComponent],
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
        CardModule,
        DialogModule,
        InputTextareaModule,
        InputNumberModule,
        MensagemModule
    ],
    providers: [
        DeputadoService,
        { provide: LOCALE_ID, useValue: 'pt' }
    ]
})
export class DeputadoModule { }
