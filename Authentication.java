// Authentication Code

package com.src;
import java.util.Scanner;

class Authentication {
	public static void main(String[] args) {
		UserAuthOperations UAO = new UserAuthOperations();
		System.out.println("Log In");

		Scanner sc = new Scanner(System.in);
		enteredUname = sc.nextLine();
		UAO.logNewUser(enteredUname);
		sc.close();
	}
}

class UserAuthOperations {
	private boolean usernameIsValid(String userName) {
		
		// return 0 -> Invalid username
		if (userName.length < 3) {
			System.out.println("Username too small, needs > 3 characters");
			return 0;
		}

		if (userName.length > 40) {
			System.out.println("Username too large, must have < 40 characters");
			return 0;
		}

		if (Character.isDigit(userName.charAt(0))) {
			System.out.println("Usernames cannot start with a number");
			return 0;
		}

		for (char i : userName) {
			if (!(Character.isAlphaNumeric(i) && i != '_')) {
				System.out.println("Usernames cannot contain special characters");
				return 0;
			}	

			else if (i == ' ') {
				System.out.println("Usernames cannot contain spaces");
				return 0;
			}
		}
	}

	private int logNewUser(String userName) {
		userNameIsValid(userName);
		// some code
	}
}

