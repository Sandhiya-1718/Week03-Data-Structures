import java.util.Scanner;
import java.util.Stack;
public class QueueUsingStack{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	public void enqueue(int value)
	{
		stack1.push(value);
		System.out.println("Enqueued:"+value);
	}
	public void dequeue()
	{
		if(stack2.isEmpty())
		{
			if(stack1.isEmpty())
			{
				System.out.println("Queue is empty.");
				return;
			}
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		int removed=stack2.pop();
		System.out.println("Dequeued:"+removed);
	}
	public void peek()
	{
		if(stack2.isEmpty())
		{
			if(stack1.isEmpty())
			{
				System.out.println("Queue is empty.");
				return;
			}
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		System.out.println("Front element:"+stack2.peek());
	}
	public void isEmpty()
	{
		if(stack1.isEmpty()&&stack2.isEmpty())
			System.out.println("Queue is empty.");
		else
			System.out.println("Queue is not empty.");
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		QueueUsingStack queue=new QueueUsingStack();
		int choice;
		do
		{
			System.out.println("---Queue Using Two Stacks---");
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Peek Front");
			System.out.println("4.Check if empty");
			System.out.println("5.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter value to enqueue:");
				int value=scanner.nextInt();
				scanner.nextLine();
				queue.enqueue(value);
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				queue.peek();
				break;
			case 4:
				queue.isEmpty();
				break;
			case 5:
				System.out.println("Exiting program.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=5);
		scanner.close();
	}
}