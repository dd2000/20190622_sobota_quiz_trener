package pl.sdacademy;

import pl.sdacademy.model.Question;
import pl.sdacademy.model.QuestionCategory;
import pl.sdacademy.service.FileQuestionLoader;
import pl.sdacademy.service.GameInOut;
import pl.sdacademy.service.QuestionLoader;
import pl.sdacademy.service.StaticQuestionLoader;

import java.sql.Array;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // QuestionLoader questionLoader = new FileQuestionLoader(); //TODO napisac ten loader ;)

        QuestionLoader questionLoader = new StaticQuestionLoader();
        Question[] questions = questionLoader.load();
        GameInOut gameInOut = new GameInOut();

        while (true) {
            Game game = new Game(gameInOut);
            game.start(questions);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Czy chcesz kontynuowac gre?" +
                    " Wybierz [y] by kontynuować");
            String decision = scanner.nextLine();
            if (!decision.toLowerCase().equals("y")) {
                break;
            }
        }

    }
}
