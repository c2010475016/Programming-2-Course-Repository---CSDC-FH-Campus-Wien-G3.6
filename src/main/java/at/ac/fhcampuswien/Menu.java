package at.ac.fhcampuswien;

public class Menu {
    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "INVALID INPUT MESSAGE";
    private static final String EXIT_MESSAGE = "EXIT MESSAGE";

    public void start() {

    }

    private void handleInput(String input) {

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
