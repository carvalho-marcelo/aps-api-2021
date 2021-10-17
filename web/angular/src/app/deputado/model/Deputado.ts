import { DeputadoUltimoStatus } from "./DeputadoUltimoStatus";

export class Deputado {
    public id: number;
	public nomeCivil: string;
	public ultimoStatus: DeputadoUltimoStatus;
	public cpf: string;
	public sexo: string;
	public dataNascimento: string;
	public dataFalecimento: string;
	public ufNascimento: string;
	public municipioNascimento: string;
	public escolaridade: string;
}