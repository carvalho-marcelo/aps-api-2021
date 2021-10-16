import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Legislatura } from '../model/Legislatura';

@Injectable()
export class LegislaturaService {

    public urlBase: string = 'http://localhost:8080/aps/legislatura';

    constructor(protected http: HttpClient) {
    }

    public recuperarUltimaLegislatura(): Observable<Legislatura> {
        return this.http.get<Legislatura>(this.urlBase + '/ultimo-registro');
    }

}