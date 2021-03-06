package com.aps.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aps.api.model.comum.ParametrosConsulta;
import com.aps.api.model.comum.ResultadoDTO;
import com.aps.api.model.comum.ResultadoListaDTO;
import com.aps.api.model.dtos.DeputadoDTO;
import com.aps.api.model.dtos.DeputadoResumidoDTO;
import com.aps.api.model.dtos.DespesasDeputadoDTO;
import com.aps.api.model.dtos.LegislaturaDTO;

@Service
public class IntegracaoDadosAbertosService {

	@Autowired
	private WebClient webClient;

	public PageImpl<DeputadoResumidoDTO> recuperarDeputados(ParametrosConsulta params) {
		ParameterizedTypeReference<ResultadoListaDTO<DeputadoResumidoDTO>> type = new ParameterizedTypeReference<ResultadoListaDTO<DeputadoResumidoDTO>>() {};
		
		ResultadoListaDTO<DeputadoResumidoDTO> deputados = new ResultadoListaDTO<DeputadoResumidoDTO>();
		deputados.setDados(new ArrayList<DeputadoResumidoDTO>());
		int contador = 0;
		for (int i = 0; i == deputados.getDados().size(); i+=500) { // loop para garantir que todos os dados sejam recuperados mesmo com o limite imposto na api
			contador++;
			params.setPagina(contador);
			deputados.getDados().addAll(this.webClient.get()
					.uri(uriBuilder -> uriBuilder
							.path("/deputados/")
							.queryParamIfPresent("id", Optional.ofNullable(params.getId()))
							.queryParamIfPresent("nome", Optional.ofNullable(params.getNome()))
							.queryParamIfPresent("idLegislatura", Optional.ofNullable(params.getIdLegislatura()))
							.queryParamIfPresent("siglaUf", Optional.ofNullable(params.getSiglaUf()))
							.queryParamIfPresent("siglaPartido", Optional.ofNullable(params.getSiglaPartido()))
							.queryParamIfPresent("siglaSexo", Optional.ofNullable(params.getSiglaSexo()))
							.queryParamIfPresent("pagina", Optional.ofNullable(params.getPagina()))
							.queryParamIfPresent("itens", Optional.ofNullable(params.getItens()))
							.queryParam("ordem", "ASC")
							.queryParam("ordenarPor", "nome")
							.build())
					.retrieve()
					.bodyToMono(type)
					.block().getDados());
		}
		
		Pageable paginacao = PageRequest.of(params.getPagina(), params.getItens());
		return new PageImpl<DeputadoResumidoDTO>(deputados.getDados(), paginacao, deputados.getDados().size());
	}

	public DeputadoDTO recuperarDeputadoDetalhado(Long id) {
		ResultadoDTO<DeputadoDTO> deputado = this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/deputados/{id}")
						.build(id))
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<ResultadoDTO<DeputadoDTO>>() {})
				.block();
		
		return deputado.getDados();
	}
	
	public ResultadoListaDTO<DespesasDeputadoDTO> recuperarDespesasDoDeputado(ParametrosConsulta params) {
		ParameterizedTypeReference<ResultadoListaDTO<DespesasDeputadoDTO>> type = new ParameterizedTypeReference<ResultadoListaDTO<DespesasDeputadoDTO>>() {};
		
		ResultadoListaDTO<DespesasDeputadoDTO> despesas = new ResultadoListaDTO<DespesasDeputadoDTO>();
		despesas.setDados(new ArrayList<DespesasDeputadoDTO>());
		int contador = 0;
		for (int i = 0; i == despesas.getDados().size(); i+=100) { // loop para garantir que todos os dados sejam recuperados mesmo com o limite imposto na api
			contador++;
			params.setPagina(contador);
			despesas.getDados().addAll(this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/deputados/{id}/despesas")
						.queryParamIfPresent("idLegislatura", Optional.ofNullable(params.getIdLegislatura()))
						.queryParamIfPresent("ano", Optional.ofNullable(params.getAno()))
						.queryParamIfPresent("mes", Optional.ofNullable(params.getMes()))
						.queryParamIfPresent("cnpjCpfFornecedor", Optional.ofNullable(params.getCnpjCpfFornecedor()))
						.queryParamIfPresent("pagina", Optional.ofNullable(params.getPagina()))
						.queryParamIfPresent("itens", Optional.ofNullable(params.getItens()))
						.queryParam("ordem", "DESC")
						.queryParam("ordenarPor", "dataDocumento")
						.build(params.getId()))
				.retrieve()
				.bodyToMono(type)
				.block().getDados());
		}

		return despesas;
	}
	
	public LegislaturaDTO recuperarUltimaLegislatura() {
		ResultadoListaDTO<LegislaturaDTO> legislatura = this.webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/legislaturas")
						.queryParam("pagina", 1)
						.queryParam("itens", 1)
						.queryParam("ordem", "DESC")
						.queryParam("ordenarPor", "id")
						.build())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<ResultadoListaDTO<LegislaturaDTO>>() {})
				.block();
		
		return legislatura.getDados().get(0);
	}
	
}
