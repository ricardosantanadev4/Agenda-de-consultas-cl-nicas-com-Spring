package br.com.rsds.agendaconsultasclinicasspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.rsds.agendaconsultasclinicasspring.dto.ConsultaDTO;
import br.com.rsds.agendaconsultasclinicasspring.dto.PacienteDTO;
import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;

@Component
public class PacienteMapper {

	public PacienteDTO toDTO(Paciente p) {

		List<ConsultaDTO> listConsultaDTO = p
				.getConsulta().stream().map(c -> new ConsultaDTO(c.getId(), c.getEspecialista(), c.getDataCriacao(),
						c.getDataAtendimento(), c.getHorarioAtendimento(), c.getStatusConsulta()))
				.collect(Collectors.toList());

		return new PacienteDTO(p.getId(), p.getName(), p.getRg(), p.getTelefone(), p.getDataNascimento(),
				listConsultaDTO);
	}
}