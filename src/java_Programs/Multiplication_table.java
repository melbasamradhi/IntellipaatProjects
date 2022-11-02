package java_Programs;

import java.util.Scanner;

public class Multiplication_table {
/* 3*1=3; 3*2=6; 3*3=9;*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number for multiplication table");
		int n=sc.nextInt();
		int n1=n;
		int ans=1;
		sc.close();
		System.out.println("Multiplication table of "+n+":");
		for(int i=1;i<=n;i++)
		{
			ans=n*i;
			System.out.println(n+"*"+i+"="+ans);
		}
			
		
				

	}

}
