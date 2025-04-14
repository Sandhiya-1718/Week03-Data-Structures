import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
public class LargeFileReading{
	public static void main(String[] args)throws java.io.IOException
	{
		String filePath="largefile.txt";
		long start=System.nanoTime();
		try(FileReader fr=new FileReader(filePath))
		{
			while(fr.read()!=-1)
			{	
			}
		}
		long fileReaderTime=System.nanoTime()-start;
		System.out.println("Time with FileReader:"+fileReaderTime/1e6+" ms");
		start=System.nanoTime();
		try(InputStreamReader isr=new InputStreamReader(new FileInputStream(filePath)))
		{
			while(isr.read()!=-1)
			{
			}
		}
		long inputStreamReaderTime=System.nanoTime()-start;
		System.out.println("Time with InputStreamReader:"+inputStreamReaderTime/1e6+" ms");
	}
}
