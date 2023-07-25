package br.com.rsds.agendaconsultasclinicasspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;
import br.com.rsds.agendaconsultasclinicasspring.repository.PacienteRepository;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

	private final PacienteRepository pacienteRepository;

	PacienteController(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}
	
	@GetMapping
	public List<Paciente> list(){
		return pacienteRepository.findAll();
	}
}
