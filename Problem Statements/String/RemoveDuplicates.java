import java.util.*;
public class RemoveDuplicates{
	public static String removeDup(String s)
	{
		StringBuilder sb=new StringBuilder();
		HashSet<Character>set=new HashSet<>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(!set.contains(c))
			{
				set.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string:");
		String input=sc.nextLine();
		String result=removeDup(input);
		System.out.println("String after removing duplicates:"+result);
		sc.close();
	}
}
