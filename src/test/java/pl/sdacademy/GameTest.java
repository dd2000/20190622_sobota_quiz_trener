package pl.sdacademy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sdacademy.model.Question;
import pl.sdacademy.service.GameInOut;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    Game game;

    Question[] questions = {
            new Question(null, null, new String[]{}, null)
    };

    @Mock
    GameInOut gameInOut;

    @Before
    public void setUp() throws Exception {
        game = new Game(gameInOut);
    }

    @Test
    public void start_should_display_welcome_message() {
        // when
        game.start(questions);

        // then
        verify(gameInOut).printLine("Witamy w grze Quiz");
        verify(gameInOut).printLine("Wprowadź numer kategorii:");
    }

    @Test
    public void start_when_category_selected_should_display_confirmation() {
        // given
        int selectedCategory = 2;
        when(gameInOut.getInt()).thenReturn(selectedCategory);

        // when
        game.start(questions);

        // then
        verify(gameInOut).printLine("wybrales "+selectedCategory);
    }

    @Test
    public void askQuestion_should_display_question() {
        // given
        String questionText = "Czy aby napewno?";
        String[] answers = {"NIE"};
        Question question = new Question(null, questionText, answers, null);
        when(gameInOut.getInt(answers.length)).thenReturn(0);

        // when
        game.askQuestion(question);

        // then
        verify(gameInOut).printLine(questionText);
    }

    @Test
    public void askQuestion_should_return_true_if_answer_is_correct() {
        // given
        String questionText = "Czy aby napewno?";
        String correctAnswer = "Tak";
        String[] answers = {"Tak", "Nie", "To zależy"};
        Question question = new Question(null, questionText, answers, correctAnswer);

        // when
        when(gameInOut.getInt(answers.length)).thenReturn(1);
        boolean result = game.askQuestion(question);

        // then
        assertTrue(result);
    }

    @Test
    public void askQuestion_should_return_true_if_answer_is_correct_and_answers_are_shuffled() {
        // given
        String questionText = "Czy aby napewno?";
        String correctAnswer = "Tak";
        String[] answers = {"Nie", "To zależy", "Tak"};
        Question question = new Question(null, questionText, answers, correctAnswer);

        // when
        when(gameInOut.getInt(answers.length)).thenReturn(3);
        boolean result = game.askQuestion(question);

        // then
        assertTrue(result);
    }

    public void askQuestion_should_return_false_if_answer_is_not_correct() {
        // given
        String questionText = "Czy aby napewno?";
        String correctAnswer = "Tak";
        String[] answers = {"Tak", "Nie", "To zależy"};
        Question question = new Question(null, questionText, answers, correctAnswer);

        // when
        when(gameInOut.getInt(answers.length)).thenReturn(1);
        boolean result = game.askQuestion(question);

        // then
        assertFalse(result);
    }
}