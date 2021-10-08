package com.aps.api.model.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeputadoUltimoStatusDTO implements Serializable {

	private static final long serialVersionUID = -528498438083205989L;
	
	private Long id;
	private String nome;
	private String siglaPartido;
	private String siglaUf;
	private Long idLegislatura;
	private String urlFoto;
	private String email;
	private String data;
	private String nomeEleitoral;
	private String situacao;
	private String condicaoEleitoral;
	
}
