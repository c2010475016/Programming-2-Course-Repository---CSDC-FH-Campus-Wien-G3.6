package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {
    private AppController controller;
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
            default -> System.out.println(INVALID_INPUT_MESSAGE);
        }
    }

    private void getArticleCount(AppController ctrl) {

    }

    private void getTopHeadlinesAustria(AppController ctrl) {

    }

    private void getAllNewsBitcoin(AppController ctrl) {

    }

    private static void printExitMessage() {

    }

    private static void printInvalidInputMessage() {

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
