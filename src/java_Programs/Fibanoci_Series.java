package java_Programs;

import java.util.Scanner;

public class Fibanoci_Series {

	public static void main(String[] args) {
		// 0,1,1,2,3,5,8,13,21,34,55
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		sc.close();
		if (n < 3) {
			switch (n) {
			case (1): {
				System.out.println("Fibanocci series of 1 number is 0");
				break;
			}
			case (2): {
				System.out.println("Fibanocci series of 2 number is 0,1");
				break;
			}
			}
		} else {
			int n1=0, n2=1,sum=0;
			System.out.print("Fibanocci series of "+n+" number is 0,1");
			for(int i=1;i<=n-2;i++)
			{
				sum=n1+n2;
				n1=n2;
				n2=sum;
				System.out.print(","+sum);
			}

		}
	}

}
