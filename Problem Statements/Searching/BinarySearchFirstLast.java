import java.util.Scanner;
public class BinarySearchFirstLast{
	public static int findFirst(int arr[],int target)
	{
		int left=0,right=arr.length-1,result=-1;
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			if(arr[mid]==target)
			{
				result=mid;
				right=mid-1;
			}
			else if(arr[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		return result;
	}
	public static int findLast(int arr[],int target)
	{
		int left=0,right=arr.length-1,result=-1;
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			if(arr[mid]==target)
			{
				result=mid;
				left=mid+1;
			}
			else if(arr[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		return result;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements of the sorted array:");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.print("Enter the target element: ");
		int target=sc.nextInt();
		int first=findFirst(arr,target);
		int last=findLast(arr,target);
		if(first==-1)
			System.out.println("Element not found in the array.");
		else
			System.out.println("First occurrence of "+target+" is at index: "+first);
		System.out.println("Last occurrence of "+target+" is at index: "+last);
		sc.close();
	}
}
