package com.aps.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.api.model.dtos.LegislaturaDTO;

@Service
public class LegislaturaService {
	
	@Autowired
	private IntegracaoDadosAbertosService integracaoDadosAbertosService;

	public LegislaturaDTO recuperarUltimaLegislatura() {
		return integracaoDadosAbertosService.recuperarUltimaLegislatura();
	}
	
}
