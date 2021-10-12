package com.aps.api.model.comum;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class ParametrosConsulta implements Serializable {

	private static final long serialVersionUID = -6043995776305644426L;
	
	// filtros
	private Long id;
	private String nome;
	private ArrayList<Long> idLegislatura;
	private ArrayList<String> siglaUf;
	private ArrayList<String> siglaPartido;
	private String siglaSexo;
	private ArrayList<Long> ano;
	private ArrayList<Long> mes;
	private String cnpjCpfFornecedor;
	
	// Paginacao
	private Integer pagina;
	private Integer itens;
	
}
