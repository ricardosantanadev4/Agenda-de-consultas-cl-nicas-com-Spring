package br.com.rsds.agendaconsultasclinicasspring.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.agendaconsultasclinicasspring.enums.EspecialidadeEspecilista;
import jakarta.persistence.AttributeConverter;

public class EspecialidadeEspecialistaConverter implements AttributeConverter<EspecialidadeEspecilista, String> {

	@Override
	public String convertToDatabaseColumn(EspecialidadeEspecilista attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public EspecialidadeEspecilista convertToEntityAttribute(String dbData) {
		return Stream.of(EspecialidadeEspecilista.values()).filter(e -> e.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
