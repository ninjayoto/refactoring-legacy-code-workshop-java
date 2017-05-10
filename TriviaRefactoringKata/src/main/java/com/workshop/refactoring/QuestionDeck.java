package com.workshop.refactoring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class QuestionDeck {
    private final LinkedList popQuestions;
    private final LinkedList scienceQuestions;
    private final LinkedList sportsQuestions;
    private final LinkedList rockQuestions;

    public QuestionDeck() {
        popQuestions = new LinkedList();
        scienceQuestions = new LinkedList();
        sportsQuestions = new LinkedList();
        rockQuestions = new LinkedList();
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createQuestion("Pop", i));
            scienceQuestions.addLast(createQuestion("Science", i));
            sportsQuestions.addLast(createQuestion("Sports", i));
            rockQuestions.addLast(createQuestion("Rock", i));
        }
    }

    String currentCategory(int currentPlayerPlace) {
        final List<Integer> popPlaces = Arrays.asList(0, 4, 8);
        if (popPlaces.contains(currentPlayerPlace)) return "Pop";

        final List<Integer> sciencePlaces = Arrays.asList(1, 5, 9);
        if (sciencePlaces.contains(currentPlayerPlace)) return "Science";

        final List<Integer> sportsPlaces = Arrays.asList(2, 6, 10);
        if(sportsPlaces.contains(currentPlayerPlace))return "Sports";

        final List<Integer> rockPlaces = Arrays.asList(3, 7, 11);
        if(rockPlaces.contains(currentPlayerPlace)) return "Rock";

        throw new OutOfBoardPlaceException(currentPlayerPlace);
    }

    Object askQuestion(String currentCategory) {
        if (Objects.equals(currentCategory, "Pop")) {
            final Object question = popQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Science")) {
            final Object question = scienceQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Sports")) {
            final Object question = sportsQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Rock")) {
            final Object question = rockQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        return null;
    }
}
