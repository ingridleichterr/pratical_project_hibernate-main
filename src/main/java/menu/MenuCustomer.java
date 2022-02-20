package menu;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Customer;
import persistence.RepositoryCustomer;

public class MenuCustomer {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Add new customer ");
        System.out.println("3: List total active customers");
        System.out.println("4: List total active and not active customers");
        System.out.println("5: Update customers phone number by customer id");
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
                    menuListAllCustomers(input);
                    break;
                case 2:
                    saveNewCustomer(input);
                    break;
                case 3:
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


    //list all customers case 1
    private void menuListAllCustomers(Scanner input) {
        List<Customer> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

    //save new customer case 2
    public void saveNewCustomer(Scanner input){ //case1

        Customer customer = new Customer();
        System.out.println("Menu register new customer");
        System.out.println("Type the full name of the customer");
        customer.setName(input.next());
        System.out.println("Type the phone number");
        customer.setPhoneNumber(input.next());

        //email adding and checking if valid
        String email = null;
        boolean invalidEmail = true;
        while (invalidEmail){
            System.out.println("Type the email");
            email=input.next();
            boolean result = validateEmail(email);
            if (result){
                invalidEmail = false;
            }
        }
        customer.setEmail(input.next());

        repositoryCustomer.saveCustomer(customer);
        System.out.println("Customer saved successfully!");
    }

    //method for checking if name is entered correctly
    private boolean validateName (String name){
        return true;
    }


    //method for checking if email is entered correctly
    private boolean validateEmail (String email){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        System.out.println("Entered email is correct: " + matcher.matches());
        return matcher.matches();
    }
}
