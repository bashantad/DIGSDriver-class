
import java.util.*;
import java.io.*;

public class DIGSDriver {

    private static Scanner keyboard = new Scanner(System.in);
    private RockStaff ourStaff;

    public DIGSDriver() {
        ourStaff = new RockStaff();
    }

    private void runMenu() throws IOException {
        char input;
        do {
            mainMenu();
            input = keyboard.next().trim().toUpperCase().charAt(0);
            keyboard.nextLine();
            switch (input) {
                case 'S':
                    System.out.print("Do you want to sort or search list of people? (yes/no) ");
                    String needSorting = keyboard.nextLine();
                    if (needSorting.equalsIgnoreCase("yes")) {
                        sortPeople();
                    } else if (needSorting.equalsIgnoreCase("no")) {
                        ourStaff.display();
                    }
                    break;
                case 'E':
                    runEditSubMenu();
                    break;
                case 'A':
                    addAPerson();
                    break;
                case 'R':
                    addPersonFromFile();
                    break;
                case 'C':
                    chooseGroup();
                    break;
                case 'H':
                    addDaysToFieldTrips();
                    break;
                case '?':
                    System.out.println("Time to relax?...");
                    break;
                case 'Q':
                    System.out.println("Time to go...");
                    break;
                default:
                    System.out.println("That was not a valid choice!");
            }
        } while (input != 'Q');
    }

    private void mainMenu() {
        System.out.println();
        System.out.println("********************");
        System.out.println("     DIGS ROCKS     ");
        System.out.println("********************");
        System.out.println("S) Show all persons");
        System.out.println("E) Edit submenu");
        System.out.println("A) Add a person");
        System.out.println("R) Read from file");
        System.out.println("C) Choose a group");
        System.out.println("H) Handle field days");
        System.out.println("?) Relax");
        System.out.println();
        System.out.println("Q) Quit");
        System.out.println("***********************");
        System.out.print("Please select: ");
    }

    private void runEditSubMenu() {
        char input;
        do {
            editSubMenu();
            input = keyboard.next().trim().toUpperCase().charAt(0);
            keyboard.nextLine();
            switch (input) {
                case 'F':
                    updateFirstLevel();
                    break;
                case 'L':
                    updateLicenceSets();
                    break;
                case 'E':
                    System.out.println("Exiting... up...");
                    break;
                default:
                    System.out.println("That was not a valid choice!");
            }
        } while (input != 'E');
    }

    private void editSubMenu() {
        System.out.println();
        System.out.println("**Edit Code**");
        System.out.println("F) First aid");
        System.out.println("L) Licences");
        System.out.println("E) Exit up");
        System.out.println("**************");
        System.out.print("Please select: ");
    }

    private void addAPerson() {
        System.out.printf("\tPlease enter name of the person: ");
        String name = keyboard.nextLine();
        System.out.printf("\tPlease enter code of this person: ");
        String code = keyboard.nextLine();
        ourStaff.add(name, code);
    }

    private void addPersonFromFile() throws IOException {
        System.out.print("\tPlease enter file name that contain list of people: ");
        String fileName = keyboard.nextLine();
        ourStaff.add(fileName);
    }

    private void addDaysToFieldTrips() {
        System.out.print("\tPlease enter name of the person to be modified: ");
        String name = keyboard.nextLine();
        System.out.print("\tWhose field trip needs to be extended(please enter 0 for europe, 1 for asia, 2 for americas)? ");
        int where = keyboard.nextInt();
        System.out.print("\tPlease enter number of days to be extended: ");
        int days = keyboard.nextInt();
        ourStaff.addDays(name, where, days);
    }

    private void updateFirstLevel() {
        System.out.print("\tPlease enter name of the person whose first aid level is to be modified: ");
        String name = keyboard.nextLine();
        System.out.print("\tEnter new first aid level(0 or 1 or 2): ");
        int newLevel = keyboard.nextInt();
        ourStaff.updateFirstAidLevel(name, newLevel);
    }

    private void updateLicenceSets() {
        System.out.print("\tPlease enter name of the person whose licence is to be modified: ");
        String name = keyboard.nextLine();
        System.out.print("\tEnter new licence sets of maximum 3 letters (combination of R, C and H) : ");
        String newLicenceSets = keyboard.nextLine();
        ourStaff.updateLicence(name, newLicenceSets);
    }

    private void chooseGroup() {
        System.out.print("Do you wish to nominate the area(yes/no)? ");
        String nominate = keyboard.nextLine();
        if (nominate.equalsIgnoreCase("yes")) {
            System.out.print("Please enter either Europe, Asia or The Americas: ");
            String name = keyboard.nextLine();
            if (name.equalsIgnoreCase("Europe") || name.equalsIgnoreCase("Asia") || name.equalsIgnoreCase("The Americas")) {
                ourStaff.displayFieldGroup(name);
            } else {
                System.out.println("Invalid input");
            }
        } else if (nominate.equalsIgnoreCase("no")) {
            ourStaff.displayFieldGroup();
        }
    }

    private void sortPeople() {
        char input;
        do {
            System.out.println();
            System.out.println("**Sort List of People**");
            System.out.println("N) Sort by name");
            System.out.println("G) Sort by Gender");
            System.out.println("L) Search by licence sets");
            System.out.println("M) Search by minimum number of days in field");
            System.out.println("E) Exit");
            System.out.println("**************");
            System.out.print("Please select: ");
            input = keyboard.next().trim().toUpperCase().charAt(0);
            keyboard.nextLine();
            switch (input) {
                case 'N':
                    ourStaff.sortByName();
                    ourStaff.display();
                    break;
                case 'G':
                    ourStaff.sortByGender();
                    ourStaff.display();
                    break;
                case 'L':
                    System.out.print("Enter licence sets you want to search (combination of R, C and or H): ");
                    String licenceSets = keyboard.nextLine();
                    ourStaff.filter(licenceSets.toUpperCase());
                    break;
                case 'M':
                    System.out.print("Enter minimum number of days in field trip in total(Europe + Asia + The Americas): ");
                    int numOfDays = keyboard.nextInt();
                    ourStaff.filter(numOfDays);
                    break;
                case 'E':
                    System.out.println("Exiting from search/sort....");
                    break;
                default:
                    System.out.println("That was not a valid choice!");
            }
        } while (input != 'E');
    }

    public static void main(String[] args) throws IOException {
        DIGSDriver myDriver = new DIGSDriver();
        myDriver.runMenu();
    }
}
