package br.com.rsds.agendaconsultasclinicasspring.converters;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusEspecialista;
import jakarta.persistence.AttributeConverter;

public class StatusEspecialistaConverter implements AttributeConverter<StatusEspecialista, String>{

	@Override
	public String convertToDatabaseColumn(StatusEspecialista attribute) {
		return attribute.getValue();
	}

	@Override
	public StatusEspecialista convertToEntityAttribute(String dbData) {
		return null;
	}

}
