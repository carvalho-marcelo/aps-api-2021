package com.aps.api.model.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeputadoResumidoDTO implements Serializable {

	private static final long serialVersionUID = 316388994787960895L;
	
	private Long id;
	private String nome;
	private String siglaPartido;
	private String siglaUf;
	private String urlFoto;
	private String email;
	
}
