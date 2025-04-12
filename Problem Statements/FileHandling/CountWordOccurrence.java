import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class CountWordOccurrence{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the file path: ");
		String filePath=sc.nextLine();
		System.out.print("Enter the word to search for: ");
		String targetWord=sc.nextLine();
		BufferedReader br=null;
		int count=0;
		try
		{
			FileReader fr=new FileReader(filePath);
			br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				String[] words=line.split("\\s+");
				for(String word:words)
				{
				if(word.equalsIgnoreCase(targetWord))
					count++;
				}
			}
			System.out.println("The word '"+targetWord+"' appears "+count+" times.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br!=null)
					br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
