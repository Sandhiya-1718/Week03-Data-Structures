import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class CompareAll{
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("StringBuilder vs StringBuffer Performance:");
		int n=1000000;
		long start1=System.nanoTime();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++)
			sb.append("hello");
		long end1=System.nanoTime();
		System.out.println("StringBuilder time: "+(end1-start1)/1000000+" ms");
		long start2=System.nanoTime();
		StringBuffer sbf=new StringBuffer();
		for(int i=0;i<n;i++)
			sbf.append("hello");
		long end2=System.nanoTime();
		System.out.println("StringBuffer time: "+(end2-start2)/1000000+" ms");
		System.out.print("\nEnter file path for FileReader: ");
		String path1=sc.nextLine();
		long wordCount1=0;
		long frStart=System.nanoTime();
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(path1));
			String line;
			while((line=br.readLine())!=null)
			{
				String[] words=line.split("\\s+");
				wordCount1+=words.length;
			}
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		long frEnd=System.nanoTime();
		System.out.println("FileReader word count: "+wordCount1);
		System.out.println("FileReader time: "+(frEnd-frStart)/1000000+" ms");
		System.out.print("\nEnter file path for InputStreamReader: ");
		String path2=sc.nextLine();
		long wordCount2=0;
		long isrStart=System.nanoTime();
		try
		{
			BufferedReader br2=new BufferedReader(new InputStreamReader(new java.io.FileInputStream(path2),"UTF-8"));
			String line2;
			while((line2=br2.readLine())!=null)
			{
				String[] words=line2.split("\\s+");
				wordCount2+=words.length;
			}
			br2.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		long isrEnd=System.nanoTime();
		System.out.println("InputStreamReader word count: "+wordCount2);
		System.out.println("InputStreamReader time: "+(isrEnd-isrStart)/1000000+" ms");
		sc.close();
	}
}
