package testNG_Basic;
/* 1 2 3 4 5
 * 6 7 8 9 0
 * 9 3 4 6 7
 */
public class Java_TwoDimenArray {

	public static void main(String[] args) {
		
		int a[][]= {{1,2,3,4,5},{6,7,8,9,0},{9,3,4,6,7}};
		//int a[][]=new int[3][5];a[0][0]=1;a[0][1]=2
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
				
		}
		

	}

}
