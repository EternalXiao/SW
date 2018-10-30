/** 
 * Student is a class containing identity, marks breakdown and pass status
 * we define three field variables:
 * <pre>
 *  registrationNumber, the unique number assigned to the student
 *  marks, an array to contain the mark of each assessment
 *  WEIGHT, a known array holds the weight of the corresponding assessment
 * </pre>
 */
public class Student {
	private String registrationNumber;
	private int[] marks = new int[14];
	private static final int[] WEIGHT = {2,2,2,2,1,1,1,1,2,2,1,3,10,70};
	
	/**
	 * The Student constructor to set the registration number 
	 * and marks of a student
	 * @param registrationNumber an unique student number
	 * @param marks all the marks for each assessment
	 */
	public Student(String registrationNumber, int[] marks) {
		this.registrationNumber = registrationNumber;
		this.marks = marks;
	}
	
	/**
	 * Getter method for registration number
	 * @return the registration number
	 */
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
	/**
	 * Getter method for marks
	 * @return all the marks of the student
	 */
	public int[] getMarks() {
		return this.marks;
	}
	
	/**
	 * Setter method for registration number
	 * @param registrationNumber registration number to be assigned
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * Setter method for all marks
	 * @param marks all marks to be set
	 */
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	/**
	 * A method that sets the mark for one specific assignment
	 * @param assignmentNumber the assignment number between 1 and 14
	 * @param mark mark to be set for this assignment
	 */
	public void setAssignmentMark(int assignmentNumber, int mark) {
		this.marks[assignmentNumber-1] = mark;
	}
	
	/**
	 * A method to compute the total mark of a student
	 * @return the total mark rounded to one decimal point
	 */
	public double totalMark() {
		double overallMark = 0;
		int totalWeight = 0;
		//compute the overall mark depends on which assignment has been done
		for (int i = 0; i < marks.length; i++) {
			if (marks[i]!=-1) {
				overallMark += marks[i]*WEIGHT[i];
				totalWeight += WEIGHT[i];
			}
		}
		overallMark = overallMark/totalWeight;
		//round the mark to one decimal point
		double roundedOverallMark = Math.round(overallMark*10)/10.0;
		if (totalWeight < 50) {
			return -1;
		}
		else{
			return roundedOverallMark;
		}
	}
	
	/**
	 * A method to format the print
	 * @return the formated string
	 */
	public String toString() {
		return "Registration Number: " + this.registrationNumber + "\n" +
				"Total Mark: " + this.totalMark() + "\n" +
				"Pass Status: " + this.passed();
	}
	
	/**
	 * A method to check whether the student passes this module
	 * @return pass status either true of false
	 */
	public boolean passed() {
		if (totalMark() == -1) {
			throw new IllegalArgumentException();
		}
		else{
			return totalMark() >= 50;
		}
	}
	
	public static void main(String[] args) {
		int[] samsMarks = {50, 60, 65, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, 54};
		int[] billysMarks = {50, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, 54};
		Student sam = new Student("1",samsMarks);
		Student billy = new Student("2",billysMarks);
		System.out.println(sam);

		System.out.println(billy);

	}
}
