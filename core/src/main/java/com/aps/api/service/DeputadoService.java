package com.aps.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.aps.api.converter.DenunciaDespesaConverter;
import com.aps.api.model.DenunciaDespesa;
import com.aps.api.model.comum.ParametrosConsulta;
import com.aps.api.model.comum.ResultadoListaDTO;
import com.aps.api.model.dtos.DenunciaDespesaDTO;
import com.aps.api.model.dtos.DeputadoDTO;
import com.aps.api.model.dtos.DeputadoResumidoDTO;
import com.aps.api.model.dtos.DespesasDeputadoDTO;
import com.aps.api.repository.IDenunciaDespesaRepository;

@Service
public class DeputadoService {

	@Autowired
	private IntegracaoDadosAbertosService integracaoDadosAbertosService;
	
	@Autowired
	private DenunciaDespesaConverter converterDenunciaDespesa;
	
	@Autowired
	private IDenunciaDespesaRepository repositoryDenunciaDespesa;
	
	public Page<DeputadoResumidoDTO> recuperarPeloNomePaginado(ParametrosConsulta params) {
		return integracaoDadosAbertosService.recuperarDeputados(params);
	}

	public DeputadoDTO recuperarDetalhado(Long id) {
		return integracaoDadosAbertosService.recuperarDeputadoDetalhado(id);
	}

	public ResultadoListaDTO<DespesasDeputadoDTO> recuperarDespesas(ParametrosConsulta params) {
		return integracaoDadosAbertosService.recuperarDespesasDoDeputado(params);
	}

	@Transactional
	public DenunciaDespesaDTO registrarDenunciaDespesa(DenunciaDespesaDTO denunciaDespesaDto) {
		DenunciaDespesa denunciaDespesa = converterDenunciaDespesa.dtoToEntity(denunciaDespesaDto);
		repositoryDenunciaDespesa.save(denunciaDespesa);
		return converterDenunciaDespesa.entityToDto(denunciaDespesa);
	}

}
