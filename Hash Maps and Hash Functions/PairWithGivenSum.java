import java.util.HashSet;
import java.util.Scanner;
public class PairWithGivenSum{
	public static boolean hasPairWithSum(int arr[],int target)
	{
		HashSet<Integer> seen=new HashSet<>();
		boolean found=false;
		for(int i=0;i<arr.length;i++)
		{
			int complement=target-arr[i];
			if(seen.contains(complement))
			{
				System.out.println("Pair found:("+arr[i]+","+complement+")");
				found=true;
			}
			seen.add(arr[i]);
		}
		if(!found)
			System.out.println("No pair found with the given sum.");
		return found;
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of elements in the array:");
		int n=scanner.nextInt();
		scanner.nextLine();
		int arr[]=new int[n];
		System.out.println("Enter "+n+" integers:");
		for(int i=0;i<n;i++)
			arr[i]=scanner.nextInt();
		System.out.print("Enter target sum:");
		int target=scanner.nextInt();
		hasPairWithSum(arr,target);
		scanner.close();
	}
}