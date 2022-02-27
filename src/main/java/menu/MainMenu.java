package menu;

import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    private static SubMenuOptions subMenuOptions;
    private static Scanner input;

    public static void main(String[] args) throws ParseException {
        input = new Scanner(System.in).useDelimiter("\n");
        subMenuOptions = new SubMenuOptions();
        subMenuOptions.menuChoice(input);
    }

    public static void getMainMenu() throws ParseException {
        subMenuOptions.menuChoice(input);
    }
}
