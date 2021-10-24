package com.aps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.api.model.comum.ParametrosConsulta;
import com.aps.api.model.comum.ResultadoListaDTO;
import com.aps.api.model.dtos.DenunciaDespesaDTO;
import com.aps.api.model.dtos.DeputadoDTO;
import com.aps.api.model.dtos.DeputadoResumidoDTO;
import com.aps.api.model.dtos.DespesasDeputadoDTO;
import com.aps.api.service.DeputadoService;

@RestController
@RequestMapping(value = "/deputado")
public class DeputadoController {

	@Autowired
	private DeputadoService service;
	
	@PostMapping(value = "/buscar-paginado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<DeputadoResumidoDTO>> recuperarPeloNomePaginado(@RequestBody ParametrosConsulta params) {
		return ResponseEntity.ok(service.recuperarPeloNomePaginado(params));
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeputadoDTO> recuperarDetalhado(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(service.recuperarDetalhado(id));
	}
	
	@PostMapping(value = "/despesas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultadoListaDTO<DespesasDeputadoDTO>> recuperarDespesas(@RequestBody ParametrosConsulta params) {
		return ResponseEntity.ok(service.recuperarDespesas(params));
	}
	
	@PostMapping(value = "/denuncia-despesa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DenunciaDespesaDTO> registrarDenunciaDespesa(@RequestBody DenunciaDespesaDTO denunciaDespesa) {
		return ResponseEntity.ok(service.registrarDenunciaDespesa(denunciaDespesa));
	}
	
}
