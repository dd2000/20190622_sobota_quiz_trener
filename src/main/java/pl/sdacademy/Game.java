package pl.sdacademy;

import pl.sdacademy.model.Question;
import pl.sdacademy.model.QuestionCategory;
import pl.sdacademy.service.GameInOut;
import pl.sdacademy.utils.ArrayUtil;

public class Game {
    GameInOut gameInOut;

    int score = 0;
    int questionsCount = 0;

    public Game(GameInOut gameInOut) {
        this.gameInOut = gameInOut;
    }

    public void start(Question[] questions) {
        gameInOut.printLine("Witamy w grze Quiz");
        gameInOut.printLine("Kategorie:");
        showCategoryList();
        gameInOut.printLine("Wprowadź numer kategorii:");
        int selectedCategory = gameInOut.getInt();

        gameInOut.printLine("wybrales " + selectedCategory);

        ArrayUtil.shuffleArray(questions); //pomieszaj pytania

        // TODO: Tylko pytania z kategori, nie wiecej niz 10;

        for (Question question : questions) {
            ArrayUtil.shuffleArray(question.getAnswers()); // pomieszaj odpowiedzi
            boolean result = askQuestion(question);
            questionsCount++;
            if (result) {
                score++;
            }
        }

        System.out.println("WYNIK: " + score + " na " + questionsCount + ".");
    }

    public boolean askQuestion(Question question) {
        gameInOut.printLine(question.getQuestion());

        String[] answers = question.getAnswers();
        for (int i = 0; i < answers.length; i++) {
            gameInOut.printLine(i + 1 + ". " + answers[i]);
        }


        try {
            String selectedAnswer = answers[gameInOut.getInt(answers.length) - 1];
            return selectedAnswer.equals(question.getCorrectAnswer());
        } catch (Exception e) {
            return false;
        }

    }

    private void showCategoryList() {
        QuestionCategory[] questionCategories = QuestionCategory.values();

        for (int i = 0; i < questionCategories.length; i++) {
            gameInOut.printLine(i + 1 + ". " + questionCategories[i]);
        }
    }
}
