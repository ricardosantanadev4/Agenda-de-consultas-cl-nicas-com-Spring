package br.com.rsds.agendaconsultasclinicasspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rsds.agendaconsultasclinicasspring.dto.PacienteDTO;
import br.com.rsds.agendaconsultasclinicasspring.dto.mapper.PacienteMapper;
import br.com.rsds.agendaconsultasclinicasspring.repository.PacienteRepository;

@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	private final PacienteMapper pacienteMapper;

	PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
		this.pacienteRepository = pacienteRepository;
		this.pacienteMapper = pacienteMapper;
	}

	public List<PacienteDTO> list() {
		return pacienteRepository.findAll().stream().map(p -> pacienteMapper.toDTO(p)).collect(Collectors.toList());
	}
}
