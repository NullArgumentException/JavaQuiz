import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
/**
 * @author NullArgumentException
 */
public class Main {
    public static void main(String[] args) {
        String jsonPath = "./src/questions.json";

        try {
            File jsonFile = new File(jsonPath);

            ObjectMapper objectMapper = new ObjectMapper();

            Question[] questions = objectMapper.readValue(jsonFile, Question[].class);

            Quiz quiz = new Quiz(questions, 5);
            quiz.mainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}