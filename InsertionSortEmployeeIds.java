import java.util.*;
public class InsertionSortEmployeeIds{
	public static void insertionSort(int arr[])
	{
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			int key=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of employee IDs:");
		int n=sc.nextInt();
		int ids[]=new int[n];
		System.out.println("Enter "+n+" employee IDs:");
		for(int i=0;i<n;i++)
			ids[i]=sc.nextInt();
		insertionSort(ids);
		System.out.println("Sorted employee IDs in ascending order:");
		for(int i=0;i<n;i++)
			System.out.print(ids[i]+" ");
		sc.close();
	}
}
