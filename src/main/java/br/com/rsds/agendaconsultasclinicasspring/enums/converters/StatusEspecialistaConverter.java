package br.com.rsds.agendaconsultasclinicasspring.enums.converters;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusEspecialista;
import jakarta.persistence.AttributeConverter;

public class StatusEspecialistaConverter implements AttributeConverter<StatusEspecialista, String> {

	@Override
	public String convertToDatabaseColumn(StatusEspecialista attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public StatusEspecialista convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return null;
	}

}
