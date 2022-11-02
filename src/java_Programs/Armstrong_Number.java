package java_Programs;

import java.util.Scanner;

public class Armstrong_Number {

	public static void main(String[] args) {
		//370=3^3+7^3+0^3
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int input=n;
		sc.close();
		int ans=0,c,temp=1;;
		int l=String.valueOf(n).length();
		for(int i=1;i<=l;i++)
		{
			c=n%10;
			n=n/10;
			for(int j=1;j<=l;j++)
			{
			temp=temp*c;
			}
			ans=ans+temp;
			temp=1;
		}
		System.out.println(ans);
		if(ans==input)
		{
			System.out.println("Given number "+input+" is  an armstrong number");
		}
		else
		{
			System.out.println("Given number "+input+" is not an armstrong number");
		}
		

	}

}
