package br.com.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");

	private int codigo;

	private String descrição;

	private EstadoPagamento(int codigo, String descrição) {
		this.codigo = codigo;
		this.descrição = descrição;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescrição() {
		return descrição;
	}

	public static EstadoPagamento toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		for (EstadoPagamento tipo : EstadoPagamento.values()) {

			if (codigo.equals(tipo.getCodigo())) {
				return tipo;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
