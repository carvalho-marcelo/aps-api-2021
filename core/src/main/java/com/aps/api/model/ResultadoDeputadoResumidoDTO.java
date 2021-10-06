package com.aps.api.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class ResultadoDeputadoResumidoDTO implements Serializable {

	private static final long serialVersionUID = 3176677271072742948L;
	
	private ArrayList<DeputadoResumidoDTO> dados;
	
}
