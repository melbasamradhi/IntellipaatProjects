package java_Programs;

import java.util.Scanner;

public class Vowel_inString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String s=sc.next();
		sc.close();
		char c;
		int n=s.length();
		System.out.println("Vowels in "+s+":");
		for(int i=0;i<n;i++)
		{
			c=s.charAt(i);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			{
				System.out.print(c+" ");
			}
		}

	}

}
