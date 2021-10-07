package com.example.m2testinganimals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingAnimalsApplication implements CommandLineRunner {

	@Autowired
	AnimalsRepository AnimalsRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingAnimalsApplication.class, args);
		//Clase identificador = new Clase();

	}


	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Bienvenido a la BBDD del zoológico. Que operación desea realizar: ");
			System.out.println("=================================================================");
			System.out.println("1) - Ver todos los animales existentes");
			System.out.println("2) - Ver un animal por ID");


			int option = scanner.nextInt();

			if (option == 1){
				List<Animals> animals = AnimalsRepository.findAll();
				if (animals.isEmpty()){
					System.out.println("El zoológico está vacío");
				} else {
					System.out.println(animals);
				}
			}
		}


		//CRUD;
		long totalAnimales = AnimalsRepository.count();
		System.out.println("El número total de animales es: " + totalAnimales);

		//1. Guardar animal
		Animals animal = new Animals("Crocodylidae", "Dundee", "Macho", "1985/02/11", 152.44);
		Animals animal2 = new Animals("Laridae", "Wingull", "Macho", "2008/02/11", 4.99);
		Animals animal3 = new Animals("Ailuropoda Melanoleuca", "Bao Bao", "Hembra", "2003/15/07",  135.00);
		Animals animal4 = new Animals("Felis Catus", "Elena", "Hembra", "2020/15/07",  15.00);
		AnimalsRepository.save(animal);
		AnimalsRepository.save(animal2);
		AnimalsRepository.save(animal3);
		AnimalsRepository.save(animal4);

		totalAnimales = AnimalsRepository.count();
		System.out.println("El número total de animales es: " + totalAnimales);

		//2. Recuperar los animales de la tabla
		List<Animals> animals = AnimalsRepository.findAll();

		//3. Actualizar
		

		//4. Borrar


	}
}
