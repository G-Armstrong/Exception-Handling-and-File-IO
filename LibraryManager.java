
import java.util.InputMismatchException;
import java.util.Scanner;
public class LibraryManager {
	//main method
	public static void main(String[] args) {
	
		Catalog myLibrary=new Catalog();
		myLibrary.loadFromFile("titles.txt");
		
		
		Scanner keyboard = new Scanner(System.in);
		int operation =0;
		String callNumber,title,publisher,response,author,isbn;
		int year,copies,issue,month;
		
		do {
			printMenu();
			try {
			operation= keyboard.nextInt();
			switch(operation) {
			case 1: //Find a title with a given call Number
				System.out.println("Enter the Call Number:");
				keyboard.nextLine();
				callNumber = keyboard.nextLine();
				checkCallNumber(callNumber);
				Title title_case1 = myLibrary.searchCallNumber(callNumber);
				if(title_case1 ==null) {
					System.out.println("Title with call number " + callNumber + " not found.");
				}
				else {
					System.out.println("Title found.");
					System.out.println(title_case1.formattedToString());
				}
				break;
			case 2: //Find titles with a given title
				
				System.out.println("Enter the Title:");
				keyboard.nextLine();
				title=keyboard.nextLine();
				
				Title[] titles_3 = myLibrary.searchTitle(title);
				if(titles_3 ==null) {
					System.out.println("No titles found.");
					break;
				}
				else {
					System.out.println("List of titles found: " + titles_3.length);
				}
				
				String output="";
				output+="Call Number\t\tTitle\t\t\t\t\t\t\tPublisher\t\tYear\n";
				
				for(int i=0; i<titles_3.length;i++) {
					output+=String.format("%-20s\t%-40s\t\t%-20s\t%-4d\n",titles_3[i].getCallNumber(), 
							titles_3[i].getTitle(),titles_3[i].getPublisher(),titles_3[i].getYear());
	
				}
				System.out.println(output);
				break;
			case 3: //Find titles with a given year
				System.out.println("Enter the year of the title.");
				year=keyboard.nextInt();
				checkYear(year);
				Title[] titles_4 = myLibrary.searchYear(year);
				if(titles_4 ==null) {
					System.out.println("No titles found with that year.");
					break;
				}
				else {
					System.out.println("List of titles found: " + titles_4.length);
				}
				
				String output2="";
				output2+="Call Number\t\tTitle\t\t\t\t\t\t\tPublisher\t\tYear\n";
				
				for(int i=0; i<titles_4.length;i++) {
					output2+=String.format("%-20s\t%-40s\t\t%-20s\t%-4d\n",titles_4[i].getCallNumber(), 
							titles_4[i].getTitle(),titles_4[i].getPublisher(),titles_4[i].getYear());
	
				}
				System.out.println(output2);
				break;
			case 4: //Add a new title
				System.out.println("Enter the Title:");
				keyboard.nextLine();
				title=keyboard.nextLine();
				System.out.println("Enter the Publisher:");
				keyboard.nextLine();
				publisher=keyboard.nextLine();
				System.out.println("Enter the Year:");
				year=keyboard.nextInt();
				checkYear(year);
				System.out.println("Enter the number of copies:");
				copies=keyboard.nextInt();
				System.out.println("Is this a book or a periodical? (book/periodical)");
				keyboard.nextLine();
				response=keyboard.nextLine();
				
				if(response.equals("book")) {
					System.out.println("Enter the call number:");
					callNumber = keyboard.nextLine();
					checkCallNumber(callNumber);
					System.out.println("Enter the author:");
					author=keyboard.nextLine();
					System.out.println("Enter the ISBN:");
					isbn=keyboard.nextLine();
					
					Title new_book = new Book(callNumber, title, publisher, year, copies, author, isbn);
					myLibrary.addItem(new_book);
					myLibrary.saveToFile("titles.txt");
				}
				
				if(response.equals("periodical")) {
					System.out.println("Enter the call number:");
					callNumber = keyboard.nextLine();
					checkCallNumber(callNumber);
					System.out.println("Enter the issue:");
					issue = keyboard.nextInt();
					System.out.println("Enter the call issued month:");
					month = keyboard.nextInt();
					checkMonth(month);
					
					Title new_periodical = new Periodical(callNumber, title, publisher, year, copies, issue, month);
					myLibrary.addItem(new_periodical);
					myLibrary.saveToFile("titles.txt");
				}
				
				break;
			case 5: //Remove a title with a given call number
				System.out.println("Enter the call number:");
				keyboard.nextLine();
				callNumber = keyboard.nextLine();
				checkCallNumber(callNumber);
				myLibrary.removeItem(callNumber);
				break;
			case 6: //View the list of titles in the library (call number, title, publisher, year)
				myLibrary.viewAll();  
				break;
			case 7: //Exit the program
				myLibrary.saveToFile("titles.txt");
				break;
					
				}
			}
			

			catch(InvalidDate e) {
				System.out.println(e.getMessage());
			}
			
			catch(InvalidCallNumber e) {
				System.out.println(e.getMessage());
			}
			
			catch(InputMismatchException e) {
				
			}
			
			
			
			
			
		}while (operation!=7);
		keyboard.close();
		
		
	}
	
	/**
	 * Prints the menu of options for the user to pick from. Options are executed in the main method's switch
	 */
	public static void printMenu() {
		System.out.println("Select an operation:");
		System.out.println("1: Find Title");
		System.out.println("2: Search by Title");
		System.out.println("3: Search by Year");
		System.out.println("4: Add Title");
		System.out.println("5: Remove Title");
		System.out.println("6: View All Titles");
		System.out.println("7: Exit");
		
	}
	
	/**
	 * Checks the call number for the correct output or throws an exception
	 * @param cn Call number of type String to be checked
	 * @throws InvalidCallNumber throws exception if the call number does not match the regular expression
	 */
	public static void checkCallNumber(String cn) throws InvalidCallNumber{
		if(!cn.matches(".-\\d{3}-\\d{3}-\\d{3}")) {
			throw new InvalidCallNumber("Invalid call number – Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
		}
	}
	
	/**
	 * Checks the year value passed to the method for the correct range or throws an exception
	 * @param yr year value of type int to be checked
	 * @throws InvalidDate throws excpetion if the year is not with the range
	 */
	public static void checkYear(int yr) throws InvalidDate{
		Integer Year = yr; //autoboxing
		if(Year<1900 || Year>2020)
			throw new InvalidCallNumber("Invalid year – must be from 1900 to 2020");
	}
	
	/**
	 * Checks the month value passed to the method for the correct range
	 * @param month Month value of type int to be checked
	 * @throws InvalidDate throws exception if the month is not within the range
	 */
	public static void checkMonth(int month) throws InvalidDate{
		Integer Month = month; //autoboxing
		if(Month<1 || Month>12)
			throw new InvalidCallNumber("Invalid month – must be from 1 to 12");
	}
	
	
}


