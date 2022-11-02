package java_Programs;

public class Array_largest {

	public static void main(String[] args) {
		//int a[]=new int[4];
		int a[]= {123,23,71,190,78,580,45};
		int ans=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>ans)
			{
				ans=a[i];
			}
		}
		System.out.println("The largest number in the given array is "+ans);
		

	}

}
