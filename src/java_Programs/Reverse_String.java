package java_Programs;

import java.util.Scanner;

public class Reverse_String {

	public static void main(String[] args) {
		// using StringBuffer
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the  input string");
		String s=sc.next();
		sc.close();
		StringBuffer sb=new StringBuffer(s);
		System.out.println("The reverse of the given string "+s+" is: "+ sb.reverse().toString());
		
		//with out string buffer
		
		System.out.println("The reverse of the given string "+s+" is: ");
		char a[]=new char[s.length()];
		for(int i=s.length()-1;i>=0;i--)
		{
		a[i]=s.charAt(i);
		System.out.print(a[i]);
		}
		
	
		
	}

}
