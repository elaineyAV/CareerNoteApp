/**
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class AppService {
	/**
	 * @param args
	 */

	public static void welcomeMessage() {
		System.out.println("Welcome to the Career Fair Notetaking App!");
	}
	
	public static void menuOptions() {
		System.out.println();
		System.out.println("Select menu option:");
		System.out.println("1. Add company");
		System.out.println("2. Add notes");
		System.out.println("0. Exit");
		
	}
	
	public ArrayList<Company> getCompanyList() {
		return companies;
	}
	
	public static void addCompany(Scanner scanner, ArrayList<Company> companies) {
		boolean addMore = true;
		do {
			System.out.println("What is the company name?");
			String compName = scanner.nextLine();
			Company newCompany = new Company(compName);
			companies.add(newCompany);
			
			System.out.println("Add another company? Y/N");
			char answer = scanner.next().charAt(0);
			if (answer == 'N' || answer == 'n') {
				addMore = false;
			}
			scanner.nextLine();
		} while (addMore); 
	}
	public static void addPrenotes(Scanner scanner, ArrayList<Company> companies) {
		System.out.println("Which company would you like to add a note for? ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		companies.get(choice).setPrenotes();
	}
}
		
