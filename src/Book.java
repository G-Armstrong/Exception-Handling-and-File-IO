
public class Book extends Title {
	private String author;
	private String ISBN;
	
	/**
	 * Default constructor that assings data members to empty strings
	 */
	public Book() {
		super();
		author="";ISBN="";
	}
	
	/**
	 * Construct that assigns its parameters to this class's data members
	 * @param callNumber of type String to be assigned to the the equivalent data member in Title, the super class
	 * @param title of type String to be assigned to the the equivalent data member in Title, the super class
	 * @param publisher of type String to be assigned to the the equivalent data member in Title, the super class
	 * @param year of type int to be assigned to the the equivalent data member in Title, the super class
	 * @param copies of type int to be assigned to the the equivalent data member in Title, the super class
	 * @param author of type String to be assigned to be assigned to this.author
	 * @param isbn of type String to be assigned to be assigned to this.ISBN
	 */
	public Book(String callNumber, String title, String publisher, int year, int copies, String author, String isbn) {
		super(callNumber,title,publisher,year,copies);
		this.author=author;
		this.ISBN=isbn;
	}
	
	/**
	 * Getter method for the specified data member 
	 * @return author of type String
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Getter method for the specified data member 
	 * @return ISBN of type String
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param a author of type String
	 */
	public void setAuthor(String a) {
		author=a;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param isbn ISBN of type String
	 */
	public void setISBN(String isbn) {
		ISBN=isbn;
	}
	/**
	 * Presents data members in an unlabeled column
	 * @return returns the formatted output
	 */
	public String toString() {
		String output="";
		output+= super.toString() + author + "\n" + ISBN + "\n"; 
		return output;
	}
	/**
	 * Presents data members in a labeled column
	 * @return returns the formatted outpu
	 */
	public String formattedToString() {
		String output = "";
		output+=super.formattedToString() + "Author: " + author + "\n" + "ISBN: " + ISBN +
				"\n";
		
		return output;
	} 
}
