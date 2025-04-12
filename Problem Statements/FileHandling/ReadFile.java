import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class ReadFile{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the file path:");
		String filePath=sc.nextLine();
		BufferedReader br=null;
		try
		{
			FileReader fr=new FileReader(filePath);
			br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
				System.out.println(line);
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
	}
}
