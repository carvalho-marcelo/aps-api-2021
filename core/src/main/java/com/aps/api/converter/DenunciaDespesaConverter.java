package com.aps.api.converter;

import org.springframework.stereotype.Component;

import com.aps.api.model.DenunciaDespesa;
import com.aps.api.model.dtos.DenunciaDespesaDTO;

@Component
public class DenunciaDespesaConverter {

	public DenunciaDespesa dtoToEntity(DenunciaDespesaDTO dto) {
		DenunciaDespesa entidade = new DenunciaDespesa();
		entidade.setId(dto.getId());
		entidade.setIdDeputado(dto.getIdDeputado());
		entidade.setIdDespesa(dto.getIdDespesa());
		entidade.setMotivo(dto.getMotivo());
		entidade.setDescricao(dto.getDescricao());
		return entidade;
	}
	
	public DenunciaDespesaDTO entityToDto(DenunciaDespesa entidade) {
		DenunciaDespesaDTO dto = new DenunciaDespesaDTO();
		dto.setId(entidade.getId());
		dto.setIdDeputado(entidade.getIdDeputado());
		dto.setIdDespesa(entidade.getIdDespesa());
		dto.setMotivo(entidade.getMotivo());
		dto.setDescricao(entidade.getDescricao());
		return dto;
	}

}
