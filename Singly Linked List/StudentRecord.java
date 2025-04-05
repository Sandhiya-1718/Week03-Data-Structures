import java.util.Scanner;
class Student{
	int rollNo;
	String name;
	int age;
	char grade;
	Student next;
}
public class StudentRecord{
	static Student head=null;
	public static void addStudent(int rollNo,String name,int age,char grade)
	{
		Student newStudent=new Student();
		newStudent.rollNo=rollNo;
		newStudent.name=name;
		newStudent.age=age;
		newStudent.grade=grade;
		newStudent.next=null;
		if(head==null)
			head=newStudent;
		else
		{
			Student temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newStudent;
		}
		System.out.println("Student added.");
	}
	public static void showStudents()
	{
		if(head==null)
		{
			System.out.println("No students to show.");
			return;
		}
		Student temp=head;
		while(temp!=null)
		{
			System.out.println("Roll No:"+temp.rollNo+", Name:"+temp.name+" ,Age:"+temp.age+", Grade:"+temp.grade);
			temp=temp.next;
		}
	}
	public static void searchStudent(int rollNo)
	{
		Student temp=head;
		while(temp!=null)
		{
			if(temp.rollNo==rollNo)
			{
				System.out.println("Found:"+temp.name+", Age:"+temp.age+", Grade:"+temp.grade);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found.");
	}
	public static void deleteStudent(int rollNo)
	{
		if(head==null)
		{
			System.out.println("List is empty.");
			return;
		}
		if(head.rollNo==rollNo)
		{
			head=head.next;
			System.out.println("Student deleted.");
			return;
		}
		Student temp=head;
		while(temp.next!=null)
		{
			if(temp.next.rollNo==rollNo)
			{
				temp.next=temp.next.next;
				System.out.println("Student deleted.");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found.");
	}
	public static void updateGrade(int rollNo,char newGrade)
	{
		Student temp=head;
		while(temp!=null)
		{
			if(temp.rollNo==rollNo)
			{
				temp.grade=newGrade;
				System.out.println("Grade updated.");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found.");
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("\n---Student Menu---");
			System.out.println("1.Add Student");
			System.out.println("2.Show Students");
			System.out.println("3.Search Student");
			System.out.println("4.Delete Student");
			System.out.println("5.Update Grade");
			System.out.println("0.Exit");
			System.out.print("Enter choice:");
			choice=scanner.nextInt();
			scanner.nextLine();
			if(choice==1)
			{
				System.out.print("Enter Roll No:");
				int rollNo=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Name:");
				String name=scanner.nextLine();
				System.out.print("Enter Age:");
				int age=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Grade:");
				char grade=scanner.next().charAt(0);
				scanner.nextLine();
				addStudent(rollNo,name,age,grade);
			}
			else if(choice==2)
				showStudents();
			else if(choice==3)
			{
				System.out.print("Enter Roll No to search:");
				int rollNo=scanner.nextInt();
				scanner.nextLine();
				searchStudent(rollNo);
			}
			else if(choice==4)
			{
				System.out.print("Enter Roll No to delete:");
				int rollNo=scanner.nextInt();
				scanner.nextLine();
				deleteStudent(rollNo);
			}
			else if(choice==5)
			{
				System.out.print("Enter Roll No to update:");
				int rollNo=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Grade:");
				char grade=scanner.next().charAt(0);
				scanner.nextLine();
				updateGrade(rollNo,grade);
			}
			else if(choice!=0)
				System.out.println("Invalid choice.");
		}while(choice!=0);
		scanner.close();
		System.out.println("Program ended.");
	}
}