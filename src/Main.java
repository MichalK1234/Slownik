
import java.util.Scanner;

public class Main {

	// PROGRAM WYKONANY W RAMACH SZKOLENIA KM-PROGRAMS
	// http://km-programs.pl/

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		GlossaryFile sp = new GlossaryFile();
		sp.getTranslation();
		sp.showMapContent();
		sp.saveTranslation();

		GlossaryConsole sk = new GlossaryConsole();
		sk.getTranslation();
		sk.showMapContent();
		sk.saveTranslation();

		sc.close();
	}

}
