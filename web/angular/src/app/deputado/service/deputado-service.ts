import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ParametrosConsulta } from "src/app/shared/model/ParametrosConsulta";

@Injectable()
export class DeputadoService {

    public urlBase: string = 'http://localhost:8080/aps/deputado';

    public httpOptionsJson = {
        headers: new HttpHeaders(
            {
                'Content-Type': 'application/json'
            }
        )
    }

    constructor(protected http: HttpClient) {
    }

    public recuperarPeloNomePaginado(paginacao: ParametrosConsulta): Observable<any> {
        return this.http.post<any>(this.urlBase + '/buscar-paginado', paginacao, this.httpOptionsJson);
    }

}