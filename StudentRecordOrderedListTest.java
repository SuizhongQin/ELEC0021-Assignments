import java.util.Scanner;

public class StudentRecordOrderedListTest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		StudentRecordOrderedList list = new StudentRecordOrderedList();
		while (true) {
			//print the menu
			System.out.println("1. Introduce a student record");
			System.out.println("2. Remove a student record");
			System.out.println("3. Print a student record: ");
			System.out.println("4. Print all");
			System.out.println("5. Exit");
			System.out.print("Enter you choice: ");
			int choice = Integer.parseInt(keyboard.nextLine());
			switch (choice) {
			case 1://insert new student record
				System.out.print("Enter the surname: ");
				String surname = keyboard.nextLine();
				System.out.print("Enter the name: ");
				String name = keyboard.nextLine();
				System.out.print("Enter the studentNo: ");
				int studentNo = Integer.parseInt(keyboard.nextLine());
				System.out.print("Enter the average mark: ");
				float averageMark = Float.parseFloat(keyboard.nextLine());
				StudentRecord record = new StudentRecord(surname, name, studentNo, averageMark);
				list.insert(record);
				break;
			case 2: //remove a student according to his surname and name
				System.out.print("Enter the surname: ");
				surname = keyboard.nextLine();
				System.out.print("Enter the name: ");
				name = keyboard.nextLine();
				list.remove(new StudentRecord(surname, name, 0, 0));
				break;
			case 3: //find and print a student record according to his surname and name
				System.out.print("Enter the surname: ");
				surname = keyboard.nextLine();
				System.out.print("Enter the name: ");
				name = keyboard.nextLine();
				ListNode node = list.find(new StudentRecord(surname, name, 0, 0));
				if (node != null) {
					System.out.println(list.find(new StudentRecord(surname, name, 0, 0)).data);
				} else {
					System.out.println("Student not found");
				}
				break;
			case 4:// print all student records, one per line
				System.out.println(list);
				break;
			case 5: //exit the program
				keyboard.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}
}

class StudentRecord {
	public String surname;
	public String name;
	public int studentNo;
	public float averageMark;

	public String toString() {
		return surname + " " + name + ", StudentNo: " + studentNo + ", AvgMark: " + averageMark + "\n";
	}

	public StudentRecord(String surname, String name, int studentNo, float averageMark) {
		this.surname = surname;
		this.name = name;
		this.studentNo = studentNo;
		this.averageMark = averageMark;
	}
}

class StudentRecordOrderedList extends OrderedList {
	
	public StudentRecordOrderedList() {
		super("Student record ordered list");
	}
	
	public StudentRecordOrderedList(String listName) {
		super(listName);
	}

	@Override
	protected int compare(Object obj1, Object obj2) {
		String name = ((StudentRecord)obj1).surname + " " + ((StudentRecord)obj1).name;
		String name2 = ((StudentRecord)obj2).surname + " " + ((StudentRecord)obj2).name;
		return name.compareTo(name2);
	}
}
