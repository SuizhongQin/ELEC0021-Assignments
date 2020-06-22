import java.util.Scanner;

public class IntStrOrderedListTest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		IntegerOrderedList intList = new IntegerOrderedList();
		StringOrderedList sList = new StringOrderedList();
		while (true) {
			System.out.println("1. Enter numbers/strings");
			System.out.println("2. Print the appropriate list");
			System.out.println("3. Remove a number/string");
			System.out.println("4. Exit");
			System.out.print("Enter you choice: ");
			int choice = Integer.parseInt(keyboard.nextLine());
			switch (choice) {
			case 1:
				System.out.print("Enter a number/string to insert: ");
				String line = keyboard.nextLine();
				try {
					int number = Integer.parseInt(line);
					intList.insert(number);
				} catch (NumberFormatException e) {
					sList.insert(line);
				}
				break;
			case 2:
				System.out.println(intList.toString());
				System.out.println(sList.toString());
				break;
			case 3:
				System.out.print("Enter a number/string to remove: ");
				line = keyboard.nextLine();
				try {
					int number = Integer.parseInt(line);
					intList.remove(number);
				} catch (NumberFormatException e) {
					sList.remove(line);
				}
				break;
			case 4:
				keyboard.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}
}

class StringOrderedList extends OrderedList {
	
	public StringOrderedList() {
		super("String ordered list");
	}
	
	public StringOrderedList(String listName) {
		super(listName);
	}

	@Override
	protected int compare(Object obj1, Object obj2) {
		return ((String)obj1).compareTo(((String)obj2));
	}
}

class IntegerOrderedList extends OrderedList {
	
	public IntegerOrderedList() {
		super("Integer ordered list");
	}
	
	public IntegerOrderedList(String listName) {
		super(listName);
	}

	@Override
	protected int compare(Object obj1, Object obj2) {
		return ((Integer)obj1).intValue() - ((Integer)obj2).intValue();
	}
}