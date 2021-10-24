import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Legislatura } from '../legislatura/model/Legislatura';
import { LegislaturaService } from '../legislatura/service/legislatura-service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    legislatura: Legislatura;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private legislaturaService: LegislaturaService) { }

    ngOnInit(): void {
        this.legislaturaService.recuperarUltimaLegislatura().subscribe(
            res => {
                this.legislatura = res;
            },
            error => {
                console.log(error);
            }
        );
    }

    mudarTelaConsultaDeputado(isLegislaturaAtual: boolean): void {
        if (isLegislaturaAtual) {
            this.router.navigate([this.legislatura.id + '/deputado'], { relativeTo: this.route.parent })
        } else {
            this.router.navigate(['deputado'], { relativeTo: this.route.parent })
        }
    }

}
