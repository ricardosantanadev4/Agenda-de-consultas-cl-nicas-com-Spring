package br.com.rsds.agendaconsultasclinicasspring.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.agendaconsultasclinicasspring.enums.StatusEspecialista;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEspecialistaConverter implements AttributeConverter<StatusEspecialista, String> {

	@Override
	public String convertToDatabaseColumn(StatusEspecialista attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public StatusEspecialista convertToEntityAttribute(String dbData) {
		return Stream.of(StatusEspecialista.values()).filter(s -> s.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
