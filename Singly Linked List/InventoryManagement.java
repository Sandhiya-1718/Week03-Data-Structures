import java.util.Scanner;
class Item{
	String itemName;
	int itemId;
	int quantity;
	double price;
	Item next;
}
public class InventoryManagement{
	static Item head=null;
	static Scanner scanner=new Scanner(System.in);
	public static void addItem(String name,int id,int qty,double price)
	{
		Item newItem=new Item();
		newItem.itemName=name;
		newItem.itemId=id;
		newItem.quantity=qty;
		newItem.price=price;
		newItem.next=null;
		if(head==null)
			head=newItem;
		else
		{
			Item temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newItem;
		}
		System.out.println("Item added!");
	}
	public static void addAtBeginning(String name,int id,int qty,double price)
	{
		Item newItem=new Item();
		newItem.itemName=name;
		newItem.itemId=id;
		newItem.quantity=qty;
		newItem.price=price;
		newItem.next=head;
		head=newItem;
		System.out.println("Item added at beginning!");
	}
	public static void addAtPosition(String name,int id,int qty,double price,int pos)
	{
		if(pos==1)
		{
			addAtBeginning(name,id,qty,price);
			return;
		}
		Item newItem=new Item();
		newItem.itemName=name;
		newItem.itemId=id;
		newItem.quantity=qty;
		newItem.price=price;
		Item temp=head;
		for(int i=1;i<pos-1&&temp!=null;i++)
			temp=temp.next;
		if(temp==null)
		{
			System.out.println("Position out of bounds.");
			return;
		}
		newItem.next=temp.next;
		temp.next=newItem;
		System.out.println("Item added at position "+pos);
	}
	public static void removeItem(int id)
	{
		if(head==null)
		{
			System.out.println("Inventory is empty.");
			return;
		}
		if(head.itemId==id)
		{
			head=head.next;
			System.out.println("Item removed.");
			return;
		}
		Item temp=head;
		while(temp.next!=null&&temp.next.itemId!=id)
			temp=temp.next;
		if(temp.next==null)
			System.out.println("Item ID not found");
		else
		{
			temp.next=temp.next.next;
			System.out.println("Item removed.");
		}
	}
	public static void updateQuantity(int id,int newQty)
	{
		Item temp=head;
		while(temp!=null)
		{
			if(temp.itemId==id)
			{
				temp.quantity=newQty;
				System.out.println("Quantity updated.");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Item not found.");
	}
	public static void searchItem(String keyword)
	{
		Item temp=head;
		boolean found=false;
		while(temp!=null)
		{
			if(String.valueOf(temp.itemId).equals(keyword)||temp.itemName.equalsIgnoreCase(keyword))
			{
				System.out.println("Found:"+temp.itemName+", ID:"+temp.itemId+", Qty:"+temp.quantity+", Price:"+temp.price);
				found=true;
			}
			temp=temp.next;
		}
		if(!found)
			System.out.println("Item not found.");
	}
	public static void displayInventory()
	{
		if(head==null)
		{
			System.out.println("No items.");
			return;
		}
		Item temp=head;
		System.out.println("Inventory List:");
		while(temp!=null)
		{
			System.out.println("Name:"+temp.itemName+", ID:"+temp.itemId+", Qty:"+temp.quantity+", Price:"+temp.price);
			temp=temp.next;
		}
	}
	public static void totalInventoryValue()
	{
		double total=0;
		Item temp=head;
		while(temp!=null)
		{
			total+=temp.quantity*temp.price;
			temp=temp.next;
		}
		System.out.println("Total Inventory Value:"+total);
	}
	public static void sortByName(boolean ascending)
	{
		for(Item i=head;i!=null;i=i.next)
		{
			for(Item j=i.next;j!=null;j=j.next)
			{
				if((ascending&&i.itemName.compareToIgnoreCase(j.itemName)>0)||(!ascending&&i.itemName.compareToIgnoreCase(j.itemName)<0))
					swap(i,j);
			}
		}
		System.out.println("Sorted by name "+(ascending?"ascending.":"descending."));
	}
	public static void sortByPrice(boolean ascending)
	{
		for(Item i=head;i!=null;i=i.next)
		{
			for(Item j=i.next;j!=null;j=j.next)
			{
				if((ascending&&i.price>j.price)||(!ascending&&i.price<j.price))
					swap(i,j);
			}
		}
		System.out.println("Sorted by price "+(ascending?"ascending.":"descending."));
	}
	private static void swap(Item a,Item b)
	{
		String name=a.itemName;
		a.itemName=b.itemName;
		b.itemName=name;
		int id=a.itemId;
		a.itemId=b.itemId;
		b.itemId=id;
		int qty=a.quantity;
		a.quantity=b.quantity;
		b.quantity=qty;
		double price=a.price;
		a.price=b.price;
		b.price=price;
	}
	public static void main(String[] args)
	{
		int choice;
		int id;
		String name;
		int qty;
		double price;
		boolean asc;
		int pos;
		String keyword;
		do
		{
			System.out.println("---Inventory Menu---");
			System.out.println("1.Add Item at End");
			System.out.println("2.Add Item at Begining");
			System.out.println("3.Add Item at Position");
			System.out.println("4.Remove Item by ID");
			System.out.println("5.Update Quantity by ID");
			System.out.println("6.Search b ID or Name");
			System.out.println("7.Display Inventory");
			System.out.println("8.Total Inventory Value");
			System.out.println("9.Sort by Name");
			System.out.println("10.Sort by Price");
			System.out.println("0.Exit");
			System.out.print("Enter choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter Name:");
				name=scanner.nextLine();
				System.out.print("Enter ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Quantity:");
				qty=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Price:");
				price=scanner.nextDouble();
				scanner.nextLine();
				addItem(name,id,qty,price);
				break;
			case 2:
				System.out.print("Enter Name:");
				name=scanner.nextLine();
				System.out.print("Enter ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Quantity:");
				qty=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Price:");
				price=scanner.nextDouble();
				scanner.nextLine();
				addAtBeginning(name,id,qty,price);
				break;
			case 3:
				System.out.print("Enter Name:");
				name=scanner.nextLine();
				System.out.print("Enter ID:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Quantity:");
				qty=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Price:");
				price=scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Enter position:");
				pos=scanner.nextInt();
				scanner.nextLine();
				addAtPosition(name,id,qty,price,pos);
				break;
			case 4:
				System.out.print("Enter item ID to remove:");
				id=scanner.nextInt();
				scanner.nextLine();
				removeItem(id);
				break;
			case 5:
				System.out.print("Enter item ID to update:");
				id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("New quantity:");
				qty=scanner.nextInt();
				scanner.nextLine();
				updateQuantity(id,qty);
				break;
			case 6:
				System.out.print("Enter item ID or Name to search:");
				keyword=scanner.nextLine();
				searchItem(keyword);
				break;
			case 7:
				displayInventory();
				break;
			case 8:
				totalInventoryValue();
				break;
			case 9:
				System.out.print("Sort by name(asc=true/desc=false):");
				asc=scanner.nextBoolean();
				scanner.nextLine();
				sortByName(asc);
				break;
			case 10:
				System.out.print("Sort by price(asc=true/desc=false):");
				asc=scanner.nextBoolean();
				scanner.nextLine();
				sortByPrice(asc);
				break;
			case 0:
				System.out.println("Exiting..");
				break;
			default:
				System.out.println("Invalid choice:");
				break;
			}
		}while(choice!=0);
	}
}