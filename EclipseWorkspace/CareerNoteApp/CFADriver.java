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
		Scanner scanner = new Scanner(System.in);
		
		AppService.welcomeMessage();
		
		boolean running = true;
		do {
			
			AppService.menuOptions();
			displaySortedCompanies(AppService.getCompanies());
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

	public static void displaySortedCompanies(ArrayList<Company> companies) {
		if (!companies.isEmpty()) {
			
			System.out.println();
			System.out.println("~ Company List ~");			
			companies.sort(Comparator.comparing(Company::getName));
			for (int i = 0; i < companies.size(); i++) {
				System.out.printf("%d. %s\n", i+1, companies.get(i).getName());
			}
		}
	}
}