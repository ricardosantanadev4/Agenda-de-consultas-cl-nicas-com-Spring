package br.com.rsds.agendaconsultasclinicasspring.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import br.com.rsds.agendaconsultasclinicasspring.enums.EspecialidadeEspecilista;
import br.com.rsds.agendaconsultasclinicasspring.enums.StatusEspecialista;
import br.com.rsds.agendaconsultasclinicasspring.enums.converters.EspecialidadeEspecialistaConverter;
import br.com.rsds.agendaconsultasclinicasspring.enums.converters.StatusEspecialistaConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Especialista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	@Length(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String name;

	@NotNull
	@Column(nullable = false, length = 13)
	@Convert(converter = EspecialidadeEspecialistaConverter.class)
	private EspecialidadeEspecilista especialidade;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalDate dataDisponivel;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalTime horarioDisponivel;

	@NotNull
	@Column(nullable = false, length = 12)
	@Convert(converter = StatusEspecialistaConverter.class)
	private StatusEspecialista status = StatusEspecialista.INDISPONIVEL;

	@OneToMany(mappedBy = ("especialista"))
	@NotNull
	@Column(nullable = false)
	private List<Consulta> consulta = new ArrayList<>();
}