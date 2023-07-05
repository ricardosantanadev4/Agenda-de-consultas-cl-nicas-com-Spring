package br.com.rsds.agendaconsultasclinicasspring.dto;

import java.time.LocalDate;

public record PacienteDTO(
		String nome,

		String rg,

		String telefone,

		 LocalDate dataNascimento
		) {
	
}
