package br.com.rsds.agendaconsultasclinicasspring.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusConsulta;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
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
		return Stream.of(StatusConsulta.values()).filter(s -> s.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
