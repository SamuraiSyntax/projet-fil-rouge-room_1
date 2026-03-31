package pfr.buycar.utils;

import java.util.Scanner;

public class InputUtils {

	public static int lireEntier(Scanner sc) {
		try {
			return Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println(Icons.ATTENTION + " Veuillez entrer un nombre valide !");
			return -1;
		}
	}
}
