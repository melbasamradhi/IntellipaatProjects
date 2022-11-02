package java_Programs;

import java.util.Scanner;

public class Palindrome_Number {

	public static void main(String[] args) {
		// 16461 is a palindrome number
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the input number");
		int n =sc.nextInt();
		sc.close();
		StringBuffer s = new StringBuffer(String.valueOf(n));
		String s1 = s.reverse().toString();
		int n1 = Integer.parseInt(s1);
		if (n == n1) {
			System.out.println("Given number " + n + " is a palindrome");
		} else {
			System.out.println("Given number " + n + " is not a palindrome");
		}
	}
}
