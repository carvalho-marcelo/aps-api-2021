package com.aps.api.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Datapublic class ResultadoListaDTO<T> implements Serializable {

	private static final long serialVersionUID = -3954106367919806058L;
	
	private ArrayList<T> dados;
	
}
