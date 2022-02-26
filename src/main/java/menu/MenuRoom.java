package menu;

import model.Room;
import persistence.RepositoryCustomer;
import persistence.RepositoryRoom;

import java.util.Scanner;

public class MenuRoom {

    RepositoryRoom repositoryRoom = new RepositoryRoom();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all rooms");
        System.out.println("2: List all available rooms");
        System.out.println("3: Add new room");
        System.out.println("4: Update room by room id");
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
                    //menuListAllRooms(input);
                    break;
                case 2:
                    //menuListAllAvailableRooms(input)
                    break;
                case 3:
                    menuAddNewRoom(input);
                    break;
                case 4:
                    //menuUpdateRoom
                    break;
                case 5:
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

    public void menuAddNewRoom(Scanner input){ //case3

        Room room = new Room();
        System.out.println("Menu register new room");
        System.out.println("Enter available rooms:");
        room.setAvailability(input.nextInt());

        System.out.println("Enter room price:");
        room.setPrice(input.nextInt());
        //System.out.println("Enter amount of rooms:");
        //room.setQuantity(input.nextInt());

        repositoryRoom.saveRoom(room);
        System.out.println("Room saved successfully!");
    }
}
