package com.aps.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DENUNCIA_DESPESA")
public class DenunciaDespesa implements Serializable {

	private static final long serialVersionUID = -4961096761893640794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ID_DEPUTADO")
	private Long idDeputado;
	
	@Column(name = "ID_DESPESA")
	private Long idDespesa;
	
	@Column(name = "MOTIVO_DENUNCIA")
	private String motivo;
	
	@Column(name = "DESCRICAO_DENUNCIA")
	private String descricao;
	
}
