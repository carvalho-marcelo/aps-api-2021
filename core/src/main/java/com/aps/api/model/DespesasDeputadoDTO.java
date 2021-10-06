package com.aps.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DespesasDeputadoDTO implements Serializable {

	private static final long serialVersionUID = -8667633523116171330L;
	
	private Integer ano;
	private Integer mes;
	private String tipoDespesa;
	private Long codDocumento;
	private String tipoDocumento;
	private Long codTipoDocumento;
	private String dataDocumento;
	private String numDocumento;
	private Double valorDocumento;
	private String urlDocumento;
	private String nomeFornecedor;
	private String cnpjCpfFornecedor;
	private Double valorLiquido;
	private Double valorGlosa;
	private String numRessarcimento;
	private Long codLote;
	private Integer parcela;
	
}
