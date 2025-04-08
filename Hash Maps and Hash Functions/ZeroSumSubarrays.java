import java.util.*;
public class ZeroSumSubarrays{
	public static void findZeroSumSubarrays(int arr[])
	{
		Map<Integer,List<Integer>>sumMap=new HashMap<>();
		int sum=0;
		System.out.println("Subarrays with zero sum:");
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(sum==0)
				System.out.println("Subarray found from index 0 to "+i);
			if(sumMap.containsKey(sum))
			{
				List<Integer> indices=sumMap.get(sum);
				for(int j=0;j<indices.size();j++)
				{
					int startIndex=indices.get(j);
					System.out.println("Subarray found from index "+(startIndex+1)+" to "+i);
				}
			}
			sumMap.putIfAbsent(sum,new ArrayList<>());
			sumMap.get(sum).add(i);
		}
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of elements:");
		int n=scanner.nextInt();
		scanner.nextLine();
		int arr[]=new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
			arr[i]=scanner.nextInt();
		findZeroSumSubarrays(arr);
		scanner.close();
	}
}