package br.com.rsds.agendaconsultasclinicasspring.converters;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusConsulta;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConsultaConverter implements AttributeConverter<StatusConsulta, String> {

	@Override
	public String convertToDatabaseColumn(StatusConsulta attribute) {
		return attribute.getValue();
	}

	@Override
	public StatusConsulta convertToEntityAttribute(String dbData) {
		return null;
	}

}
