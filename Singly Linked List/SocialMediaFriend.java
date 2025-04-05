import java.util.Scanner;
import java.util.ArrayList;
class User{
	int userId;
	String name;
	int age;
	ArrayList<Integer>friendIds;
	User next;
	User(int userId,String name,int age)
	{
		this.userId=userId;
		this.name=name;
		this.age=age;
		this.friendIds=new ArrayList<>();
		this.next=null;
	}
}
public class SocialMediaFriend{
	static User head=null;
	static Scanner scanner=new Scanner(System.in);
	public static void addUser(int id,String name,int age)
	{
		User newUser=new User(id,name,age);
		if(head==null)
			head=newUser;
		else
		{
			User temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newUser;
		}
		System.out.println("User added!");
	}
	public static User searchById(int id)
	{
		User temp=head;
		while(temp!=null)
		{
			if(temp.userId==id)
				return temp;
			temp=temp.next;
		}
		return null;
	}
	public static void addFriendConnection(int id1,int id2)
	{
		User user1=searchById(id1);
		User user2=searchById(id2);
		if(user1==null||user2==null)
		{
			System.out.println("One or both users or not found.");
			return;
		}
		if(!user1.friendIds.contains(id2))
			user1.friendIds.add(id2);
		if(!user2.friendIds.contains(id1))
			user2.friendIds.add(id1);
		System.out.println("Friend connection added between "+id1+" and "+id2);
	}
	public static void removeFriendConnection(int id1,int id2)
	{
		User user1=searchById(id1);
		User user2=searchById(id2);
		if(user1==null||user2==null)
		{
			System.out.println("One or both users or not found.");
			return;
		}
		user1.friendIds.remove((Integer)id2);
		user2.friendIds.remove((Integer)id1);
		System.out.println("Friend connection removed between "+id1+" and "+id2);
	}
	public static void displayFriends(int id)
	{
		User user=searchById(id);
		if(user==null)
		{
			System.out.println("User not found.");
			return;
		}
		System.out.println("Friends of "+user.name+":");
		for(int i=0;i<user.friendIds.size();i++)
		{
			int friendId=user.friendIds.get(i);
			User friend=searchById(friendId);
			if(friend!=null)
				System.out.println(friend.name+"(ID:"+friend.userId+")");
		}
	}
	public static void searchUser(String keyword)
	{
		User temp=head;
		boolean found=false;
		while(temp!=null)
		{
			if(temp.name.equalsIgnoreCase(keyword)||String.valueOf(temp.userId).equals(keyword))
			{
				System.out.println("User found:"+temp.name+" | ID:"+temp.userId+" | Age:"+temp.age);
				found=true;
			}
			temp=temp.next;
		}
		if(!found)
			System.out.println("User not found.");
	}
	public static void countFriendForAll()
	{
		User temp=head;
		while(temp!=null)
		{
			System.out.println(temp.name+" has "+temp.friendIds.size()+"  friend(s).");
			temp=temp.next;
		}
	}
	public static void findMutualFriends(int id1,int id2)
	{
		User user1=searchById(id1);
		User user2=searchById(id2);
		if(user1==null||user2==null)
		{
			System.out.println("One or both users not found.");
			return;
		}
		System.out.println("Mutual Friends:");
		boolean hasMutual=false;
		for(int i=0;i<user1.friendIds.size();i++)
		{
			int friendId=user1.friendIds.get(i);
			if(user2.friendIds.contains(friendId))
			{
				User mutual=searchById(friendId);
				if(mutual!=null)
				{
					System.out.println(mutual.name+"(ID:"+mutual.userId+")");
					hasMutual=true;
				}
			}
		}
		if(!hasMutual)
			System.out.println("No mutual friends.");
	}
	public static void main(String[] args)
	{ 
		int choice;
		do
		{
			System.out.println("---Social Media Friend System---");
			System.out.println("1.Add User");
			System.out.println("2.Add Friend Connection");
			System.out.println("3.Remove Friend Connection");
			System.out.println("4.Display Friends");
			System.out.println("5.Search User");
			System.out.println("6.Count Friends for All Users");
			System.out.println("7.Find Mutual Friends");
			System.out.println("0.Exit");
			System.out.print("Enter your choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter user ID:");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Name:");
				String name=scanner.nextLine();
				System.out.print("Enter Age:");
				int age=scanner.nextInt();
				scanner.nextLine();
				addUser(id,name,age);
				break;
			case 2:
				System.out.print("Enter your ID:");
				int id1=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter friend's ID:");
				int id2=scanner.nextInt();
				scanner.nextLine();
				addFriendConnection(id1,id2);
				break;
			case 3:
				System.out.print("Enter your ID:");
				int rid1=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter friend's ID to remove:");
				int rid2=scanner.nextInt();
				scanner.nextLine();
				removeFriendConnection(rid1,rid2);
				break;
			case 4:
				System.out.print("Enter your ID:");
				int fid=scanner.nextInt();
				scanner.nextLine();
				displayFriends(fid);
				break;
			case 5:
				System.out.print("Enter Name or ID to search:");
				String keyword=scanner.nextLine();
				searchUser(keyword);
				break;
			case 6:
				countFriendForAll();
				break;
			case 7:
				System.out.print("Enter first user ID:");
				int uid1=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter second user ID:");
				int uid2=scanner.nextInt();
				scanner.nextLine();
				findMutualFriends(uid1,uid2);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=0);
	}
}