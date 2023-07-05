package br.com.rsds.agendaconsultasclinicasspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rsds.agendaconsultasclinicasspring.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
