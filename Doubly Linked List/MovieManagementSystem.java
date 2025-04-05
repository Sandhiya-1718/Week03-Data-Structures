import java.util.Scanner;
class MovieNode{
	String title;
	String director;
	int year;
	double rating;
	MovieNode prev,next;
	MovieNode(String title,String director,int year,double rating)
	{
		this.title=title;
		this.director=director;
		this.year=year;
		this.rating=rating;
		this.prev=null;
		this.next=null;
	}
}
public class MovieManagementSystem{
	static MovieNode head=null;
	static MovieNode tail=null;
	public static void addAtBeginning(String title,String director,int year,double rating)
	{
		MovieNode newNode=new MovieNode(title,director,year,rating);
		if(head==null)
			head=tail=newNode;
		else
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		System.out.println("Movie added at beginning.");
	}
	public static void addAtEnd(String title,String director,int year,double rating)
	{
		MovieNode newNode=new MovieNode(title,director,year,rating);
		if(tail==null)
			head=tail=newNode;
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		System.out.println("Movie added at end.");
	}
	public static void addAtPosition(String title,String director,int year,double rating,int position)
	{
		if(position<=1||head==null)
		{
			addAtBeginning(title,director,year,rating);
			return;
		}
		MovieNode newNode=new MovieNode(title,director,year,rating);
		MovieNode temp=head;
		int count=1;
		while(temp!=null&&count<position-1)
		{
			temp=temp.next;
			count++;
		}
		if(temp==null||temp.next==null)
			addAtEnd(title,director,year,rating);
		else{
			newNode.next=temp.next;
			newNode.prev=temp;
			temp.next.prev=newNode;
			temp.next=newNode;
			System.out.println("Movie added at position "+position);
		}
	}
	public static void removeByTitle(String title)
	{
		MovieNode temp=head;
		while(temp!=null)
		{
			if(temp.title.equalsIgnoreCase(title))
			{
				if(temp==head)
				{
					head=head.next;
					if(head!=null)
						head.prev=null;
				}
				else if(temp==tail)
				{
					tail=tail.prev;
					if(tail!=null)
						tail.next=null;
				}
				else
				{
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
				}
				System.out.println("Movie "+title+" removed.");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Movie not found.");
	}
	public static void search(String keyword)
	{
		MovieNode temp=head;
		boolean found=false;
		while(temp!=null)
		{
			if(temp.director.equalsIgnoreCase(keyword)||String.valueOf(temp.rating).equals(keyword))
			{
				System.out.println("Title:"+temp.title+" | Director:"+temp.director+" | Year:"+temp.year+" | Rating:"+temp.rating);
				found=true;
			}
			temp=temp.next;
		}
		if(!found)
			System.out.println("No movies found for "+keyword+".");
	}
	public static void displayForward()
	{
		if(head==null)
		{
			System.out.println("No movies to display.");
			return;
		}
		System.out.println("Movies (forward):");
		MovieNode temp=head;
		while(temp!=null)
		{
			System.out.println("Title:"+temp.title+" | Director:"+temp.director+" | Year:"+temp.year+" | Rating:"+temp.rating);
			temp=temp.next;
		}
	}
	public static void displayReverse()
	{
		if(tail==null)
		{
			System.out.println("No movies to display.");
			return;
		}
		System.out.println("Movies (reverse):");
		MovieNode temp=tail;
		while(temp!=null)
		{
			System.out.println("Title:"+temp.title+" | Director:"+temp.director+" | Year:"+temp.year+" | Rating:"+temp.rating);
			temp=temp.prev;
		}
	}
	public static void updateRating(String title,double newRating)
	{
		MovieNode temp=head;
		while(temp!=null)
		{
			if(temp.title.equalsIgnoreCase(title))
			{
				temp.rating=newRating;
				System.out.println("Rating updated for "+title+".");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Movie not found.");
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("----Movie Management System----");
			System.out.println("1.Add Movie at Beginning");
			System.out.println("2.Add Movie at End");
			System.out.println("3.Add Movie at Specific Position");
			System.out.println("4.Remove Movie by Title");
			System.out.println("5.Search by Director or Rating");
			System.out.println("6.Display all Movies(Forward)");
			System.out.println("7.Display all Movies(Reverse)");
			System.out.println("8.Update Movie Rating by Title");
			System.out.println("0.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			String title;
			String director;
			int year;
			double rating;
			int position;
			switch(choice)
			{
			case 1:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter director:");
				director=scanner.nextLine();
				System.out.print("Enter year:");
				year=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter rating:");
				rating=scanner.nextDouble();
				scanner.nextLine();
				addAtBeginning(title,director,year,rating);
				break;
			case 2:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter director:");
				director=scanner.nextLine();
				System.out.print("Enter year:");
				year=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter rating:");
				rating=scanner.nextDouble();
				scanner.nextLine();
				addAtEnd(title,director,year,rating);
				break;
			case 3:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter director:");
				director=scanner.nextLine();
				System.out.print("Enter year:");
				year=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter rating:");
				rating=scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Enter position:");
				position=scanner.nextInt();
				scanner.nextLine();
				addAtPosition(title,director,year,rating,position);
				break;
			case 4:
				System.out.print("Enter title to remove:");
				title=scanner.nextLine();
				removeByTitle(title);
				break;
			case 5:
				System.out.print("Enter director name or rating to search:");
				String keyword=scanner.nextLine();
				search(keyword);
				break;
			case 6:
				displayForward();
				break;
			case 7:
				displayReverse();
				break;
			case 8:
				System.out.print("Enter title to update rating:");
				title=scanner.nextLine();
				System.out.print("Enter new rating:");
				rating=scanner.nextDouble();
				scanner.nextLine();
				updateRating(title,rating);
				break;
			case 0:
				System.out.println("Exiting Movie Management System.");
				break;
			default:
				System.out.println("Invalid choice.Try again.");
			}
		}while(choice!=0);
		scanner.close();
	}
}