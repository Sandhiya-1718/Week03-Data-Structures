import java.util.Scanner;
public class ConcatenateStrings{
	public static String concat(String arr[])
	{
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<arr.length;i++)
			sb.append(arr[i]);
		return sb.toString();
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of strings:");
		int n=sc.nextInt();
		sc.nextLine();
		String arr[]=new String[n];
		System.out.println("Enter "+n+" strings:");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextLine();
		String result=concat(arr);
		System.out.println("Concatenated string:"+result);
		sc.close();
	}
}
