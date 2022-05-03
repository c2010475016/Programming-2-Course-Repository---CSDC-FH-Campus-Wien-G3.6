package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {
    private final AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Invalid input!";
    private static final String EXIT_MESSAGE = "Bye";

    public void start() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        handleInput(input);
    }

    private void handleInput(String input) {
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> printInvalidInputMessage();
        }
    }

    private void getArticleCount(AppController ctrl) {
        System.out.println(ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(ctrl.getTopHeadlinesAustria());

    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println(ctrl.getAllNewsBitcoin());

    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);

    }

    private static void printMenu() {
        System.out.print("""
                **************************
                *   Welcome to NewsApp   *
                **************************


                Enter what you want to do:
                
                a: Get top headlines from Austria
                b: Get all news about bitcoin
                y: Count all articles
                q: Quit
                """);
    }
}
