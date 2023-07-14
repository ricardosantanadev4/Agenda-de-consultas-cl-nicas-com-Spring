package br.com.rsds.agendaconsultasclinicasspring.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
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

	@NotBlank
	@NotNull
	@Length(min = 8, max = 13)
	@Column(nullable = false, length = 13)
	private String especialidade;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalDate dataDisponivel;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalTime horarioDisponivel;

	@NotBlank
	@NotNull
	@Length(min = 10, max = 12)
	@Column(nullable = false, length = 12)
	private String status = "INDISPONIVEL";

	@OneToMany(mappedBy = ("especialista"))
	@NotNull
	@Column(nullable = false)
	private List<Consulta> consulta = new ArrayList<>();
}