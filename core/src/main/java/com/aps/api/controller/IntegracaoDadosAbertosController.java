package com.aps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.api.model.DeputadoDTO;
import com.aps.api.model.DeputadoResumidoDTO;
import com.aps.api.model.DespesasDeputadoDTO;
import com.aps.api.model.ResultadoDTO;
import com.aps.api.model.ResultadoListaDTO;
import com.aps.api.model.comum.PaginacaoDTO;
import com.aps.api.service.IntegracaoDadosAbertosService;

@RestController
@RequestMapping(value = "/integracao-dados-abertos")
public class IntegracaoDadosAbertosController {

	@Autowired
	private IntegracaoDadosAbertosService integracaoService;
	
	@GetMapping(value = "/deputado-paginado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<DeputadoResumidoDTO>> recuperarDeputadosPeloNomePaginado(@RequestBody PaginacaoDTO<String> paginacaoDTO) {
		return ResponseEntity.ok(integracaoService.recuperarDeputadosPeloNomePaginado(paginacaoDTO));
	}
	
	@GetMapping(value = "/deputado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultadoDTO<DeputadoDTO>> recuperarDadosDoDeputado(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(integracaoService.recuperarDadosDoDeputado(id));
	}
	
	@GetMapping(value = "/deputado/{id}/despesas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultadoListaDTO<DespesasDeputadoDTO>> recuperarDespesasDoDeputado(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(integracaoService.recuperarDespesasDoDeputado(id));
	}
	
}
