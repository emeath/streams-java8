package java8_streams.entidades;

public class Atributo {

	private Double valor;
	private String descricao;

	public Atributo(Double valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
