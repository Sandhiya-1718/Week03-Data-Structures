import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ConsoleToFile{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the file path to write to: ");
		String filePath=sc.nextLine();
		BufferedReader br=null;
		FileWriter fw=null;
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			br=new BufferedReader(isr);
			fw=new FileWriter(filePath);
			String line;
			System.out.println("Enter text (type 'exit' to finish):");
			while(true)
			{
				line=br.readLine();
				if(line.equalsIgnoreCase("exit"))
					break;
				fw.write(line+"\n");
			}
				System.out.println("Input written to file successfully.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fw!=null)
					fw.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
