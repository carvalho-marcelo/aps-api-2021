import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ParametrosConsulta } from "src/app/shared/model/ParametrosConsulta";
import { DenunciaDespesa } from "../model/DenunciaDespesa";

@Injectable()
export class DeputadoService {

    private urlBase: string = 'http://localhost:8080/aps/deputado';

    public httpOptionsJson = {
        headers: new HttpHeaders(
            {
                'Content-Type': 'application/json'
            }
        )
    }

    constructor(protected http: HttpClient) {
    }

    public recuperarPeloNomePaginado(params: ParametrosConsulta): Observable<any> {
        return this.http.post<any>(this.urlBase + '/buscar-paginado', params, this.httpOptionsJson);
    }

    public recuperarDetalhado(id: number): Observable<any> {
        return this.http.get<any>(this.urlBase + '/' + id);
    }

    public recuperarDespesas(params: ParametrosConsulta): Observable<any> {
        return this.http.post<any>(this.urlBase + '/despesas', params, this.httpOptionsJson);
    }

    public registrarDenunciaDespesa(denunciaDespesa: DenunciaDespesa): Observable<any> {
        return this.http.post<any>(this.urlBase + '/denuncia-despesa', denunciaDespesa, this.httpOptionsJson);
    }

}