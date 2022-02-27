package menu;

import model.Booking;
import model.CountBooking;
import persistence.RepositoryBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Scanner;

public class MenuBooking {
    RepositoryBooking repositoryBooking = new RepositoryBooking();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Add new Booking");
        System.out.println("2: Show bookings by date ");
        System.out.println("3: Show all bookings");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) throws ParseException {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    saveNewBooking(input);
                    break;
                case 2:
                    countTotalBookingsByDate();
                    break;
                case 3:
                    //menuListAllBookings(input);
                    break;
                case 4:
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

    //case 1 add new booking
    public void saveNewBooking(Scanner input) throws ParseException {
        Booking booking = new Booking();
        System.out.println("Menu register new customer");
        System.out.print("Type number of people visiting: ");
        booking.setNumberOfPeople(input.nextInt());

        System.out.print("Type arrival date (dd/MM/yyyy): ");
        //collect date as a string
        String date= input.next();
        //format string to date
        Date date1 = new SimpleDateFormat("dd/MM/yyy").parse(date);
        //set arrival date
        booking.setArrivalDate(date1);

        System.out.print("Type leaving date (dd/MM/yyyy): ");
        //collect date as a string
        String leavingDate= input.next();
        //format string to date
        Date leavingDate1 = new SimpleDateFormat("dd/MM/yyy").parse(leavingDate);
        //set arrival date
        booking.setLeavingDate(leavingDate1);

        System.out.print("Type full name of the booker: ");
        booking.setBookerName(input.next());

        System.out.print("Type email of the booker: ");
        booking.setBookerEmail(input.next());

        System.out.print("Type phone number of the booker: ");
        booking.setBookerPhoneNumber(input.next());

        repositoryBooking.saveBooking(booking);
        System.out.println("Booking is saved successfully!" +
                "\nPlease wait for booking confirmation, " +
                "which will be sent to booker e-mail.");

    }

    //case 2 - count bookings by date
    public void countTotalBookingsByDate (){
        List<CountBooking>bookingList = repositoryBooking.bookingsByDate();
        for (CountBooking book:bookingList) {
            System.out.println(book.toString());

        }
    }
}
