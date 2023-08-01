package br.com.rsds.agendaconsultasclinicasspring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	@Length(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String name;

	@NotNull
	@Length(min = 7, max = 7)
	@Column(nullable = false, length = 7)
	private String rg;

	@NotBlank
	@NotNull
	@Length(min = 11, max = 11)
	@Column(nullable = false, length = 11)
	private String telefone;

	@NotNull
	@Column(nullable = false, length = 10)
	private LocalDate dataNascimento;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "paciente")
	@Column(nullable = false)
	private List<Consulta> consulta = new ArrayList<>();
}
