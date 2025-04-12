import java.util.Scanner;
public class CompareStrings{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of concatenations:");
		int n=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the string to concatenate:");
		String str=sc.nextLine();
		long startTime,endTime;
		StringBuffer sb=new StringBuffer();
		StringBuilder sbld=new StringBuilder();
		startTime=System.nanoTime();
		for(int i=0;i<n;i++)
			sb.append(str);
		endTime=System.nanoTime();
		System.out.println("Time taken by StringBuffer: "+(endTime-startTime)+" nanoseconds");
		startTime=System.nanoTime();
		for(int i=0;i<n;i++)
			sbld.append(str);
		endTime=System.nanoTime();
		System.out.println("Time taken by StringBuilder: "+(endTime-startTime)+" nanoseconds");
		sc.close();
	}
}
