package br.com.notebooks.cadastroNotebooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.notebooks.cadastroNotebooks.principal.Principal;
import br.com.notebooks.cadastroNotebooks.repositorio.Repositorio;

@SpringBootApplication
public class CadastroNotebooksApplication implements CommandLineRunner{
@Autowired
private Repositorio repositorio;
	public static void main(String[] args) {
		SpringApplication.run(CadastroNotebooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		
		principal.menu();		
	}
}