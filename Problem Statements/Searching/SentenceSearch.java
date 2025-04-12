import java.util.Scanner;
public class SentenceSearch{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of sentences: ");
		int n=sc.nextInt();
		sc.nextLine();
		String sentences[]=new String[n];
		System.out.println("Enter "+n+" sentences:");
		for(int i=0;i<n;i++)
			sentences[i]=sc.nextLine();
		System.out.print("Enter word to search: ");
		String word=sc.nextLine();
		String result="Not Found";
		for(int i=0;i<n;i++)
		{
			if(sentences[i].contains(word))
			{
				result=sentences[i];
				break;
			}
		}
		System.out.println("Result: "+result);
		sc.close();
	}
}
