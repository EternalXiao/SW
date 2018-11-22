import java.util.ArrayList;

public class ExamQuestionSimpleChoice extends ExamQuestion{
	private ArrayList<String> possibleAnswers = new ArrayList<>();
	private int correctAnswer;
	
	public ExamQuestionSimpleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			int correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}
	public ArrayList<String> getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(ArrayList<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int mark(int value) {
		if(this.correctAnswer == value) return this.getMaximalMark();
		else return 0;
	}
	public String toString() {
		return super.toString() + "\n" +"Possible answers are: " + this.getPossibleAnswers().toString() +
				"\n" +"Correct answer position is: " + this.getCorrectAnswer();
	}
	
	
}
