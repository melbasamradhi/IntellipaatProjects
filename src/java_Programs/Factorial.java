package java_Programs;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// 5!=5*4*3*2*1=120
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input number");
		int n=sc.nextInt();
		int input=n;
		sc.close();
		int ans=n;
		n=n-1;
		for(int i=1;i<=input-1;i++)
		{
			ans=ans*n;
			n=n-1;
		}
		System.out.println("The factorial value of "+input+" is "+ans);
	}

}
