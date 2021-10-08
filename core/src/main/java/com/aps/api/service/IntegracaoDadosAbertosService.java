package com.aps.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aps.api.model.DeputadoDTO;
import com.aps.api.model.DeputadoResumidoDTO;
import com.aps.api.model.DespesasDeputadoDTO;
import com.aps.api.model.ResultadoDTO;
import com.aps.api.model.ResultadoListaDTO;
import com.aps.api.model.comum.PaginacaoDTO;

@Service
public class IntegracaoDadosAbertosService {

	@Autowired
	private WebClient webClient;

	public PageImpl<DeputadoResumidoDTO> recuperarDeputadosPeloNomePaginado(PaginacaoDTO<String> paginacaoDTO) {
		ParameterizedTypeReference<ResultadoListaDTO<DeputadoResumidoDTO>> type = new ParameterizedTypeReference<ResultadoListaDTO<DeputadoResumidoDTO>>() {};
		
		ResultadoListaDTO<DeputadoResumidoDTO> deputados = this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/deputados/")
						.queryParam("nome", paginacaoDTO.getFiltro())
						.queryParam("pagina", paginacaoDTO.getNumeroPagina())
						.queryParam("itens", paginacaoDTO.getQuantidadePorPagina())
						.queryParam("ordem", "ASC")
						.queryParam("ordenarPor", "nome")
						.build())
				.retrieve()
				.bodyToMono(type)
				.block();
		
		Pageable paginacao = PageRequest.of(paginacaoDTO.getNumeroPagina(), paginacaoDTO.getQuantidadePorPagina());
		return new PageImpl<DeputadoResumidoDTO>(deputados.getDados(), paginacao, deputados.getDados().size());
	}

	public ResultadoDTO<DeputadoDTO> recuperarDadosDoDeputado(Long id) {
		ResultadoDTO<DeputadoDTO> deputado = this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/deputados/{id}")
						.build(id))
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<ResultadoDTO<DeputadoDTO>>() {})
				.block();
		
		return deputado;
	}
	
	public ResultadoListaDTO<DespesasDeputadoDTO> recuperarDespesasDoDeputado(Long id) {
		ParameterizedTypeReference<ResultadoListaDTO<DespesasDeputadoDTO>> type = new ParameterizedTypeReference<ResultadoListaDTO<DespesasDeputadoDTO>>() {};
		
		ResultadoListaDTO<DespesasDeputadoDTO> despesas = this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/deputados/{id}/despesas")
						.build(id))
				.retrieve()
				.bodyToMono(type)
				.block();

		return despesas;
	}

}
