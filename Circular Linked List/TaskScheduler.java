import java.util.Scanner;
class Task{
	int id;
	String name;
	int priority;
	String dueDate;
	Task next;
	public Task(int id,String name,int priority,String dueDate)
	{
		this.id=id;
		this.name=name;
		this.priority=priority;
		this.dueDate=dueDate;
	}
}
public class TaskScheduler{
	Task head=null;
	Task tail=null;
	Task current=null;
	public void addTask(int id,String name,int priority,String dueDate)
	{
		Task newTask=new Task(id,name,priority,dueDate);
		if(head==null)
		{
			head=tail=newTask;
			newTask.next=head;
		}
		else
		{
			tail.next=newTask;
			newTask.next=head;
			tail=newTask;
		}
		System.out.println("Task added.");
	}
	public void removeTask(int id)
	{
		if(head==null)
		{
			System.out.println("Task list is empty.");
			return;
		}
		Task temp=head;
		Task prev=tail;
		do
		{
			if(temp.id==id)
			{
				if(temp==head&&temp==tail)
					head=tail=current=null;
				else if(temp==head)
				{
					head=head.next;
					tail.next=head;
				}
				else if(temp==tail)
				{
					tail=prev;
					tail.next=head;
				}
				else
					prev.next=temp.next;
				if(current==temp)
					current=current.next;
				System.out.println("Task removed.");
				return;
			}
			prev=temp;
			temp=temp.next;
		}while(temp!=head);
		System.out.println("Task ID not found.");
	}
	public void viewCurrentTask()
	{
		if(current==null)
			current=head;
		if(current==null)
		{
			System.out.println("No tasks.");
			return;
		}
		System.out.println("Current Task -> ID:"+current.id+", Name:"+current.name+", Priority:"+current.priority+", Due:"+current.dueDate);
		current=current.next;
	}
	public void displayAllTasks()
	{
		if(head==null)
		{
			System.out.println("No tasks in the list.");
			return;
		}
		Task temp=head;
		do
		{
			System.out.println("ID:"+temp.id+", Name:"+temp.name+", Priority:"+temp.priority+", Due:"+temp.dueDate);
			temp=temp.next;
		}while(temp!=head);
	}
	
	public void searchByPriority(int priority)
	{
		if(head==null)
		{
			System.out.println("Task list is empty.");
			return;
		}
		Task temp=head;
		boolean found=false;
		do
		{
			if(temp.priority==priority)
			{
				System.out.println("ID:"+temp.id+", Name:"+temp.name+", Priority:"+temp.priority+", Due:"+temp.dueDate);
				found=true;
			}
			temp=temp.next;
		}while(temp!=head);
		if(!found)
			System.out.println("No tasks with that priority.");
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		TaskScheduler scheduler=new TaskScheduler();
		int choice;
		do
		{
			System.out.println("---Task Scheduler Menu---");
			System.out.println("1.Add Task");
			System.out.println("2.Remove Task by ID");
			System.out.println("3.View current Task and Move next");
			System.out.println("4.Display All Tasks");
			System.out.println("5.Search Task by Priority");
			System.out.println("6.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter Task ID:");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Task Name:");
				String name=scanner.nextLine();
				System.out.print("Enter Priority:");
				int priority=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Due Date:");
				String dueDate=scanner.nextLine();
				scheduler.addTask(id,name,priority,dueDate);
				break;
			case 2:
				System.out.print("Enter Task ID to remove:");
				int removeId=scanner.nextInt();
				scanner.nextLine();
				scheduler.removeTask(removeId);
				break;
			case 3:
				scheduler.viewCurrentTask();
				break;
			case 4:
				scheduler.displayAllTasks();
				break;
			case 5:
				System.out.print("Enter Priority to search:");
				int searchPriority=scanner.nextInt();
				scanner.nextLine();
				scheduler.searchByPriority(searchPriority);
				break;
			case 6:
				System.out.println("Exiting Task Scheduler.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=6);
		scanner.close();
	}
}