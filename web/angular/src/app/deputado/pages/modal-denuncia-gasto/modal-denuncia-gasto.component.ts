import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MensagemComponent } from 'src/app/shared/components/mensagem/mensagem.component';
import { DenunciaDespesa } from '../../model/DenunciaDespesa';
import { Deputado } from '../../model/Deputado';
import { DespesaDeputado } from '../../model/DespesaDeputado';
import { DeputadoService } from '../../service/deputado-service';

@Component({
    selector: 'app-modal-denuncia-gasto',
    templateUrl: './modal-denuncia-gasto.component.html',
    styleUrls: ['./modal-denuncia-gasto.component.scss']
})
export class ModalDenunciaGastoComponent implements OnInit {

    display: boolean = false;
    despesa: DespesaDeputado;
    motivo: string;
    descricao: string;

    @Input('deputado') deputado: Deputado;
    @ViewChild('appMensagem') appMensagem: MensagemComponent;

    constructor(private deputadoService: DeputadoService) { }

    ngOnInit(): void {
    }

    apresentarModal(): void {
        this.motivo = '';
        this.descricao = '';
        this.display = true;
    }

    voltar(): void {
        this.display = false;
    }

    denunciarGasto(): void {
        let denunciaDespesa = new DenunciaDespesa();
        denunciaDespesa.idDeputado = this.deputado.id;
        denunciaDespesa.idDespesa = this.despesa.codDocumento;
        denunciaDespesa.motivo = this.motivo;
        denunciaDespesa.descricao = this.descricao;

        this.deputadoService.registrarDenunciaDespesa(denunciaDespesa).subscribe(
            res => {
                this.appMensagem.apresentarMensagemSucesso('Denúncia realizada com sucesso!');
                this.display = false;
            },
            error => {
                this.appMensagem.apresentarMensagemErro(error.error);
                console.log(error);
                this.display = false;
            }
        )
    }

}
