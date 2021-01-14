
public class Periodical extends Title {
	private int issue;
	private int month;
	
	/**
	 * default constructor which assigns the class's data members both to 0
	 */
	public Periodical() {
		super();
		issue=0;month=0;
	}
	//constructor which sets its parameters to the data members
	public Periodical(String callNumber, String title, String publisher, int year, int copies, int issue, int month) {
		super(callNumber,title,publisher,year,copies);
		this.issue=issue;
		this.month=month;
	}
	
	/**
	 * Getter method for the specified data member
	 * @return issue of type int
	 */
	public int getIssue() {
		return issue;
	}
	/**
	 * Getter method for the specified data member
	 * @return month of type int
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param i issue of type int
	 */
	public void setIssue(int i) {
		issue=i;
	}
	/**
	 * Setter method which assigns its parameter to the specified data member of the class
	 * @param m month of type int
	 */
	public void setMonth(int m) {
		month=m;
	}
	/**
	 * Presents data members in an unlabeled column
	 * @return returns the formatted output
	 */
	public String toString() {
		String output="";
		output+= super.toString()+ issue + "\n" + month + "\n"; 
		return output;
	}
	/**
	 * Presents data members in a labeled column 
	 * @return returns the formatted output
	 */
	public String formattedToString() {
		String output = "";
		
		output+=super.formattedToString() + "Issue: " + issue + "\n" + "Month: " + month +
				"\n";
		
		return output;
	} 
}
