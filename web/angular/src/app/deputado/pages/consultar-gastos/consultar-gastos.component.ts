import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ParametrosConsulta } from 'src/app/shared/model/ParametrosConsulta';
import { Deputado } from '../../model/Deputado';
import { DespesasDeputado } from '../../model/DespesasDeputado';
import { DeputadoService } from '../../service/deputado-service';

@Component({
    selector: 'app-consultar-gastos',
    templateUrl: './consultar-gastos.component.html',
    styleUrls: ['./consultar-gastos.component.scss']
})
export class ConsultarGastosComponent implements OnInit {

    deputado: Deputado;
    despesas: DespesasDeputado;
    loading: boolean = true;
    cols: any[];
    params: ParametrosConsulta;
    
    meses: number[] = [];
    mesesSelecionados: number[] = [];
    anos: number[] = [];
    anosSelecionados: number[] = [];

    constructor(private deputadoService: DeputadoService,
        private route: ActivatedRoute) {
            for (let i = 1; i <= 12; i++) {
                this.meses.push(i);
            }

            const anoAtual = new Date().getFullYear();
            for (let i = 2010; i <= anoAtual; i++) {
                this.anos.push(i);
            }
        }

    ngOnInit(): void {
        this.params = new ParametrosConsulta();
        const deputadoId = this.route.snapshot.params.id;

        this.deputadoService.recuperarDetalhado(deputadoId).subscribe(
            res => {
                this.deputado = res;
                console.log(res);
            },
            error => {
                console.log(error);
            }
        );

        this.params.id = deputadoId;

        this.deputadoService.recuperarDespesas(this.params).subscribe(
            res => {
                this.despesas = res.dados;
                this.loading = false;
            },
            error => {
                console.log(error);
                this.loading = false;
            }
        );

        this.cols = [
            { field: 'nomeFornecedor', header: 'Fornecedor', class: 'p-col-4' },
            { field: 'tipoDespesa', header: 'Despesa', class: 'p-col-4' },
            { field: 'dataDocumento', header: 'Data', class: 'p-col-1' },
            { field: 'valorDocumento', header: 'Valor', class: 'p-col-1' },
            { field: 'valorLiquido', header: 'Valor Liquido', class: 'p-col-1' },
            { field: 'notaFiscal', header: 'Nota Fiscal', class: 'p-col-1' }
        ];
    }

    consultar(): void {
        this.loading = true;

        if (this.mesesSelecionados.length > 0 && this.anosSelecionados.length > 0) {
            this.params.ano = this.anosSelecionados;
        } else if (this.mesesSelecionados.length > 0) {
            this.params.ano.push(new Date().getFullYear());
        }
        this.params.mes = this.mesesSelecionados;

        this.deputadoService.recuperarDespesas(this.params).subscribe(
            res => {
                this.loading = false;
                this.despesas = res.dados;
                console.log(res);
            },
            error => {
                this.loading = false;
                console.log(error);
            }
        )
    }

}
