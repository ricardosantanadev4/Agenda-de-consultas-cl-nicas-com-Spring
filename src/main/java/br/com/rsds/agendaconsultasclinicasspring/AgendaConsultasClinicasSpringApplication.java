package br.com.rsds.agendaconsultasclinicasspring;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.agendaconsultasclinicasspring.enums.EspecialidadeEspecilista;
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

			final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

			Especialista especialista = new Especialista();
			especialista.setName("Dotor Alexandre");
			especialista.setEspecialidade(EspecialidadeEspecilista.CARDIOLOGISTA);
			especialista.setDataDisponivel(LocalDate.parse("31/07/2023", dateFormatter));
			especialista.setHorarioDisponivel(LocalTime.parse("13:30:00", timeFormatter));

			Paciente paciente = new Paciente();
			paciente.setName("Ricardo");
			paciente.setRg("7777777");
			paciente.setTelefone("99999999999");
			paciente.setDataNascimento(LocalDate.parse("18/12/1989", dateFormatter));

			Consulta consulta = new Consulta();
			consulta.setPacientes(paciente);
			consulta.setEspecialista(especialista);
			consulta.setDataCriacao(LocalDate.now());
			consulta.setDataAtendimento(especialista.getDataDisponivel());
			consulta.setHorarioAtendimento(especialista.getHorarioDisponivel());

			especialista.getConsulta().add(consulta);

			paciente.getConsulta().add(consulta);
			pacienteRepository.save(paciente);
		};
	}
}
