package java_Programs;
import java.util.*;
public class Array_oddEven {

	public static void main(String[] args) {
		int a[]= {12,23,71,1901,78,5807,45,80,900};
		int n;
		ArrayList<Integer> even=new ArrayList<Integer>();
		ArrayList<Integer> odd=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
		{
			n=a[i];
			if(n%2==0)
			{
				even.add(n);
			}
			else
			{
				odd.add(n);
			}
		}
		System.out.println("Even number in the given array: "+even);
		System.out.println("Odd number in the given array: "+odd);
		
	}

}
