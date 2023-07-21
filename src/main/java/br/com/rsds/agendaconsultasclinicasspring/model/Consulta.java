package br.com.rsds.agendaconsultasclinicasspring.model;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusConsulta;
import br.com.rsds.agendaconsultasclinicasspring.enums.converters.StatusConsultaConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente pacientes;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "especialista_id", nullable = false)
	private Especialista especialista;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalDate dataCriacao;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalDate dataAtendimento;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalTime horarioAtendimento;

	@NotNull
	@Column(nullable = false, length = 9)
	@Convert(converter = StatusConsultaConverter.class)
	private StatusConsulta statusConsulta = StatusConsulta.AGENDADO;
}
