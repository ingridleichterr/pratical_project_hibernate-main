package menu;

import model.Customer;
import model.Room;
import util.DBUtil;

import java.text.ParseException;
import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuCustomer menuCustomer;
    private MenuGuestHouse menuGuestHouse;
    private MenuRoom menuRoom;
    private MenuMeal menuMeal;
    private MenuBooking menuBooking;

    public SubMenuOptions() {

        this.menuCustomer = new MenuCustomer();
        this.menuGuestHouse = new MenuGuestHouse();
        this.menuRoom = new MenuRoom();
        this.menuMeal = new MenuMeal();
        this.menuBooking = new MenuBooking();

    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Customer");
        System.out.println("2: Sub Menu - Guesthouse");
        System.out.println("3: Sub Menu - Rooms");
        System.out.println("4: Sub Menu - Meals");
        System.out.println("5: Sub Menu - Booking");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) throws ParseException {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuCustomer.menuChoice(input);
                    break;
                case 2:
                    this.menuGuestHouse.menuChoice(input);
                    break;
                case 3:
                    this.menuRoom.menuChoice(input);
                    break;
                case 4:
                    this.menuMeal.menuChoice(input);
                    break;
                case 5:
                    this.menuBooking.menuChoice(input);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed");
                    break;
//                default:
//                    System.out.println("\nSorry, please enter valid Option");
//                    menuChoice(input);
            }
        }
    }

}
