package MoneyPal;

public class UserAuthOperations {
	private boolean usernameIsValid(String userName) {

		// return 0 -> Invalid username
		if (userName.length() < 3) {
			System.out.println("Username too small, needs > 3 characters");
			return false;
		}

		if (userName.length() > 40) {
			System.out.println("Username too large, must have < 40 characters");
			return false;
		}

		if (Character.isDigit(userName.charAt(0))) {
			System.out.println("Usernames cannot start with a number");
			return false;
		}

		for (char i : userName.toCharArray()) {
			if (!(Character.isAlphabetic(i) || Character.isDigit(i)) && i != '_') {
				System.out.println("Usernames cannot contain special characters");
				return false;
			} else if (i == ' ') {
				System.out.println("Usernames cannot contain spaces");
				return false;
			}
		}
		return true;
	}

	int logNewUser(String userName){
		if (usernameIsValid(userName)) {
			// do sumn
			return 0;
		}
		else {
			// do sumn
			return 1;
		}
		// some code
	}
}
