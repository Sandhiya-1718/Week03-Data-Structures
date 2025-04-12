import java.util.*;
public class ReverseString{
	public static String reverse(String s)
	{
		StringBuilder sb=new StringBuilder();
		sb.append(s);
		sb.reverse();
		return sb.toString();
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string:");
		String input=sc.nextLine();
		String result=reverse(input);
		System.out.println("Reversed string:"+result);
		sc.close();
	}
}
