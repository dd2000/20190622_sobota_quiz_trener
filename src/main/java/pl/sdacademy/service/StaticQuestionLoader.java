package pl.sdacademy.service;

import pl.sdacademy.model.Question;
import pl.sdacademy.model.QuestionCategory;

public class StaticQuestionLoader implements QuestionLoader{

    @Override
    public Question[] load() {
        System.out.println("TO SA PRZYKLADOWE PYTANIA Z PLIKU: StaticQuestionLoader");

        return new Question[]{
                new Question(
                        QuestionCategory.HISTORIA,
                        "Zjazd w Gnieźnie odbył się w roku",
                        new String[]{"1000", "1024", "2048", "996"},
                        "1000"
                ),
                new Question(
                        QuestionCategory.FILM,
                        "Jaki zawód miał Adas miauczyński",
                        new String[]{"Nauczyciel", "Treser chomików", "Informatyk", "Pisarz"},
                        "Nauczyciel"
                ),
                new Question(
                        QuestionCategory.NAUKA,
                        "Jaką wartość ma liczba PI?",
                        new String[]{"3.14159265358", "3.14159265351", "3.14159265353", "3.14159265350"},
                        "3.14159265358"
                ),
                new Question(
                        QuestionCategory.OSOBY,
                        "Trener SDA który chciałby by Adobe FLash zastąpił JS?",
                        new String[]{"Szymon", "Grzegorz", "Maciej", "Piotr"},
                        "Szymon"
                ),
                new Question(
                        QuestionCategory.SPORT,
                        "Dokończ przysłowie: \"Sport\" to...",
                        new String[]{"zdrowie - każdy głupi Ci to powie", "zdrowie", "jest dla słabych"},
                        "zdrowie - każdy głupi Ci to powie"
                ),
        };
    }
}
