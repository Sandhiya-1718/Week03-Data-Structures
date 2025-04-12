import java.util.Scanner;
public class PeakElementBinary {
    public static int findPeak(int arr[])
	{
        int n=arr.length;
        int left=0,right=n-1;
        while(left<=right)
		{
            int mid=left+(right-left)/2;
            boolean leftCheck=mid==0||arr[mid]>arr[mid-1];
            boolean rightCheck=mid==n-1||arr[mid]>arr[mid+1];
            if(leftCheck&&rightCheck)
				return arr[mid];
            else if(mid>0&&arr[mid]<arr[mid-1])
				right=mid-1;
            else
				left=mid+1;
        }
        return -1;
    }
    public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter "+n+" integers:");
        for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
        int peak=findPeak(arr);
        System.out.println("Peak element: "+peak);
        sc.close();
    }
}
