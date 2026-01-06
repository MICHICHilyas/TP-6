package org.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application de gestion des apprenants.
 * Cette application utilise Spring Boot pour gérer les étudiants
 * avec une API REST documentée via Swagger/OpenAPI.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@SpringBootApplication
public class StudentManagementApplication {

	/**
	 * Point d'entrée principal de l'application.
	 * Lance le serveur Spring Boot embarqué.
	 * 
	 * @param args les arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
