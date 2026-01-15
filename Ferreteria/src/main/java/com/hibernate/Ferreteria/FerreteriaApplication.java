package com.hibernate.Ferreteria;

import com.hibernate.Ferreteria.Entity.Articulos;
import com.hibernate.Ferreteria.Repositorio.Repo_Articulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FerreteriaApplication implements CommandLineRunner {

    @Autowired
    private Repo_Articulos repositorio;

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicacion iniciada correctamente ");
        List<Articulos> articulos=repositorio.findAll();
        articulos.stream().forEach(System.out::println);
    }
}
