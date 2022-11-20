/*
 * MoneyPal
 * A Java Software for Expense Management
 * */

package com.src;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

import java.util.InputMismatchException;

// Make this import work
// import com.src.Utils.Utilities;

// import checksAndValidations;
// import java.io.FileWriter;
// import java.io.IOException;
// import org.json.simple.JSONArray;

// FIXME: Error prone line
// import org.json.simple.JSONObject;

class Main {
	// Initial
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
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainLoop();
    }
}

class MainMenu {
    int transactionsCount = 0;
    int processCommand(String userCommand) {
        if (userCommand.equals("new")) {
            System.out.println("[+] New transaction initiated\n");

            // Empty user input
            UserDataPrompt udp = new UserDataPrompt();
            switch(udp.addTransaction()) {
				case 0:
					transactionsCount++;
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

class UserDataPrompt extends MainMenu {
    Scanner sc = new Scanner(System.in);
    // String a = sc.next();

    public int addTransaction() {
        // Expense Type
        char expenseType;
        while (true) {
            System.out.println("Transaction type");
            System.out.print("[c]redit / [d]ebit: ");
            expenseType = sc.next().trim().toLowerCase().charAt(0);

            System.out.println();

            if (expenseType == 'c') {
                System.out.println("Amount crediting"); break;
            } else if (expenseType == 'd') {
                System.out.println("Amount debiting"); break;
            } else {
                System.out.println("[x] Invalid expense type, please retry...");
            }
        }

        // Expense Amount
        double totalAmount = 0;
        while (true) {
            if (expenseType == 'c') {
                System.out.print("Enter amount to be credited: ");
            } else {
                System.out.print("Enter amount to be debited: ");
            }

            try {
                sc.nextLine(); // Clear current line
                totalAmount = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input for amount, please retry...");
            }
        }

        if (expenseType == 'd') {
            totalAmount *= -1;
        }

        if (expenseType == 'c') {
            System.out.print("Amount credited: ");
        } else {
            System.out.print("Amount debited: ");
        }
        System.out.println(totalAmount);

        // Transaction Party
        String partyType = "(Unidentified)";
        if (expenseType == 'c') {
            partyType = "sender";
        } else {
            partyType = "receiver";
        }

        // Transaction Party Ph. No.
        System.out.print("\nEnter mobile number of the " + partyType + ": ");
        String partyMobileNumber = sc.next();
        System.out.println("Mobile Number: " + partyMobileNumber);

        // checksAndValidations cav = new checksAndValidations();

        // if (!cav.mobileNumberIsValid(partyMobileNumber)) {
        // System.out.println("LOL");
        // }

        // If null, ask for uname yourself

        /*
         * String partyName = nameIfRegistered();
         * partyName = sc.nextLine().trim();
         */

        System.out.print("\nEnter name of the " + partyType + ": ");

        sc.nextLine();
        String partyName = sc.nextLine().trim();
        System.out.println("Name of " + partyType + ": " + partyName);

        // Following print statement will be within `recordTransaction()` function itself
        // System.out.println("Recording transaction");

        // TODO: Store current transaction data into a struct or sumn (like a dict)
        // Something T transactionData = {partyType, partyName};

        // TODO: Within following func, save this data into a file + save to offline/online database (or both) 
        // recordTransaction(transactionData);
        
        // Check if above func work with return code 0, if yes, then print following lines
        super.transactionsCount++;
        System.out.printf("[✓] Transaction #%d successfully recorded\n", super.transactionsCount);

        // TODO: Make the following lines work
        // Utilities utl = new Utilities();
        // String transactionLocation = utl.getGeoLocation();
	
		return 0;
	}
}


