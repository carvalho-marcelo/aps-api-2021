import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';
import { Legislatura } from '../model/Legislatura';

@Injectable()
export class LegislaturaService {

    private urlBase: string = `${environment}/legislatura`;

    constructor(protected http: HttpClient) {
    }

    public recuperarUltimaLegislatura(): Observable<Legislatura> {
        return this.http.get<Legislatura>(this.urlBase + '/ultimo-registro');
    }

}