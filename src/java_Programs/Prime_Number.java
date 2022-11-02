package java_Programs;

import java.util.Scanner;

public class Prime_Number {

	public static void main(String[] args) {
		//2,3,7,11,13,17,19...
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
	int n=	sc.nextInt();
	sc.close();
	int flag=0;
	if(n==0)
	{
		System.out.println("Number 0 is neither prime nor composite");
	}
	else if(n==1)
	{
		System.out.println("Number 1 is neither prime nor composite");
	}
	else if(n==2)
	{
		System.out.println("Number 2 is a prime number");
	}
	else if(n%2==0)
	{
		System.out.println("Number "+n+" is not a prime number");
	}
	else
	{
	int r=n/2;
	for(int i=2;i<=r;i++)
	{
		if(n%i==0)
		{
			flag=1;
			break;
		}
	}
		if(flag==1)
		{
			System.out.println("Number "+n+" is not a prime number");
		}
		else
		{
			System.out.println("Number "+n+" is a prime number");
		}
	
		
	
	}
	

	}

}
