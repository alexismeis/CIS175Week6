import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Sep 29, 2022
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();
	
	private static void addAnItem() {
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter a letter grade: ");
		String grade = in.nextLine();
		ListItem toAdd = new ListItem(name, grade);
		lih.insertItem(toAdd);
	}
	
	private static void deleteAnItem() {
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the letter grade to delete: ");
		String grade = in.nextLine();
		ListItem toDelete = new ListItem(name, grade);
		lih.deleteItem(toDelete);
	}
	
	public static void editAnItem() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Letter Grade");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListItem> foundItems;
		if(searchBy == 1) {
			System.out.print("Enter the name: ");
			String name = in.nextLine();
			foundItems = lih.searchForItemByName(name);
		} else {
			System.out.print("Enter the letter grade: ");
			String letterGrade = in.nextLine();
			foundItems = lih.searchForItemByGrade(letterGrade);
		}
		
		if(!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for(ListItem l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			
			ListItem toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrived " + toEdit.getGrade() + " from " + toEdit.getName());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Letter Grade");
			int update = in.nextInt();
			in.nextLine();
			
			if(update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Letter Grade: ");
				String newGrade = in.nextLine();
				toEdit.setGrade(newGrade);
			}
			
			lih.updateItem(toEdit);
		} else {
			System.out.println("---- No results found");
		}
	}
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println(" --- Welcome to our gradebook! --- ");
		while(goAgain) {
			System.out.println("* Select an item:");
			System.out.println("* 1 -- Add an item");
			System.out.println("* 2 -- Edit an item");
			System.out.println("* 3 -- Delete an item");
			System.out.println("* 4 -- View the list");
			System.out.println("* 5 -- Exit the program");
			int selection = in.nextInt();
			in.nextLine();
			
			if(selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("    Goodbye    ");
				goAgain = false;
			}
		}
	}
	
	private static void viewTheList() {
		List<ListItem> allItems = lih.showAllItems();
		for(ListItem singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}
	}
}
