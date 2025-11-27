/** 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class CFADriver {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<Company> companies = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
//		welcome message
		welcomeMessage();
		
		boolean running = true;
		do {
			
			menuOptions();
			displaySortedCompanies(companies);
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1: 
					addCompany(scanner, companies);
					break;
				case 2:
					addPrenotes(scanner, companies);
				case 0: 
					running = false;
			}
	//		add a company (also display current list)
	//		- add name
	//		- needs validation for name
	//		show company list in alphabetical order
	//		denote companies with existing note
	//		from list click company
	//		- if prenote exists, show prenote and give option for postnote
	//		postnote questions
	//		exit program
	//		
		} while (running);
		
		scanner.close();
	}

	public static void addPrenotes(Scanner scanner, ArrayList<Company> companies) {
		System.out.println("Which company would you like to add a note for? ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		companies.get(choice).setPrenotes();
	}
	public static void displaySortedCompanies(ArrayList<Company> companies) {
		if (!companies.isEmpty()) {
			
			System.out.println();
			System.out.println("~ Company List ~");			
			companies.sort(Comparator.comparing(Company::getName));
			for (int i = 0; i < companies.size(); i++) {
				System.out.printf("&d. %s/n", i, companies.get(i).getName());
			}
		}
	}
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
}
