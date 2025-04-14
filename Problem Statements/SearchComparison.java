import java.util.Arrays; 
import java.util.Random; 
public class SearchComparison{ 
	public static boolean linearSearch(int data[],int target)
	{ 
		for(int i=0;i<data.length;i++)
		{ 
			if(data[i]==target)
				return true; 
		} 
		return false;
	} 
	public static boolean binarySearch(int data[],int target)
	{ 
		int left=0,right=data.length-1; 
		while(left<=right)
		{ 
			int mid=left+(right-left)/2; 
			if(data[mid]==target) 
				return true;  
			if(data[mid]<target) 
				left=mid+1; 
			else
				right=mid-1; 
		} 
		return false; 
	}
	public static void main(String[] args)
	{ 
		int datasetSizes[]={1000,10000,1000000};
		for(int i=0;i<datasetSizes.length;i++)
		{ 
			int n=datasetSizes[i]; 
			int data[]=new int[n]; 
			Random rand=new Random(); 
			for(int j=0;j<n;j++)
				data[j]=rand.nextInt(100000);
			int target=rand.nextInt(100000);
			long start=System.nanoTime();
			boolean foundLinear=linearSearch(data,target);
			long timeLinear=System.nanoTime()-start;
			start=System.nanoTime();
			boolean foundBinary=binarySearch(data,target);
			long timeBinary=System.nanoTime()-start;
			System.out.println("Dataset Size: "+n);
			System.out.println("Linear Search Time: "+timeLinear/1e6+" ms");
			System.out.println("Binary Search Time: "+timeBinary/1e6+" ms");
			System.out.println(); 
		} 
	} 
}
