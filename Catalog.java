import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Catalog {
	private Title[] titles;
	private int count;
	
	public Catalog() {
		titles = new Title[1000];
		count=0;
	}
	/**
	 * Loads data from file 'filename' and creates instance of objects book and periodical based on the callNumber
	 * @param filename= file to be opened for reading
	 */
	public void loadFromFile(String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file); //open file for reading
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		while(readFile.hasNext()) {
			String callNumber =readFile.nextLine();
			String title,publisher,author,isbn;
			int year,copies,issue,month; 
			
			
			if(callNumber.matches("B-\\d{3}-\\d{3}-\\d{3}")){
				title = readFile.nextLine();
				publisher = readFile.nextLine();
				year = Integer.parseInt(readFile.nextLine());
				copies =Integer.parseInt(readFile.nextLine());
				author = readFile.nextLine();
				isbn=readFile.nextLine();
				Book b= new Book(callNumber, title,publisher,year,copies,author,isbn);
				titles[count++] = b;
			}
			
			
			if(callNumber.matches("P-\\d{3}-\\d{3}-\\d{3}")){
				title = readFile.nextLine();
				publisher = readFile.nextLine();
				year = Integer.parseInt(readFile.nextLine());
				copies =Integer.parseInt(readFile.nextLine());
				issue =Integer.parseInt(readFile.nextLine());
				month =Integer.parseInt(readFile.nextLine());
				Periodical p = new Periodical(callNumber, title, publisher, year, copies, issue, month);
				titles[count++] = p;

			}
		}
		readFile.close();
		
	}
	
	/**
	 * Saves data to file or passes an exception is the file is not found
	 * @param filename= file to be opened for writing and saved 
	 */
	public void saveToFile(String filename) {
		File file = new File(filename);
		PrintWriter writeFile=null;
		try {
			writeFile = new PrintWriter(file); //open for writing
		}
		catch(FileNotFoundException e) {
		//DO I NEED TO WRITE HERE
			//System.out.println("File not found.");
			//System.exit(0);
		}
		for(int i=0; i<count;i++) {
			writeFile.println(titles[i].toString());
		}
		writeFile.close();
	}
	
	/**
	 * Adds an item to the end of the array 't'
	 * @param t= Array of type Title to be appended to
	 */
	public void addItem(Title t) {
		titles[count]=t;
		count++;
		
	}
	
	/**
	 * Removes an item based on the specified callNumber which this method searches fo
	 * @param callNumber of type String to be used in the search process. Once found, the item is removed
	 */
	public void removeItem(String callNumber) {
		for(int i=0;i<count;i++) {
			if(titles[i].getCallNumber() == callNumber) {
				titles[i]=titles[i+1];
				for(int j=i; j<count-1;j++) { //i+1?
					titles[j]=titles[j+1];
					
				}
			}
		}
		titles[count-1] = null;
	}
	/**
	 * Searches the array provided for a single title. If found, it is added to a new array 'titles_3' which is returned
	 * @param title
	 * @return titles_3, a Title[] array containing the title found or the method returns null otherwise
	 */
	public Title[] searchTitle(String title) {
		int j=0;
		Title[] titles_2 = new Title[count];
		
		for (int i=0;i<count;i++) {
			if ((titles[i].getTitle()).matches(title)) {
				
				titles_2[j] = titles[i];
				j++;
				
			}
			
		}
		
		if(j==0) {
			return null;
		}
		

		Title[] titles_3 = new Title[j];
		
		for(int i=0;i<j;i++) {
			titles_3[i] =titles_2[i];
		}
		return titles_3;
	
	}
	
	/**
	 * Searches the array 'titles' for the given callNumber
	 * @param cn of type String to be identified in the array 'titles'
	 * @return returns the Title Object of the specified call number or null otherwise
	 */
	public Title searchCallNumber(String cn) {
		for (int i=0;i<count;i++) {
			if ((titles[i].getCallNumber()).matches(cn)) {
				return titles[i];
			}
			
		}
		return null;
	}
	
	/**
	 * Searches the array 'titles' for the given year
	 * @param year of type int to be searched for with method getYear()
	 * @return and array of type Title[] including all instances of books and periodicals published at the given year
	 */
	public Title[] searchYear(int year) {
		Title[] titles_2 = new Title[count];
		int j=0;
		for (int i=0;i<count;i++) {
			if (titles[i].getYear() == year) {
				titles_2[j] = titles[i];
				j++;
				
			}
			
		}
		
		if(j==0) {
			return null;
		}
		Title[] titles_3 = new Title[j];
		for(int i=0;i<j;i++) {
			titles_3[i] =titles_2[i];
		}
		return titles_3;
	}
	
	/**
	 * View all of the instances in the text file formatted neatly into columns 
	 */
	public void viewAll() {
		
		String output="";
		output+="Call Number\t\tTitle\t\t\t\t\t\t\tPublisher\t\tYear\n";
		
		for(int i=0; i<count;i++) {
			output+=String.format("%-20s\t%-40s\t\t%-20s\t%-4d\n",titles[i].getCallNumber(), titles[i].getTitle(),titles[i].getPublisher(),titles[i].getYear());
			
		}
		System.out.println(output);
	}
}




