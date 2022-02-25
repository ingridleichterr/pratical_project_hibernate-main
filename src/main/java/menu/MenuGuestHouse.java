package menu;


import model.Customer;
import model.GuestHouse;
import persistence.RepositoryGuestHouse;

import java.util.List;
import java.util.Scanner;

public class MenuGuestHouse {
    RepositoryGuestHouse repositoryGuestHouse = new RepositoryGuestHouse();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: See Guesthouse information");
        System.out.println("2: See Guesthouse history");
        System.out.println("3: See Guesthouse gallery");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    showGuestHouseInfo(input); //not working
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    // case 1 - show questHouse info - NOT WORKING!
    private void showGuestHouseInfo(Scanner input) {
        List<GuestHouse> guestHouseTable = repositoryGuestHouse.showGuestHouseTable();

            for (GuestHouse gh : guestHouseTable) {
                System.out.println(gh.toString());
            }

            menuOptions(input);
        }
    }

