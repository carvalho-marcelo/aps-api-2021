package com.aps.api.model.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class LegislaturaDTO implements Serializable {

	private static final long serialVersionUID = -5628081184270297132L;
	
	private Long id;
	private String dataInicio;
	private String dataFim;
	
}
