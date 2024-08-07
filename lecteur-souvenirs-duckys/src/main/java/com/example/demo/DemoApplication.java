package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	private static final List<String> PHRASES = List.of("Il fait chaud ici", "Coin coin", "Il existe un duckydex","Chaque ducky a des attaques differentes", "Coin coin coin", "J'ai faim", "J'ai soif");

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		Random random = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^()_+-=[]{}<>/?`~";
		while (true) {
			System.out.println("En attente de branchement d'un ducky ...");
			Scanner readinput = new Scanner(System.in);
			var enterkey = readinput.nextLine();
			for (int i = 0; i < 100*75; i++) {
				// Generate a random character from the characters string
				char randomChar = characters.charAt(random.nextInt(characters.length()));
				// Print the random character
				System.out.print(randomChar);

				// Add a small delay to simulate typing

				// Print a newline character occasionally to create a better effect
				if (random.nextInt(100) < 1) {  // 5% chance to break the line
					Thread.sleep(100);
					System.out.println();
				}
			}
			System.out.println();
			System.out.println();
			System.out.println(rot13(PHRASES.get(new Random().nextInt(PHRASES.size()))));
		}

	}

	public static String rot13(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if       (c >= 'a' && c <= 'm') c += 13;
			else if  (c >= 'A' && c <= 'M') c += 13;
			else if  (c >= 'n' && c <= 'z') c -= 13;
			else if  (c >= 'N' && c <= 'Z') c -= 13;
			sb.append(c);
		}
		return sb.toString();
	}
}
