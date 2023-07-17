package br.com.rsds.agendaconsultasclinicasspring.enums;

public enum EspecialidadeEspecilista {
	CARDIOLOGISTA("Cardiologista"), NEUROLOGISTA("Neurologista"), PEDIATRA("Pediatra"), CLINICOGERAL("Crilinicogeral"),
	ORTOPEDISTA("Ortepedista");

	private String value;

	EspecialidadeEspecilista(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
