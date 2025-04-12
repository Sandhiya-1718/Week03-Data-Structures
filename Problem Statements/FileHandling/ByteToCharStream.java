import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class ByteToCharStream{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the file path: ");
		String filePath=sc.nextLine();
		BufferedReader br=null;
		try
		{
			FileInputStream fis=new FileInputStream(filePath);
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			br=new BufferedReader(isr);
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
		sc.close();
	}
}
