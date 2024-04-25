package br.com.notebooks.cadastroNotebooks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notebook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String modelo;
	
	@Column(unique = true)
	private String numSerie;
	
	@Enumerated(EnumType.STRING)
	private MarcasNotebooks marca;
	
	public Notebook() {
		
	}
	public Notebook(String modelo, String numSerie, MarcasNotebooks marca) {
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public MarcasNotebooks getMarca() {
		return marca;
	}
	public void setMarca(MarcasNotebooks marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Notebook [Marca = " + marca + ", Modelo = " + modelo + ", Numero de serie = " + numSerie + "]";
	}
}