import java.util.HashSet;
import java.util.Scanner;
public class LongestConsecutiveSequence{
	public static int findLongestSequence(int arr[])
	{
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<arr.length;i++)
			set.add(arr[i]);
		int longest=0;
		for(int i=0;i<arr.length;i++)
		{
			int num=arr[i];
			if(!set.contains(num-1))
			{
				int currentNum=num;
				int count=1;
				while(set.contains(currentNum+1))
				{
					currentNum++;
					count++;
				}
				if(count>longest)
					longest=count;
			}
		}
		return longest;
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of elements:");
		int n=scanner.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter "+n+" elements:");
		for(int i=0;i<n;i++)
			arr[i]=scanner.nextInt();
		int result=findLongestSequence(arr);
		System.out.println("Length of longest consecutive sequence:"+result);
		scanner.close();
	}
}