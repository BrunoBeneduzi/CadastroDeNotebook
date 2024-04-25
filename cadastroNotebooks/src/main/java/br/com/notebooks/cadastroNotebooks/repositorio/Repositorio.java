package br.com.notebooks.cadastroNotebooks.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.notebooks.cadastroNotebooks.model.Notebook;

public interface Repositorio extends JpaRepository<Notebook, Long>{

}