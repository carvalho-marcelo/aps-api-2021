package com.aps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.api.model.dtos.LegislaturaDTO;
import com.aps.api.service.LegislaturaService;

@RestController
@RequestMapping(value = "/legislatura")
public class LegislaturaController {

	@Autowired
	private LegislaturaService service;
	
	@GetMapping(value = "/ultimo-registro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LegislaturaDTO> recuperarUltimaLegislatura() {
		return ResponseEntity.ok(service.recuperarUltimaLegislatura());
	}
	
}
