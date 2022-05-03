package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {
    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "";
    private static final String EXIT_MESSAGE = "Bye bye!";

    public void start() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        handleInput(input);
    }

    private void handleInput(String input) {
        switch (input) {
            case "a" -> {
                getTopHeadlinesAustria(controller);
            }
            case "b" -> {
                getAllNewsBitcoin(controller);
            }
            case "y" -> {
                getArticleCount(controller);
            }
            case "q" -> {
                printExitMessage();
            }
        }
    }

    private void getArticleCount(AppController ctrl) {
        controller.getArticleCount();
        System.out.println("1");
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println("Austria");
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println("bitcoin");
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
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
