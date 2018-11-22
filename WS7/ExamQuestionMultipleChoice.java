import java.util.ArrayList;

public class ExamQuestionMultipleChoice extends ExamQuestion{
	private ArrayList<String> possibleAnswer;
	private ArrayList<Integer> correctAnswer;
	public ExamQuestionMultipleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswer,
			ArrayList<Integer> correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswer = possibleAnswer;
		this.correctAnswer = correctAnswer;
	}
	public ArrayList<String> getPossibleAnswer() {
		return possibleAnswer;
	}
	public void setPossibleAnswer(ArrayList<String> possibleAnswer) {
		this.possibleAnswer = possibleAnswer;
	}
	public ArrayList<Integer> getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(ArrayList<Integer> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int mark(ArrayList<Integer> answersProvided) {
		int correctChoice=0;
		int wrongChoice = 0;
		for(int e:answersProvided) {
			if (correctAnswer.contains(e)) correctChoice++;
			else wrongChoice++;
		}
		return this.getMaximalMark()*(correctChoice-wrongChoice)/correctAnswer.size();
	}
	
	public static void main(String[] args) {
		ArrayList<String> possibleAnswers = new ArrayList<>();
		ArrayList<Integer> correctAnswers = new ArrayList<>();
		ArrayList<Integer> givenAnswers = new ArrayList<>();
		possibleAnswers.add("-2");
		possibleAnswers.add("2");
		possibleAnswers.add("0");
		possibleAnswers.add("3");
		correctAnswers.add(1);
		correctAnswers.add(3);
		ExamQuestionMultipleChoice m = new ExamQuestionMultipleChoice("x*x=4",10,possibleAnswers,correctAnswers);
		givenAnswers.add(1);
		givenAnswers.add(3);
		givenAnswers.add(4);
		System.out.println(m.mark(givenAnswers));
		
	}
}
