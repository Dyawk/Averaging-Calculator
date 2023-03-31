package fr.dyawk.averagecalc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static boolean HasFinished;
	static float[] Average = new float[200];
	static int howlong = 0;
	static String ALL_VALUES = "";
	
	// ---- Runtime functions ---- \\
	
	public static void main(String[] args) {
		clearConsole();
		HasFinished = false;
		howlong = 0;
		WelcomeMessage(0);

		while(!HasFinished) {
			AskValue();
		}
	}
	
	static void WelcomeMessage(int Which) {
		System.out.println("--- CALCULER UNE MOYENNE --- \n");
		if(Which == 0) System.out.println(" > Entrez une valeur: \n");
	}
	
	@SuppressWarnings("resource")
	static void AskValue() {
		
		// Ask for value
		Scanner ask = new Scanner(System.in);
		float Value = ask.nextFloat();
		
		// Add value to array and string;
		Average[howlong] = Value;
		ALL_VALUES += Value + ", ";
		clearConsole();
		WelcomeMessage(1);

		howlong += 1;
		CalculateAverage();
		

	}
	
	static void CalculateAverage() {
		System.out.println(howlong + " VALEUR(S)    : " + ALL_VALUES);
		float totalValue = 0;
		for(int i = 0; i < howlong; i++) totalValue += Average[i];
		totalValue = totalValue / howlong;
		System.out.println("MOYENNE TOTALE : " + totalValue + "\n");
		System.out.println(" > Entrez une autre valeur: \n");
	}
	
	
	// ---- Utils functions ---- \\
	
	public static void clearConsole(){
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
}