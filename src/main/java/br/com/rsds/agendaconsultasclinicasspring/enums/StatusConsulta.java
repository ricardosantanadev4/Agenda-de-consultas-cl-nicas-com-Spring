package br.com.rsds.agendaconsultasclinicasspring.enums;

public enum StatusConsulta {
	ABERTO("Agendado"), CONCLUIDO("Concluido");

	private String value;

	StatusConsulta(String value) {
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
