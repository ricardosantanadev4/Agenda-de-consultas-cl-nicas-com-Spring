package br.com.rsds.agendaconsultasclinicasspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.agendaconsultasclinicasspring.model.Consulta;
import br.com.rsds.agendaconsultasclinicasspring.model.Especialista;
import br.com.rsds.agendaconsultasclinicasspring.model.Paciente;
import br.com.rsds.agendaconsultasclinicasspring.repository.PacienteRepository;

@SpringBootApplication
public class AgendaConsultasClinicasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaConsultasClinicasSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(PacienteRepository pacienteRepository) {
		return args -> {
			pacienteRepository.deleteAll();

			Especialista especialista = new Especialista();

			Paciente paciente = new Paciente();

			Consulta consulta = new Consulta();
			consulta.setPacientes(paciente);
			consulta.setEspecialista(especialista);

			paciente.getConsulta().add(consulta);
			pacienteRepository.save(paciente);
		};
	}
}
