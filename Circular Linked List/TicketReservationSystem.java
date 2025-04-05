import java.util.Scanner;
class Ticket{
	int ticketId;
	String customerName;
	String movieName;
	String seatNumber;
	String bookingTime;
	Ticket next;
	public Ticket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime)
	{
		this.ticketId=ticketId;
		this.customerName=customerName;
		this.movieName=movieName;
		this.seatNumber=seatNumber;
		this.bookingTime=bookingTime;
	}
}
public class TicketReservationSystem{
	Ticket head=null;
	Ticket tail=null;
	public void addTicket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime)
	{
		Ticket newTicket=new Ticket(ticketId,customerName,movieName,seatNumber,bookingTime);
		if(head==null)
		{
			head=tail=newTicket;
			newTicket.next=head;
		}
		else
		{
			tail.next=newTicket;
			newTicket.next=head;
			tail=newTicket;
		}
		System.out.println("Ticket booked successfully!");
	}
	public void removeTicket(int ticketId)
	{
		if(head==null)
		{
			System.out.println("No tickets booked.");
			return;
		}
		Ticket current=head;
		Ticket prev=tail;
		boolean found=false;
		do
		{
			if(current.ticketId==ticketId)
			{
				found=true;
				if(current==head)
				{
					head=head.next;
					tail.next=head;
				}
				else if(current==tail)
				{
					tail=prev;
					tail.next=head;
				}
				else
					prev.next=current.next;
				if(current==head&&current==tail)
					head=tail=null;
				System.out.println("Ticket removed successfully.");
				return;
			}
			prev=current;
			current=current.next;
		}while(current!=head);
		if(!found)
			System.out.println("Ticket ID not found.");
	}
	public void displayTickets()
	{
		if(head==null)
		{
			System.out.println("No tickets booked.");
			return;
		}
		Ticket temp=head;
		System.out.println("---Booked Tickets---");
		do
		{
			System.out.println("Ticker ID:"+temp.ticketId+", Customer:"+temp.customerName+", Movie:"+temp.movieName+", Seat:"+temp.seatNumber+", Time:"+temp.bookingTime);
			temp=temp.next;
		}while(temp!=head);
	}
	public void searchTicket(String keyword)
	{
		if(head==null)
		{
			System.out.println("No tickets booked.");
			return;
		}
		Ticket temp=head;
		boolean found=false;
		do
		{
			if(temp.customerName.equalsIgnoreCase(keyword)||temp.movieName.equalsIgnoreCase(keyword))
			{
				System.out.println("Ticker ID:"+temp.ticketId+", Customer:"+temp.customerName+", Movie:"+temp.movieName+", Seat:"+temp.seatNumber+", Time:"+temp.bookingTime);
				found=true;
			}
			temp=temp.next;
		}while(temp!=head);
		if(!found)
			System.out.println("No ticket found for "+keyword+".");
	}
	public void countTickets()
	{
		if(head==null)
		{
			System.out.println("Total tickets booked:0");
			return;
		}
		Ticket temp=head;
		int count=0;
		do
		{
			count++;
			temp=temp.next;
		}while(temp!=head);
		System.out.println("Total tickets booked:"+count);
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		TicketReservationSystem ticket=new TicketReservationSystem();
		int choice;
		do
		{
			System.out.println("---Online Ticket Reservation Menu---");
			System.out.println("1.Book a Ticket");
			System.out.println("2.Remove Ticket by ID");
			System.out.println("3.Display All Tickets");
			System.out.println("4.Search by Customer or Movie");
			System.out.println("5.Total Tickets Count");
			System.out.println("6.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter Ticket ID:");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Customer Name:");
				String customer=scanner.nextLine();
				System.out.print("Enter Movie Name:");
				String movie=scanner.nextLine();
				System.out.print("Enter Sear Number:");
				String seat=scanner.nextLine();
				System.out.print("Enter Booking Time:");
				String time=scanner.nextLine();
				ticket.addTicket(id,customer,movie,seat,time);
				break;
			case 2:
				System.out.print("Enter Ticket ID to remove:");
				int removeId=scanner.nextInt();
				scanner.nextLine();
				ticket.removeTicket(removeId);
				break;
			case 3:
				ticket.displayTickets();
				break;
			case 4:
				System.out.print("Enter Customer or Movie Name:");
				String keyword=scanner.nextLine();
				ticket.searchTicket(keyword);
				break;
			case 5:
				ticket.countTickets();
				break;
			case 6:
				System.out.println("Exiting system..");
				break;
			default:
				System.out.println("Invalid choice.Try again");
			}
		}while(choice!=6);
		scanner.close();
	}
}