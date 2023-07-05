package br.com.rsds.agendaconsultasclinicasspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
