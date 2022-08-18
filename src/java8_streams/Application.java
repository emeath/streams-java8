package java8_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java8_streams.entidades.Atributo;
import java8_streams.entidades.Item;

// https://docs.oracle.com/javase/8/docs/api/ -> Stream
// https://docs.oracle.com/javase/8/docs/api/ -> 

public class Application {

	public static void main(String[] args) {
		
		Item mantoDaInteligencia = new Item("Manto da Inteligência", "Um lindo manto de safira usado por várias gerações de rainhas.", 140);
		mantoDaInteligencia.addAtributo(new Atributo(3.0, "Inteligência"));
		
		Item manoplasDaForca = new Item("Manoplas da Força", "Luvas de couro ornamentadas que adicionam força bruta.", 135);
		manoplasDaForca.addAtributo(new Atributo(3.0, "Força"));
		
		Item galhoDeFerro = new Item("Galho de Ferro", "Um galho aparentemente ordinário, com habilidades de ferro outorgadas ao seu usuário", 50);
		galhoDeFerro.addAtributo(new Atributo(1.0, "Força")).addAtributo(new Atributo(1.0, "Agilidade")).addAtributo(new Atributo(1.0, "Inteligência"));
		
		Item anelDaAlma = new Item("Anel da Alma", "Um anel que se alimenta das almas daqueles que o usa", 770);
		anelDaAlma.addAtributo(new Atributo(6.0, "Força"));
		
		int PRECO_FILTRO = 500;
		
		List<Item> inventario = new ArrayList<>(Arrays.asList(anelDaAlma, manoplasDaForca, galhoDeFerro, galhoDeFerro, mantoDaInteligencia));
		
		usandoStream(inventario, PRECO_FILTRO);
		
		usandoFormaRaiz(inventario, PRECO_FILTRO);
	}
	
	private static void usandoStream(List<Item> inventario, int PRECO_FILTRO) {
		System.out.println("============================");
		System.out.println("======= FORMA STREAM =======");
		System.out.println("============================");
		System.out.println("======= Exibindo nome de itens usando função lambda =======");
		inventario.forEach(it -> System.out.println(it.getNome()));

		System.out.println("======= Exibindo descrição de itens filtrados por preço usando STREAM Java 8 =======");
		Set<Item> itensFiltradosPorPreco = inventario.stream().filter(item -> item.getCusto() > PRECO_FILTRO).collect(Collectors.toSet());
		itensFiltradosPorPreco.forEach(item -> System.out.println(item.getDescricao()));
				
		System.out.println("======= Exibindo nome de itens filtrados por tipo de atributo usando STREAM Java 8 =======");
		inventario.forEach(item -> {
			List<Atributo> atributos = item.getAtributos().stream().filter(atributo -> atributo.getDescricao().equals("Inteligência")).collect(Collectors.toList());
			if (!atributos.isEmpty()) {
				System.out.println(item.getNome());
			}
		});
	}
	
	private static void usandoFormaRaiz(List<Item> inventario, int PRECO_FILTRO) {
		System.out.println("==========================");
		System.out.println("======= FORMA RAIZ =======");
		System.out.println("==========================");
		System.out.println("======= Exibindo nome de itens usando forma raiz =======");
		for (Item item : inventario) {
			System.out.println(item.getNome());
		}
		
		System.out.println("======= Exibindo descrição de itens filtrados por preço usando forma raiz =======");
		Set<Item> itensFiltradosPorPreco = new HashSet<>();
		for (Item item : inventario) {
			if (item.getCusto() > PRECO_FILTRO) {
				itensFiltradosPorPreco.add(item);
			}
		}
		
		for (Item item : itensFiltradosPorPreco) {
			System.out.println(item.getDescricao());
		}
		
		System.out.println("======= Exibindo nome de itens filtrados por tipo de atributo usando forma raiz =======");
		for (Item item : inventario) {
			List<Atributo> atributos = new ArrayList<>();
			for (Atributo atributo : item.getAtributos()) {
				if (atributo.getDescricao().equals("Inteligência")) {
					atributos.add(atributo);
				}
			}
			if(!atributos.isEmpty()) {
				System.out.println(item.getNome());
			}
		}
		
	}
	
}
