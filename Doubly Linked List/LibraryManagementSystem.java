import java.util.Scanner;
class BookNode{
	String title;
	String author;
	String genre;
	int id;
	boolean isAvailable;
	BookNode next,prev;
	public BookNode(String title,String author,String genre,int id,boolean isAvailable)
	{
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.id=id;
		this.isAvailable=isAvailable;
		this.prev=null;
		this.next=null;
	}
}
public class LibraryManagementSystem{
	static BookNode head=null;
	static BookNode tail=null;
	public static void addAtBeginning(String title,String author,String genre,int id,boolean isAvailable)
	{
		BookNode newNode=new BookNode(title,author,genre,id,isAvailable);
		if(head==null)
			head=tail=newNode;
		else
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		System.out.println("Book added at Beginning.");
	}
	public static void addAtEnd(String title,String author,String genre,int id,boolean isAvailable)
	{
		BookNode newNode=new BookNode(title,author,genre,id,isAvailable);
		if(tail==null)
			tail=head=newNode;
		else
		{
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
		}
		System.out.println("Book added at End.");
	}
	public static void addAtPosition(String title,String author,String genre,int id,boolean isAvailable,int position)
	{
		if(position<=0&&head==null)
		{
			addAtBeginning(title,author,genre,id,isAvailable);
			return;
		}
		BookNode newNode=new BookNode(title,author,genre,id,isAvailable);
		BookNode temp=head;
		int count=1;
		while(temp!=null&&count<position-1)
		{
			temp=temp.next;
			count++;
		}
		if(temp==null||temp.next==null)
			addAtEnd(title,author,genre,id,isAvailable);
		else
		{
			newNode.next=temp.next;
			newNode.prev=temp;
			temp.next.prev=newNode;
			temp.next=newNode;
			System.out.println("Book added at position "+position);
		}
	}
	public static void removeById(int id)
	{
		BookNode temp=head;
		while(temp!=null)
		{
			if(temp.id==id)
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
				System.out.println("Book with ID"+id+" removed.");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Book not found.");
	}
	public static void search(String keyword)
	{
		BookNode temp=head;
		boolean found=false;
		while(temp!=null)
		{
			if(temp.title.equalsIgnoreCase(keyword)||temp.author.equalsIgnoreCase(keyword))
			{
				System.out.println("Book Title:"+temp.title+" | Author:"+temp.author+" | Genre:"+temp.genre+" | Book ID:"+temp.id+" | Available:"+(temp.isAvailable?"Yes":"No"));
				found=true;
			}
			temp=temp.next;
		}
		if(!found)
			System.out.println("No books found for "+keyword+".");
	}
	public static void updateAvailability(int id,boolean newStatus)
	{
		BookNode temp=head;
		while(temp!=null)
		{
			if(temp.id==id)
			{
				temp.isAvailable=newStatus;
				System.out.println("Availability status updated to Book ID "+temp.id);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Book ID not found.");
	}
	public static void displayForward()
	{
		if(head==null)
		{
			System.out.println("Library is empty.");
			return;
		}
		System.out.println("Books(forward):");
		BookNode temp=head;
		while(temp!=null)
		{
			System.out.println("Book Title:"+temp.title+" | Author:"+temp.author+" | Genre:"+temp.genre+" | Book ID:"+temp.id+" | Available:"+(temp.isAvailable?"Yes":"No"));
			temp=temp.next;
		}
	}
	public static void displayReverse()
	{
		if(tail==null)
		{
			System.out.println("Library is empty.");
			return;
		}
		System.out.println("Books(reverse):");
		BookNode temp=tail;
		while(tail!=null)
		{
			System.out.println("Book Title:"+temp.title+" | Author:"+temp.author+" | Genre:"+temp.genre+" | Book ID:"+temp.id+" | Available:"+(temp.isAvailable?"Yes":"No"));
			temp=temp.prev;
		}
	}
	public static void countBooks()
	{
		int count=0;
		BookNode temp=head;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		System.out.println("Total number of books:"+count);
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("----Library Management System----");
			System.out.println("1.Add Book at Beginning");
			System.out.println("2.Add Book at End");
			System.out.println("3.Add Book at Specific Position");
			System.out.println("4.Remove Book by Title");
			System.out.println("5.Search by Title or Author");
			System.out.println("6.Update Movie Availability by Id");
			System.out.println("7.Display all Books(Forward)");
			System.out.println("8.Display all Books(Reverse)");
			System.out.println("9.Count Total Books");
			System.out.println("0.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			String title;
			String author;
			String genre;
			int id;
			boolean isAvailable;
			int position;
			switch(choice)
			{
			case 1:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter author:");
				author=scanner.nextLine();
				System.out.print("Enter genre:");
				genre=scanner.nextLine();
				System.out.print("Enter book ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Is Available(true/false):");
				isAvailable=scanner.nextBoolean();
				scanner.nextLine();
				addAtBeginning(title,author,genre,id,isAvailable);
				break;
			case 2:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter author:");
				author=scanner.nextLine();
				System.out.print("Enter genre:");
				genre=scanner.nextLine();
				System.out.print("Enter book ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Is Available(true/false):");
				isAvailable=scanner.nextBoolean();
				scanner.nextLine();
				addAtEnd(title,author,genre,id,isAvailable);
				break;
			case 3:
				System.out.print("Enter title:");
				title=scanner.nextLine();
				System.out.print("Enter author:");
				author=scanner.nextLine();
				System.out.print("Enter genre:");
				genre=scanner.nextLine();
				System.out.print("Enter book ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Is Available(true/false):");
				isAvailable=scanner.nextBoolean();
				scanner.nextLine();
				System.out.println("Enter position:");
				position=scanner.nextInt();
				scanner.nextLine();
				addAtPosition(title,author,genre,id,isAvailable,position);
				break;
			case 4:
				System.out.print("Enter book ID to remove:");
				id=scanner.nextInt();
				scanner.nextLine();
				removeById(id);
				break;
			case 5:
				System.out.print("Enter title or author to search:");
				String keyword=scanner.nextLine();
				search(keyword);
				break;
			case 6:
				System.out.print("Enter book ID to update availability:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Is available(true/false):");
				isAvailable=scanner.nextBoolean();
				scanner.nextLine();
				updateAvailability(id,isAvailable);
				break;
			case 7:
				displayForward();
				break;
			case 8:
				displayReverse();
				break;
			case 9:
				countBooks();
				break;
			case 0:
				System.out.println("Exiting Library Management System.");
				break;
			default:
				System.out.println("Invalid choice.Try again.");
			}
		}while(choice!=0);
		scanner.close();
	}
}