import java.util.Scanner;
public class CustomHashMapApp {
    static class Node
	{
        int key;
        String value;
        Node next;
        Node(int key,String value) {
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    static class CustomHashMap
	{
		final int size=10;
        Node buckets[]=new Node[size];
        int getIndex(int key)
		{
            return key%size;
		}
        void put(int key,String value)
		{
            int index=getIndex(key);
            Node head=buckets[index];
            for(Node curr=head;curr!=null;curr=curr.next)
			{
                if(curr.key==key)
				{
                    curr.value=value;
                    return;
                }
            }
            Node newNode=new Node(key, value);
            newNode.next=head;
            buckets[index]=newNode;
        }
        String get(int key)
		{
            int index=getIndex(key);
            for (Node curr=buckets[index];curr!=null;curr=curr.next)
			{
                if(curr.key==key)
                    return curr.value;
            }
            return null;
        }
        void remove(int key)
		{
            int index=getIndex(key);
            Node curr=buckets[index];
            Node prev=null;
            while(curr!=null)
			{
                if(curr.key==key)
				{
                    if(prev==null)
                        buckets[index]=curr.next;
                    else
                        prev.next=curr.next;
                    return;
                }
                prev=curr;
                curr=curr.next;
            }
        }
        void display()
		{
            for(int i=0;i<size; i++)
			{
                System.out.print("Bucket "+i+": ");
                Node curr=buckets[i];
                while(curr!=null)
				{
                    System.out.print("["+curr.key+"="+curr.value+"] -> ");
                    curr=curr.next;
                }
                System.out.println("null");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CustomHashMap map=new CustomHashMap();
        int choice;
        do 
		{
            System.out.println("\n--- Custom HashMap Menu ---");
            System.out.println("1.Insert (put)");
            System.out.println("2.Get (retrieve)");
            System.out.println("3.Remove");
            System.out.println("4.Display map");
            System.out.println("5.Exit");
            System.out.print("Enter your choice:");
            choice=sc.nextInt();
            switch(choice)
			{
			case 1:
				System.out.print("Enter key (int): ");
				int key=sc.nextInt();
				sc.nextLine(); 
				System.out.print("Enter value (string): ");
				String value=sc.nextLine();
				map.put(key,value);
				break;
			case 2:
                System.out.print("Enter key to get value: ");
                int getKey=sc.nextInt();
                String getValue=map.get(getKey);
                if(getValue!=null) 
                    System.out.println("Value: "+getValue);
                else
                    System.out.println("Key not found.");
                break;
			case 3:
                System.out.print("Enter key to remove: ");
				int removeKey=sc.nextInt();
				map.remove(removeKey);
				System.out.println("Removed (if key existed).");
			case 4:
				map.display();
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=5);
		sc.close();
	}
}
