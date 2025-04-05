import java.util.Scanner;
class TextState{
	String content;
	TextState prev;
	TextState next;
	public TextState(String content)
	{
		this.content=content;
	}
}
public class TextEditor{
	private TextState current;
	private int size=0;
	private final int maxHistory=10;
	public void addState(String content)
	{
		TextState newState=new TextState(content);
		if(current!=null&&current.next!=null)
		{
			current.next.prev=null;
			current.next=null;
		}
		newState.prev=current;
		if(current!=null)
			current.next=newState;
		current=newState;
		size++;
		trimHistory();
	}
	public void addText(String newText)
	{
		if(current==null)
			addState(newText);
		else
			addState(current.content+newText);
	}
	public void undo()
	{
		if(current!=null&&current.prev!=null)
		{
			current=current.prev;
			System.out.println("Undo performed.");
		}
		else
			System.out.println("No more undo steps.");
	}
	public void redo()
	{
		if(current!=null&&current.next!=null)
		{
			current=current.next;
			System.out.println("Redo performed.");
		}
		else 
			System.out.println("No more redo steops.");
	}
	public void showCurrentState()
	{
		if(current!=null)
			System.out.println("Current State:"+current.content);
		else
			System.out.println("Editor is empty.");
	}
	private void trimHistory()
	{
		int count=0;
		TextState temp=current;
		while(temp!=null)
		{
			count++;
			temp=temp.prev;
		}
		if(count>maxHistory)
		{
			TextState oldest=current;
			for(int i=0;i<maxHistory-1;i++)
				oldest=oldest.prev;
			if(oldest.prev!=null)
			{
				oldest.prev.next=null;
				oldest.prev=null;
			}
		}
	}
	public static void main(String[] args)
	{
		TextEditor editor=new TextEditor();
		Scanner scanner=new Scanner(System.in);
		int choice;
		do{
			System.out.println("---Text Editor Menu---");
			System.out.println("1.Type text");
			System.out.println("2.Undo");
			System.out.println("3.Redo");
			System.out.println("4.Show current text");
			System.out.println("5.Exit");
			System.out.print("Enter choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter text to add:");
				String newText=scanner.nextLine();
				editor.addText(newText);
				break;
			case 2:
				editor.undo();
				break;
			case 3:
				editor.redo();
				break;
			case 4:
				editor.showCurrentState();
				break;
			case 5:
				System.out.println("Exiting editor.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice!=5);
		scanner.close();
	}
}