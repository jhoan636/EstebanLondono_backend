package com.customer_service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication()
public class CustomerServiceApplication {
	static {
		try {
			Dotenv dotenv = Dotenv.load();

			dotenv.entries().forEach(entry -> {
				String key = entry.getKey();
				String value = entry.getValue();
				if (value != null) {
					System.setProperty(key, value);
				}
			});
		} catch (Exception e) {
			System.out.println("No se pudo cargar el archivo .env: "+ e);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
