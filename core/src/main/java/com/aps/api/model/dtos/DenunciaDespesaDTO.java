package com.aps.api.model.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class DenunciaDespesaDTO implements Serializable {

	private static final long serialVersionUID = -7359352553275364375L;

	private Long id;
	private Long idDeputado;
	private Long idDespesa;
	private String motivo;
	private String descricao;
	
}
