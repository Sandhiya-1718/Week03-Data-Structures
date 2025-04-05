import java.util.Scanner;
class Process{
	int id;
	int burstTime;
	int remainingTime;
	int priority;
	Process next;
	public Process(int id,int burstTime,int priority)
	{
		this.id=id;
		this.burstTime=burstTime;
		this.remainingTime=burstTime;
		this.priority=priority;
	}
}
public class RoundRobin{
	Process head=null;
	Process tail=null;
	public void addProcess(int id,int burstTime,int priority)
	{
		Process newProcess=new Process(id,burstTime,priority);
		if(head==null)
		{
			head=tail=newProcess;
			newProcess.next=head;
		}
		else
		{
			tail.next=newProcess;
			newProcess.next=head;
			tail=newProcess;
		}
		System.out.println("Process added: ID "+id);
	}
	public void displayProcesses()
	{
		if(head==null)
		{
			System.out.println("No processes to display.");
			return;
		}
		Process temp=head;
		do
		{
			System.out.println("Process ID:"+temp.id+", Burst Time:"+temp.burstTime+", Priority:"+temp.priority);
			temp=temp.next;
		}while(temp!=head);
	}
	public void simulate(int timeQuantum)
	{
		if(head==null)
		{
			System.out.println("No processes to schedule.");
			return;
		}
		Process current=head;
		int time=0;
		while(true)
		{
			boolean allDone=true;
			Process temp=current;
			do
			{
				if(temp.remainingTime>0)
				{
					allDone=false;
					int execTime=Math.min(timeQuantum,temp.remainingTime);
					System.out.println("Processing ID:"+temp.id+" for "+execTime+" units.");
					temp.remainingTime-=execTime;
					time+=execTime;
					if(temp.remainingTime==0)
						System.out.println("Pricess ID "+temp.id+" completed at time "+time);
				}
				temp=temp.next;
			}while(temp!=current);
			if(allDone)
				break;
		}
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		RoundRobin scheduler=new RoundRobin();
		int choice;
		do
		{
			System.out.println("---Round Robin Scheduler---");
			System.out.println("1.Add Process");
			System.out.println("2.Display Processes");
			System.out.println("3.Simulate Scheduling");
			System.out.println("4.Exit");
			System.out.print("Enter choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter Process ID:");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Burst Time:");
				int bt=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Priority:");
				int pr=scanner.nextInt();
				scanner.nextLine();
				scheduler.addProcess(id,bt,pr);
				break;
			case 2:
				scheduler.displayProcesses();
				break;
			case 3:
				System.out.print("Enter Time Quantum:");
				int tq=scanner.nextInt();
				scanner.nextLine();
				scheduler.simulate(tq);
				break;
			case 4:
				System.out.println("Exiting..");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=4);
		scanner.close();
	}
}