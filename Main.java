package MoneyPal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
		// Initial
		// Feat: static block
		static {
			// CLI App Initial Greeting
			System.out.println("MoneyPal\n-------------------");

			// Print out date + time of application startup
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));

			// public checksAndValidations cav = new checksAndValidations();
			System.out.println("\nStarting transaction logging session");
		}

		public static void main(String[] args) {
			// Authentication.logNewUser();
			MainMenu mainMenu = new MainMenu();
			mainMenu.mainLoop();
		}
}


