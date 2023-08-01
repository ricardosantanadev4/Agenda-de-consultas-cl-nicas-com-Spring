package br.com.rsds.agendaconsultasclinicasspring.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusConsulta;
import br.com.rsds.agendaconsultasclinicasspring.model.Especialista;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsultaDTO(Long id,

//		se estamos consultadondo pelo paciente nao ha necessidade de trazer os dados do paciente dentro da lista
//      na relacao Paciente Consulta adiciona esse codigo ou remove o atributo paciente 
//		@JsonProperty(access = Access.WRITE_ONLY) 
//      @NotNull Paciente paciente,

		@NotNull Especialista especialista,

		@NotNull LocalDate dataCriacao,

		@NotNull LocalDate dataAtendimento,

		@NotNull LocalTime horarioAtendimento,

		@NotNull @Pattern(regexp = "Agendado|Concluido") StatusConsulta statusConsulta) {

}
