export class ParametrosConsulta {

    // filtros
    public id: number;
    public nome: string;
    public idLegislatura: number[] = [];
    public siglaUf: string[] = [];
    public siglaPartido: string[] = [];
    public siglaSexo: string;
    public ano: number[] = [];
    public mes: number[] = [];
    public cnpjCpfFornecedor: string;

    // paginacao
    public itens: number = 20;
    public pagina: number = 1;
}
