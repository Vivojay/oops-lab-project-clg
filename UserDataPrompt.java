package MoneyPal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDataPrompt extends MainMenu{
	Scanner sc = new Scanner(System.in);
	// String a = sc.next();

	public int addTransaction() {
		try {
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

			String description;
			
			// Provide Transaction Description
			// Feat2: Use of "System.out.printf"
			System.out.printf("Enter a 1 line transaction description\n");
			// Clear last new line
			sc.nextLine();
			description = sc.nextLine();

			// Transaction Party
			String partyType = "(Unidentified)";
			if (expenseType == 'c') {
				partyType = "sender";
			} else {
				partyType = "receiver";
			}

			// Transaction Party Ph. No.
			while (true) {
				try {
					System.out.print("\nEnter mobile number of the " + partyType + ": ");
					String partyMobileNumber = sc.next();
					System.out.println("Mobile Number: " + partyMobileNumber);
					break;
				}
				catch (InputMismatchException e) {
					System.out.println("Invalid Mobile Number, retry...");
				}
				catch (Exception e) {
					System.out.println("Uncaught Exception...");
				}
			}

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
			super.incrementTransactionsCount();
			System.out.printf("[✓] Transaction #%d successfully recorded\n", getTransactionsCount());

			// TODO: Make the following lines work
			// Utilities utl = new Utilities();
			// String transactionLocation = utl.getGeoLocation();

			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 1;
		}
	}
}
