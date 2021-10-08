package com.aps.api.model.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultadoDTO<T> implements Serializable {

	private static final long serialVersionUID = -1132706644668219820L;

	private T dados;

}
