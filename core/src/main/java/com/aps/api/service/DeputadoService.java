package com.aps.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.aps.api.model.comum.ParametrosConsulta;
import com.aps.api.model.comum.ResultadoListaDTO;
import com.aps.api.model.dtos.DeputadoDTO;
import com.aps.api.model.dtos.DeputadoResumidoDTO;
import com.aps.api.model.dtos.DespesasDeputadoDTO;

@Service
public class DeputadoService {

	@Autowired
	private IntegracaoDadosAbertosService integracaoDadosAbertosService;
	
	public Page<DeputadoResumidoDTO> recuperarPeloNomePaginado(ParametrosConsulta params) {
		return integracaoDadosAbertosService.recuperarDeputados(params);
	}

	public DeputadoDTO recuperarDetalhado(Long id) {
		return integracaoDadosAbertosService.recuperarDeputadoDetalhado(id);
	}

	public ResultadoListaDTO<DespesasDeputadoDTO> recuperarDespesas(ParametrosConsulta params) {
		return integracaoDadosAbertosService.recuperarDespesasDoDeputado(params);
	}

}
