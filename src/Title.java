
public class Title {
	private String callNumber;
	private String title;
	private String publisher;
	private int year;
	private int copies;
	
	/**
	 * default constructor which sets data members to base values
	 */
	public  Title() {
		callNumber ="";title="";publisher="";year=0;copies=0;
	}
	
	//constructor which sets its parameters to the data members
	public Title(String callNumber, String title, String publisher, int year, int copies) {
		this.callNumber=callNumber;this.title=title;this.publisher=publisher;this.year=year;
		this.copies=copies;
	}
	
	/**
	 * Getter method for the specified data member
	 * @return callNumber of type String
	 */
	public String getCallNumber() {
		return callNumber;
	}
	/**
	 * Getter method for the specified data member
	 * @return title of type String
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Getter method for the specified data member
	 * @return publisher of type String
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Getter method for the specified data member
	 * @return year of type int
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Getter method for the specified data member
	 * @return
	 */
	public int getCopies() {
		return copies;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param cn CallNumber of type String
	 */
	public void setCallNumber(String cn) {
		callNumber = cn;
		
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param t Title of type String
	 */
	public void setTitle(String t) {
		title=t;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param p Publisher of type String
	 */
	public void setPublisher(String p) {
		publisher = p;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param y year of type int
	 */
	public void setYear(int y) {
		year =y;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param c copies value of type int
	 */
	public void setCopies(int c) {
		copies =c;
	}
	/**
	 * Presents data members in an unlabeled column
	 * @return returns the formatted output
	 */
	public String toString() {
		String output="";
		output+= callNumber + "\n" + title + "\n" + publisher 
				+ "\t" + year + "\n";
		return output;
	}
	/**
	 * Presents data members in a labeled column 
	 * @return returns the formatted output
	 */
	public String formattedToString() {
		String output = "";
		
		output+="Call Number: " + callNumber + "\n" + "Title: " + title +
				"\n" + "Publisher: " + publisher + "\n"+"Year: " + year + "\n" + "Copies: " 
				+ copies + "\n";
		
		return output;
	}
}
