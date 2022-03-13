import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LegislaturaService } from '../legislatura/service/legislatura-service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    loading: boolean = false;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private legislaturaService: LegislaturaService) { }

    ngOnInit(): void {
    }

    mudarTelaConsultaDeputado(isLegislaturaAtual: boolean): void {
        if (isLegislaturaAtual) {
            this.loading = true;

            this.legislaturaService.recuperarUltimaLegislatura().subscribe(
                res => {
                    this.loading = false;
                    this.router.navigate([res.id + '/deputado'], { relativeTo: this.route.parent })
                },
                error => {
                    console.log(error);
                }
            );

        } else {
            this.router.navigate(['deputado'], { relativeTo: this.route.parent })
        }
    }

}
