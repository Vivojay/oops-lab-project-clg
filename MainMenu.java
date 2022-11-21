package MoneyPal;

import java.util.Scanner;

public class MainMenu {
//	 static int transactionsCount = 1;
	private static int transactionsCount = 0;

	// Setter Method which increments value of transactionsCount and sets its new value to it
	public void incrementTransactionsCount() {
		// Sets new value to (old value + 1)
		transactionsCount++;
	}

	public static int getTransactionsCount() {
		return transactionsCount;
	}

	int processCommand(String userCommand) {
		if (userCommand.equals("new")) {
			System.out.println("[+] New transaction initiated\n");

			// Empty user input
			UserDataPrompt udp = new UserDataPrompt();
			switch(udp.addTransaction()) {
				case 0:
					break;
				case 1:
					System.out.println("Transaction Failed");
					break;
				case 2:
					System.out.println("Transaction Aborted by User");
					break;
			}

		} else if (userCommand.equals("help")) {
			System.out.println("Help is under maintenance at the moment...\n");
			System.out.println("Type:\n-----\n\"help\" to see this help");
			System.out.println("\"new\" to manually create a new transaction record");
			System.out.println("\"exit\" to exit");
		} else if (userCommand.equals("exit")) {
			// Exit command issued
			System.out.println("-- Thank you for using MoneyPal --");
			return 2;
			// runExitJobs();
		} else if (userCommand != "") {
			System.out.println("Invalid user command:: " + userCommand);

			// Unsupported command
			return 1;
		}

		// Successfully processed user command
		return 0;
	}

	public void mainLoop() {
		String command;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("> ");
			command = sc.nextLine().trim();
			int processReturnCode = processCommand(command);

			if (processReturnCode == 2)
				break; // Exit out of main loop
		}
		sc.close();
	}
}
