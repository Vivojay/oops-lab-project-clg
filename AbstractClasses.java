import java.util.Scanner;

abstract class AbsClass {
	public abstract void fun();
	public int nonabstractGetSquare(int a) {
		return (int) Math.pow(a, 2);
	}
}

class AbstractClasses extends AbsClass {
	public void fun() {
		System.out.println("I like creamy pies");
	}

	public static void main(String[] args) {
		AbstractClasses a = new AbstractClasses();
		a.fun();
	
		int getSquare = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an int value to get square: ");
		getSquare = sc.nextInt();

		sc.close();
		System.out.printf("Square of %d is %d\n", getSquare, a.nonabstractGetSquare(getSquare));
	}
}


