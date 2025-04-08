import java.util.Scanner;
import java.util.Stack;
public class SortStackRecursively{
	public static void sortStack(Stack<Integer> stack)
	{
		if(!stack.isEmpty())
		{
			int top=stack.pop();
			sortStack(stack);
			insertInSortedOrder(stack,top);
		}
	}
	public static void insertInSortedOrder(Stack<Integer> stack,int value)
	{
		if(stack.isEmpty()||value>stack.peek())
			stack.push(value);
		else
		{
			int temp=stack.pop();
			insertInSortedOrder(stack,value);
			stack.push(temp);
		}
	}
	public static void displayStack(Stack<Integer> stack)
	{
		for(int i=stack.size()-1;i>=0;i--)
			System.out.println(stack.get(i));
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		Stack<Integer> stack=new Stack<>();
		System.out.print("Enter number of elelemts:");
		int n=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter "+n+" integers:");
		for(int i=0;i<n;i++)
			stack.push(scanner.nextInt());
		System.out.println("\nOriginal Stack");
		displayStack(stack);
		sortStack(stack);
		System.out.println("\nSorted Stack (Ascending):");
		displayStack(stack);
		scanner.close();
	}
}