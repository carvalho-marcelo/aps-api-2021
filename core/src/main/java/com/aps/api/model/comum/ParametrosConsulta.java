package com.aps.api.model.comum;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParametrosConsulta implements Serializable {

	private static final long serialVersionUID = -6043995776305644426L;
	
	// filtros
	private Long id;
	private String nome;
	private Long idLegislatura;
	private String siglaUf;
	private String siglaPartido;
	private String siglaSexo;
	private Long ano;
	private Long mes;
	private String cnpjCpfFornecedor;
	
	// Paginacao
	private Integer pagina;
	private Integer itens;
	
}
