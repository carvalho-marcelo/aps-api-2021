package com.aps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.aps.api.model.DeputadoResumidoDTO;
import com.aps.api.model.ResultadoDeputadoID;
import com.aps.api.model.ResultadoDeputadoResumidoDTO;
import com.aps.api.model.comum.PaginacaoDTO;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/integracao-dados-abertos")
public class IntegracaoDadosAbertosController {

	@Autowired
	private WebClient webClient;
	
	@GetMapping(value = "/deputado-paginado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<DeputadoResumidoDTO>> recuperarDeputadosPeloNomePaginado(@RequestBody PaginacaoDTO<String> paginacaoDTO) {
		
		Mono<ResultadoDeputadoResumidoDTO> monodeputado = this.webClient
												.get()
												.uri(uriBuilder -> uriBuilder
														.path("/deputados/")
														.queryParam("nome", paginacaoDTO.getFiltro())
														.queryParam("pagina", paginacaoDTO.getNumeroPagina())
														.queryParam("itens", paginacaoDTO.getQuantidadePorPagina())
														.queryParam("ordem", "ASC")
														.queryParam("ordenarPor", "nome")
														.build())
												.retrieve()
												.bodyToMono(ResultadoDeputadoResumidoDTO.class);
		
		ResultadoDeputadoResumidoDTO deputado = monodeputado.block();
		
		Pageable paginacao = PageRequest.of(paginacaoDTO.getNumeroPagina(), paginacaoDTO.getQuantidadePorPagina());
		Page<DeputadoResumidoDTO> lista = new PageImpl<DeputadoResumidoDTO>(deputado.getDados(), paginacao, deputado.getDados().size());;
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultadoDeputadoID> teste() {
		
		Mono<ResultadoDeputadoID> monodeputado = this.webClient
												.method(HttpMethod.GET)
												.uri("/deputados/209189")
												.retrieve()
												.bodyToMono(ResultadoDeputadoID.class);
		
		ResultadoDeputadoID deputado = monodeputado.block();
		
		return ResponseEntity.ok(deputado);
	}
	
}
