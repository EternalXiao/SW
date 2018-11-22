
public class ExamQuestion {
	private String questionText;
	private int maximalMark;
	public ExamQuestion(String questionText,int maximalMark) {
		this.questionText = questionText;
		this.maximalMark = maximalMark;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getMaximalMark() {
		return maximalMark;
	}
	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}
	public String toString() {
		return "Question (Maximal mark: " + this.maximalMark + "): "+this.questionText; 
	}
}
