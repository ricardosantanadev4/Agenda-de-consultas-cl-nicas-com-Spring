package br.com.rsds.agendaconsultasclinicasspring.enums;

public enum StatusEspecialista {
	LIVRE("Disnponivel"), AGENDADO("Indisponivel");

	private String value;

	StatusEspecialista(String value) {
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
