package com.example.m2testinganimals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingAnimalsApplication implements CommandLineRunner {

	@Autowired
	AnimalsRepository AnimalsRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingAnimalsApplication.class, args);

	}


	public void mostrarMenu(){
		System.out.println("Bienvenido a la BBDD del zoológico. Que operación desea realizar: ");
		System.out.println("=================================================================");
		System.out.println("0) - Salir de la BBDD");
		System.out.println("1) - Ver todos los animales existentes");
		System.out.println("2) - Ver un animal por ID");
		System.out.println("3) - Añadir un animal");
		System.out.println("4) - Modificar y/o actualizar un animal");
		System.out.println("5) - Borrar un animal por ID");
		System.out.println("6) - Borrar todos los registros");
		System.out.println("7) - Contar cuántos registros hay en la BBDD");
		System.out.println("8) - Filtrar por especie ");
		System.out.println("9) - Filtrar por especie y nombre");
	}

	@Override
	public void run(String... args) throws Exception {
		//Esta BBDD es de prueba
		Scanner scanner = new Scanner(System.in);
		while (true) {

			mostrarMenu();
			try {

				int option = scanner.nextInt();

				if (option == 0) {
					System.out.println("Hasta luego !!");
					break;

				} else if (option == 1) {
					List<Animals> animals = AnimalsRepository.findAll();
					if (animals.isEmpty()) {
						System.out.println("El zoológico está vacío");
					} else {
						System.out.println(animals);
					}
				} else if (option == 2) {
					System.out.println("Introduce el ID del animal: ");
					Long id = scanner.nextLong();
					Optional<Animals> animalsOptional = AnimalsRepository.findById(id);
					if (animalsOptional.isPresent()) {
						Animals animals = animalsOptional.get();
						System.out.println(animals);
					} else {
						System.out.println("El ID solicitado no consta en nuestra BBDD");
					}

				} else if (option == 3) {
					System.out.println("Introduce la especie: ");
					String especie = scanner.next();

					System.out.println("Introduce el nombre del animal: ");
					String nombre = scanner.next();

					System.out.println("Introduce el sexo: ");
					String sexo = scanner.next();

					System.out.println("Fecha de nacimiento: ");
					String FN = scanner.next();

					System.out.println("Introduce el peso: ");
					double peso = scanner.nextDouble();

					Animals animal = new Animals(null, especie, nombre, sexo, FN, peso);
					AnimalsRepository.save(animal);
					System.out.println("Animal añadido con éxito");

				} else if (option == 4) {
					System.out.println("Introduce el ID del animal a modificar");
					Long id = scanner.nextLong();


				} else if (option == 5) {
					System.out.println("Introduce el ID del animal a borrar");
					Long id = scanner.nextLong();
					boolean existe = AnimalsRepository.existsById(id);

					if (!existe) {
						System.out.println("ID inexistente");
					} else {
						AnimalsRepository.deleteById(id);
						System.out.println("Animal dado de baja del zoo ");
					}

				} else if (option == 6) {

					System.out.println("Estás seguro/a de borrar los registros ? ");
					boolean confirm = scanner.nextBoolean();

					if (!confirm) continue;

					AnimalsRepository.deleteAll();
					System.out.println("Registros borrados correctamente");

				} else if (option == 7) {
					long totalAnimales = AnimalsRepository.count();
					System.out.println("El número total de animales es: " + totalAnimales);

				} else if (option == 8){
					System.out.println("Especie a buscar: ");
					String especie = scanner.next();
					List<Animals> animal = AnimalsRepository.findByEspecie(especie);
					for (Animals animals : animal){
						System.out.println(animals);

					}
					System.out.println(animal);

				} else if (option == 9){
					System.out.println("Especie a buscar: ");
					String especie = scanner.next();

					System.out.println("Nombre del animal: ");
					String nombre = scanner.next();

					List<Animals> animal = AnimalsRepository.findByEspecieAndName(especie, nombre);
					for (Animals animals: animal){
						System.out.println(animals);
					}
				}

			}catch(Exception e){
				e.printStackTrace();
			}

			//CRUD;
			long totalAnimales = AnimalsRepository.count();
			System.out.println("El número total de animales es: " + totalAnimales);

		//1. Guardar animal
		Animals animal = new Animals(null, "Crocodylidae", "Dundee", "Macho", "1985/02/11", 152.44);
		Animals animal2 = new Animals(null, "Laridae", "Wingull", "Macho", "2008/02/11", 4.99);
		Animals animal3 = new Animals(null, "Ailuropoda Melanoleuca", "Bao Bao", "Hembra", "2003/15/07",  135.00);
		Animals animal4 = new Animals(null, "Felis Catus", "Elena", "Hembra", "2020/15/07",  15.00);
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
}