package MoneyPal;

import java.util.Scanner;
public class Authentication {
	public static void main(String[] args) {
		UserAuthOperations UAO = new UserAuthOperations();
		System.out.println("Log In");

		Scanner sc = new Scanner(System.in);
		String enteredUname = sc.nextLine();
		UAO.logNewUser(enteredUname);
		sc.close();
	}
}
