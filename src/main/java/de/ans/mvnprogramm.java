package de.ans;

import java.util.Scanner;


public class mvnprogramm {


	 /**
    * Eine Funktion, die eine Eingabe einliesst und ausgibt.
    */
	public static void main(String[] args) {
		
		//Ein Programm, welches ein Text einließt und mit Großbuchstaben wieder ausgibt.
		Scanner scanner = new Scanner(System.in);
		String auswahl = scanner.next().toUpperCase();
		System.out.println(auswahl);
		scanner.close();
		
	}
}
