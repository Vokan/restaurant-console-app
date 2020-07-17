package dev;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.ihm.Menu;

	public class AppSpringJava {
	
			// Création du contexte Spring à partir d'une configuration Java
			public static void main(String[] args) {
        
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			
			
			context.getEnvironment().setActiveProfiles("platServ2", "jpa");
			
			context.register(AppConfig.class);
			context.refresh();
			
			// récupération du bean Menu
			Menu menu = context.getBean(Menu.class); menu.afficher();
			
			// fermeture du Scanner
			context.getBean(Scanner.class).close(); // fermeture du contexte Spring
			
			context.close(); 
	}
}
