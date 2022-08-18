package java8_streams.entidades;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private String nome;
	private String descricao;
	private Integer custo;

	private Set<Atributo> atributos = new HashSet<>();

	public Item(String nome, String descricao, Integer custo) {
		this.nome = nome;
		this.descricao = descricao;
		this.custo = custo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCusto() {
		return custo;
	}

	public void setNivelRequerido(Integer nivelRequerido) {
		this.custo = nivelRequerido;
	}

	public Set<Atributo> getAtributos() {
		return atributos;
	}

	public Item addAtributo(Atributo atributo) {
		this.atributos.add(atributo);
		return this;
	}

}
