package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Enums.MenuLevel;

import java.util.Scanner;

public class Menu {
    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "Invalid input!";
    private static final String EXIT_MESSAGE = "Bye bye!";
    boolean isActive;
    MenuLevel menulevel = MenuLevel.Top;

    public void start() {
        controller = new AppController();
        isActive = true;
        while (isActive) {
            printMenuLevel();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            handleInput(input);
        }
    }
    private void handleInput(String input) {
        switch (menulevel) {
            case Top -> {
                handleInputTopLevel(input);
            }
            case Search -> {
                handleInputSearchLevel(input);

            }
        }
    }

    private void handleInputTopLevel(String input) {
        switch (input) {
            case "a" -> {
                getTopHeadlinesAustria(controller);
                this.menulevel = MenuLevel.Search;
            }
            case "b" -> {
                getAllNewsBitcoin(controller);
                this.menulevel = MenuLevel.Search;
            }
            case "y" -> getArticleCount(controller);
            case "q" -> handleExit();
            default -> printInvalidInputMessage();
        }
    }
    private void handleInputSearchLevel(String input) {
        switch (input) {
            case "a" -> {
                controller.providerWithMostArticles();
                this.menulevel = MenuLevel.Search;
            }
            case "b" -> {
                getAllNewsBitcoin(controller);
                this.menulevel = MenuLevel.Search;
            }
            case "c" -> printCountNewYorkTimes(controller);
            case "d" -> printHeadlineUnder15Chars(controller);
            case "q" -> this.menulevel = MenuLevel.Top;
            default -> printInvalidInputMessage();
        }
    }


    private void getArticleCount(AppController ctrl) {

        System.out.println("Amount of Articles: " + ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(ctrl.getTopHeadlinesAustria());

    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println(ctrl.getAllNewsBitcoin());
    }

    private void printCountNewYorkTimes(AppController ctrl) {
        System.out.println(ctrl.getCountOfNewYorkTimes());
    }
    private void printHeadlineUnder15Chars(AppController ctrl) {
        System.out.println(ctrl.getCountHeadlineUnder15Chars());
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);

    }

    private void handleExit() {
        printExitMessage();
        isActive = false;
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

    private static void printSearch() {
        System.out.print("""
                **************************
                *   Analysis of Results  *
                **************************


                Enter what you want to do:
                                
                a: Which provider returns most articles?
                b: Which author has the longest name?
                c: How many articles are from "New York Times"?
                d: Which articles have less than 15 characters in the Headline?
                q: Return to the Top Menu
                """);
    }

    private void printMenuLevel() {
        switch (menulevel) {
            case Top -> {
                printMenu();
            }
            case Search -> {
                printSearch();

            }
        }
    }
}



