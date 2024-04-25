package br.com.notebooks.cadastroNotebooks.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.notebooks.cadastroNotebooks.model.MarcasNotebooks;
import br.com.notebooks.cadastroNotebooks.model.Notebook;
import br.com.notebooks.cadastroNotebooks.repositorio.Repositorio;

public class Principal {
	private Scanner sc = new Scanner(System.in);
	private int escolha = -1;
	private Repositorio repositorio;
	private List<Notebook> note = new ArrayList<>();
	private MarcasNotebooks marca2;
	
	public Principal(Repositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	public void menu() {
		while(escolha != 0 ) {
		
		System.out.println("Digite o que deseja fazer"
				+ " \n1- Cadastrar Notebook"
				+ " \n2- Visualizar Notebooks existentes"
				+ " \n0- Sair");
		escolha = sc.nextInt();
		sc.nextLine();
		switch(escolha) {
		case 1:
			cadastraNotebook();
			break;
		case 2:
			exibeNotebooks();
			break;
		case 0:
			System.out.println("**********Programa encerrado**********");
			break;
		default:
			System.out.println("Codigo invalido");
		}
		this.divide();
		}
	}
	public void cadastraNotebook() {
		System.out.println("Digite o modelo do notebook -> ");
		String modelo = sc.nextLine();
		
		System.out.println("Digite o numero de serie do equipamento -> ");
		String numSerie = sc.nextLine();
		
		
		try {//caso não seja digitado uma das marcas existentes o programa impede que seja gravado a informação
			System.out.println("Digite qual a marca do notebook, Dell, Hp, LeNovo, Acer, Positivo");
			var marca = sc.nextLine();
			MarcasNotebooks marca2 = MarcasNotebooks.valueOf(marca.toUpperCase());
			
			Notebook notebook = new Notebook(modelo, numSerie, marca2);
			repositorio.save(notebook);
		}catch(IllegalArgumentException e) {
			System.out.println("Marca invalida");
		}
		
		
		
	}
	public void exibeNotebooks() {
		  note =  repositorio.findAll();
		  
		  note.forEach(System.out::println);
	}
	
	public void divide() {
		System.out.println("*************************************************************");
	}
}