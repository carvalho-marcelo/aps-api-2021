import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    idLegislatura: number;
    deputados: DeputadoResumido[];
    cols: any[];
    loading: boolean = true;
    mostrarLista: boolean = false;

    constructor(private deputadoService: DeputadoService,
        private router: Router,
        private route: ActivatedRoute) { }

    ngOnInit(): void {
        this.idLegislatura = this.route.snapshot.params.idLegislatura;

        this.cols = [
            { field: 'nome', header: 'Nome', class: 'p-col-4' },
            { field: 'siglaPartido', header: 'Partido', class: 'p-col-2' },
            { field: 'siglaUf', header: 'UF', class: 'p-col-1' },
            { field: 'email', header: 'Email', class: 'p-col-4' },
            { field: 'acoes', header: 'Ações', class: 'p-col-1' }
        ];
    }

    consultar(): void {
        this.loading = true;
        let params = new ParametrosConsulta();
        params.itens = 500;
        params.nome = this.nomeDeputado;
        
        if (this.idLegislatura) {
            params.idLegislatura.push(this.idLegislatura);
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
