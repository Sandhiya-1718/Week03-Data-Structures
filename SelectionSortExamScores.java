import java.util.*;
public class SelectionSortExamScores{
	public static void selectionSort(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[min])
					min=j;
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of exam scores:");
		int n=sc.nextInt();
		int scores[]=new int[n];
		System.out.println("Enter "+n+" exam scores:");
		for(int i=0;i<n;i++)
			scores[i]=sc.nextInt();
		selectionSort(scores);
		System.out.println("Sorted exam scores in ascending order:");
		for(int i=0;i<n;i++)
			System.out.print(scores[i]+" ");
		sc.close();
	}
}
