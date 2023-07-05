package br.com.rsds.agendaconsultasclinicasspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.agendaconsultasclinicasspring.model.Consulta;
import br.com.rsds.agendaconsultasclinicasspring.model.Especialista;
import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;
import br.com.rsds.agendaconsultasclinicasspring.repository.ConsultaRepository;

@SpringBootApplication
public class AgendaConsultasClinicasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaConsultasClinicasSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(ConsultaRepository consultaRepository) {
		return args -> {
			consultaRepository.deleteAll();

			Paciente paciente = new Paciente();

			Consulta consulta = new Consulta();
			consulta.setPaciente(paciente);

			Especialista especialista = new Especialista();
			especialista.getConsulta().add(consulta);

			consulta.setEspecialista(especialista);

			paciente.getConsulta().add(consulta);

			consultaRepository.save(consulta);
		};
	}
}
