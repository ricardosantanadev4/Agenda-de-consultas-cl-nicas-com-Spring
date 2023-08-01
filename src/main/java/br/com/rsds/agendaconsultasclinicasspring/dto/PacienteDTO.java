package br.com.rsds.agendaconsultasclinicasspring.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteDTO(Long id,

		@NotBlank @NotNull @Length(min = 1, max = 100) String name,

		@NotNull @Length(min = 7, max = 7) String rg,

		@NotBlank @NotNull @Length(min = 11, max = 11) String telefone,

		@NotNull LocalDate dataNascimento,

		@NotNull List<ConsultaDTO> consulta) {

}