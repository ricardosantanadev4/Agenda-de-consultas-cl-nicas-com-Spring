package br.com.rsds.agendaconsultasclinicasspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.agendaconsultasclinicasspring.model.Consulta;
import br.com.rsds.agendaconsultasclinicasspring.repository.ConsultaRepository;

@RestController
@RequestMapping("api/consulta")
public class ConsultaController {
	
	private final ConsultaRepository consultaRepository;
	
	ConsultaController(ConsultaRepository consultaRepository ){
		this.consultaRepository = consultaRepository;
	}
	
	@GetMapping
	public List<Consulta> list(){
		return consultaRepository.findAll();
	}
	
}
