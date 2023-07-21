package br.com.rsds.agendaconsultasclinicasspring.enums.converters;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusConsulta;
import jakarta.persistence.AttributeConverter;

public class StatusConsultaConverter implements AttributeConverter<StatusConsulta, String> {

	@Override
	public String convertToDatabaseColumn(StatusConsulta attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public StatusConsulta convertToEntityAttribute(String dbData) {
		return null;
	}

}
