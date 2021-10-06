package com.aps.api.model.comum;

import java.io.Serializable;

import lombok.Data;

@Data
public class PaginacaoDTO<F> implements Serializable {

	private static final long serialVersionUID = 2454808609195967461L;

	private Integer quantidadePorPagina;
	private Integer numeroPagina;
	private F filtro;

}
