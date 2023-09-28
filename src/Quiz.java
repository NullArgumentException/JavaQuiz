/**
 * @author Stefan Schubmehl
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private Scanner sc;
    private Question[] qRange;

    public Quiz(Question[] questions, int qCount) {
        this.questions = questions;
        qRange = rndQArr(questions, qCount);
    }

    // randomize questions
    private Question[] rndQArr(Question[] questions, int qCount) {
        ArrayList<Question> qList = new ArrayList<>();
        Collections.addAll(qList, questions);
        Collections.shuffle(qList);
        int aMax = qList.size();
        if (aMax > qCount) {
            qList.subList(qCount, aMax).clear();
        }
        return qList.toArray(new Question[0]);
    }

    public void mainMenu() {
        System.out.println("---- Java Quiz ----");
        System.out.println("(S) Start (Q) Quit");
        sc = new Scanner(System.in);
        String in = sc.next();

        switch (in) {
            case "s", "S" -> startQuiz();
            case "q", "Q" -> System.exit(0);
            default -> {
                System.out.println("Unknown Input");
                wait(1000);
                mainMenu();
            }
        }
    }

    private void startQuiz() {
        int points = 0;
        for (Question q : qRange) {
            System.out.println(q);
            sc = new Scanner(System.in);
            String in = sc.next();
            if (q.getSolution().equalsIgnoreCase(in)) {
                points++;
                wait(1000);
            } else {
                System.out.println("Wrong Answer");
                System.out.println("Achieved Score: " + points);
                wait(1000);
                break;
            }
        }
        if (points == qRange.length) {
            System.out.printf("All answers (%d) are correct!\n", points);
        }
        wait(1000);
        repeatQuiz();
    }

    private void repeatQuiz() {
        System.out.println("Restart Quiz? Y/N");
        sc = new Scanner(System.in);
        String in = sc.next();

        switch (in) {
            case "y", "Y" -> {
                qRange = rndQArr(questions, 5);
                startQuiz();
            }
            case "n", "N" -> System.exit(0);
            default -> {
                System.out.println("Unknown Input");
                wait(500);
                repeatQuiz();
            }
        }
    }

    private void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
