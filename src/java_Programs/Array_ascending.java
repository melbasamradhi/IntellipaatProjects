package java_Programs;

public class Array_ascending {

	public static void main(String[] args) {
		int a[]= {12,71,73,8,10,5,0};
		System.out.print("Given array: ");
		for(int c:a)
		{
			System.out.print(c+" ");
		}
		System.out.println();
		int n=a.length,temp;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}	
		}
		System.out.print("Ascending order of the given array: ");
		for(int b:a)
		{
		System.out.print(b+" ");
		}
	

	}

}
