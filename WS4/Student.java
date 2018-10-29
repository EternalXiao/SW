
public class Student {
	private String registrationNumber;
	private int[] marks = new int[14];
	private static final int[] WEIGHT = {2,2,2,2,1,1,1,1,2,2,1,3,70};
	
	public Student(String registrationNumber, int[] marks) {
		this.registrationNumber = registrationNumber;
		this.marks = marks;
	}
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
	public int[] getMarks() {
		return this.marks;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	public void setAssignmentMark(int assignmentNumber, int mark) {
		this.marks[assignmentNumber-1] = mark;
	}
	
	public double totalMark() {
		double overallMark = 0;
		int count = 0;
		for (int i = 0; i < marks.length; i++) {
			if (marks[i]!=-1) {
				overallMark += marks[i]*WEIGHT[i]/100.0;
			}
		}
		return Math.round(overallMark);
	}
	/*public String toString() {
		return 
	}*/
	
	public boolean passed() {
		return totalMark() >= 50;
	}
	
	public static void main(String[] args) {
		int[] samsMarks = {50, 60, 65, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, 54};
		int[] billysMarks = {50, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, 54};
		Student sam = new Student("1",samsMarks);
		Student billy = new Student("2",billysMarks);
		System.out.println(sam.totalMark());
	}
}
