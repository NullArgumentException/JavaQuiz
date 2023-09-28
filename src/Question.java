/**
 * @author Stefan Schubmehl
 */
public class Question {
    private final String[] letters = {"A) ", "B) ", "C) ", "D) "};
    private String question;
    private String[] answers;
    private String solution;

    public Question() {
    }

    public Question(String question, String[] answers, String solution) {
        this.question = question;
        this.answers = answers;
        this.solution = solution;
    }

    @Override
    public String toString() {
        int iMax = Math.min(answers.length, letters.length);
        StringBuilder b = new StringBuilder();
        b.append(question).append("\n");
        for (int i = 0; i < iMax; i++) {
            b.append(letters[i]).append(answers[i]).append("\n");
        }
        return b.toString();
    }

    public String getSolution() {
        return solution;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}