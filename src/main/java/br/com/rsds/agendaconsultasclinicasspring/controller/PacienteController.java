package br.com.rsds.agendaconsultasclinicasspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.agendaconsultasclinicasspring.dto.PacienteDTO;
import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;
import br.com.rsds.agendaconsultasclinicasspring.service.PacienteService;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
	private final PacienteService pacienteService;

	PacienteController(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	@GetMapping
	public List<PacienteDTO> list() {
		return pacienteService.list();
	}
}
