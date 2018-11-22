
public class ExamQuestionNumeric extends ExamQuestion{
	private int answer;

	public ExamQuestionNumeric(String questionText, int maximalMark, int answer) {
		super(questionText, maximalMark);
		this.answer = answer;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int mark(int value) {
		if(this.answer == value) return this.getMaximalMark();
		else return 0;
	}
	public String toString() {
		return super.toString() + " Correct answer is: " + this.answer;
	}
}
