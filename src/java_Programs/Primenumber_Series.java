package java_Programs;

import java.util.Scanner;

public class Primenumber_Series {

	public static void main(String[] args) {
		// 2,3,5,7,11,13....
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		sc.close();
		int s=5;int count=2;
		if(n==1)
		{
		System.out.println("Prime number series of " + n + " number: 2");
		}
		else if(n==2)
		{
			System.out.println("Prime number series of " + n + " numbers: 2,3");
		}
		else
		{
			System.out.print("Prime number series of " + n +" numbers: 2, 3");
			while(count!=n)
			{
				int flag=0;
				int r=s/2;
				for(int i=2;i<=r;i++)
				{
					if(s%i==0)
					{
						flag=1;
						break;
					
					}
				}
				if(flag==0)
				{
					count++;
					System.out.print(", "+s);
				}
				s=s+2;
			}
			
		}
		
		

	}

}
