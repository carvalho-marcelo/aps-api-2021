import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Legislatura } from 'src/app/legislatura/model/Legislatura';
import { LegislaturaService } from 'src/app/legislatura/service/legislatura-service';
import { ParametrosConsulta } from 'src/app/shared/model/ParametrosConsulta';
import { DeputadoResumido } from '../../model/DeputadoResumido';
import { DeputadoService } from '../../service/deputado-service';

@Component({
    selector: 'app-consultar-deputado',
    templateUrl: './consultar-deputado.component.html',
    styleUrls: ['./consultar-deputado.component.scss']
})
export class ConsultarDeputadoComponent implements OnInit {

    nomeDeputado: string;
    legislatura: Legislatura;
    deputados: DeputadoResumido[];
    cols: any[];
    loading: boolean = true;
    mostrarLista: boolean = false;

    constructor(private legislaturaService: LegislaturaService,
        private deputadoService: DeputadoService,
        private router: Router,
        private route: ActivatedRoute) { }

    ngOnInit(): void {
        const isLegislaturaAtual = window.history.state.isLegislaturaAtual;
        if (isLegislaturaAtual) {
            this.legislaturaService.recuperarUltimaLegislatura().subscribe(
                res => {
                    this.legislatura = res;
                },
                error => {
                    console.log(error);
                }
            );
        }

        this.cols = [
            { field: 'nome', header: 'Nome', class: 'p-col-4' },
            { field: 'siglaPartido', header: 'Partido', class: 'p-col-2' },
            { field: 'siglaUf', header: 'UF', class: 'p-col-1' },
            { field: 'email', header: 'Email', class: 'p-col-4' },
            { field: 'acoes', header: '', class: 'p-col-1' }
        ];
    }

    consultar(): void {
        this.loading = true;
        let params = new ParametrosConsulta();
        params.nome = this.nomeDeputado;
        
        if (this.legislatura) {
            params.idLegislatura.push(this.legislatura.id);
        }

        this.mostrarLista = true;

        console.log(params);
        this.deputadoService.recuperarPeloNomePaginado(params).subscribe(
            res => {
                this.loading = false;
                console.log(res);
                this.deputados = res.content;
            },
            error => {
                this.loading = false;
                console.log(error);
            },
        );
    }

    consultarGastos(id: number): void {
        this.router.navigate(['gastos/' + id], { relativeTo: this.route.parent })
    }

}
