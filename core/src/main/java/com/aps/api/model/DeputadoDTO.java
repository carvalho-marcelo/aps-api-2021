package com.aps.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeputadoDTO implements Serializable {

	private static final long serialVersionUID = -1590607388064149254L;
	
	private Long id;
	private String nomeCivil;
	private DeputadoUltimoStatusDTO ultimoStatus;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private String dataFalecimento;
	private String ufNascimento;
	private String municipioNascimento;
	private String escolaridade;
	
}
