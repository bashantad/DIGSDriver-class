
import java.util.*;
import java.io.*;

public class RockStaff {

    public static final int MAX_SIZE = 2000;
    private Person[] persons;  //i.e. an array of references to Person objects
    private int personCount;

    public RockStaff() {
        persons = new Person[MAX_SIZE];
        personCount = 0;
    }

    public void add(String name, String code) {
        Person newPerson = new Person(name, code);
        if (!doesNameExists(name)) {
            this.persons[this.personCount] = newPerson;
            this.personCount++;
        }
    }

    public void add(String fileName) throws IOException {
        File filePtr = new File(fileName);
        Scanner file = new Scanner(filePtr);
        String name, code;
        boolean onDig;
        int europe, asia, americas;
        while (file.hasNext()) {
            name = file.nextLine();
            if (!doesNameExists(name)) {
                code = file.nextLine();
                onDig = file.nextLine().equalsIgnoreCase("on a dig");
                europe = file.nextInt();
                asia = file.nextInt();
                americas = file.nextInt();
                file.nextLine();
                Person newPerson = new Person(name, code, onDig, europe, asia, americas);
                this.persons[this.personCount] = newPerson;
                ++this.personCount;
            }
        }
        file.close();
    }

    public void display() {
        System.out.println("List of people");
        for (int i = 0; i < this.personCount; i++) {
            System.out.println("\t" + persons[i]);
        }
    }

    public void addDays(String name, int where, int days) {
        int position = search(name);
        if (position == -1) {
            System.out.println(name + " doesn't exist in the list");
        } else {
            this.persons[position].addFieldDays(where, days);
        }
    }

    public void updateFirstAidLevel(String name, int firstAidLLevel) {
        int position = search(name);
        if (position == -1) {
            System.out.println(name + " doesn't exist in the list");
        } else {
            this.persons[position].changeFirstAidLevel(firstAidLLevel);
        }
    }

    public void updateLicence(String name, String licences) {
        int position = search(name);
        if (position == -1) {
            System.out.println(name + " doesn't exist in the list");
        } else {
            this.persons[position].changeLicences(licences);
        }
    }

    private int search(String name) {
        for (int i = 0; i < this.personCount; i++) {
            if (persons[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void displayFieldGroup() {
        System.out.println("Group members for field trips are : ");
        boolean isArchChoosen = false, isStuChoosen = false, isVolChoosen = false, iterate = true;
        char classification;
        for (int i = 0; (i < personCount) && iterate; i++) {
            if (persons[i].getOnDig() == false) {
                classification = Identity.getClassification(persons[i].getCode());
                if (!isArchChoosen && classification == 'A') {
                    persons[i].setOnDig(true);
                    System.out.println("Archaeologist: " + persons[i]);
                    isArchChoosen = true;
                }
                if (!isStuChoosen && classification == 'S') {
                    persons[i].setOnDig(true);
                    System.out.println("Student: " + persons[i]);
                    isStuChoosen = true;
                }
                if (!isVolChoosen && classification == 'V') {
                    persons[i].setOnDig(true);
                    System.out.println("Volunter: " + persons[i]);
                    isVolChoosen = true;
                }
            }
            iterate = !(isArchChoosen && isStuChoosen && isVolChoosen);
        }
        if (!isArchChoosen) {
            System.out.println("Archaeologist not found");
        }
        if (!isStuChoosen) {
            System.out.println("Student not found");
        }
        if (!isVolChoosen) {
            System.out.println("Volunteer not found");
        }
    }

    public void displayFieldGroup(String fieldArea) {
        int destination, numDays, maxStuDays = -1, maxVolDays = -1, maxArchDays = -1;
        if (fieldArea.equalsIgnoreCase("Europe")) {
            destination = 0;
        } else if (fieldArea.equalsIgnoreCase("Asia")) {
            destination = 1;
        } else {
            destination = 2;
        }
        System.out.println("Group members for field trips are : ");
        int[] fieldDest = {-1, -1, -1};
        char classification;
        for (int i = 0; i < personCount; i++) {
            classification = Identity.getClassification(persons[i].getCode());
            numDays = persons[i].getFieldDays()[destination];
            if (persons[i].getOnDig() == false) {
                switch (classification) {
                    case 'A':
                        if (maxArchDays < numDays) {
                            fieldDest[0] = i;
                            maxArchDays = numDays; // maximum archaeologist days in the given destination
                        }
                        break;
                    case 'S':
                        if (maxStuDays < numDays) {
                            fieldDest[1] = i;
                            maxStuDays = numDays;
                        }
                        break;
                    case 'V':
                        if (maxVolDays < numDays) {
                            fieldDest[2] = i;
                            maxVolDays = numDays;
                        }
                        break;
                }
            }
        }
        if (fieldDest[0] == -1) {
            System.out.println("Archaeologist not found");
        } else {
            persons[fieldDest[0]].setOnDig(true);
            System.out.println("Archaeologies: " + persons[fieldDest[0]]);
        }
        if (fieldDest[1] == -1) {
            System.out.println("Student not found");
        } else {
            persons[fieldDest[1]].setOnDig(true);
            System.out.println("Student: " + persons[fieldDest[1]]);
        }
        if (fieldDest[2] == -1) {
            System.out.println("Volunteer not found");
        } else {
            persons[fieldDest[2]].setOnDig(true);
            System.out.println("Volunteer: " + persons[fieldDest[2]]);
        }
    }

    private boolean doesNameExists(String name) {
        for (int i = 0; i < personCount; i++) {
            if (persons[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void sortByName() {
        for (int i = personCount - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (persons[j].getName().compareTo(persons[j - 1].getName()) < 0) {
                    swapPerson(j, j - 1);
                }
            }
        }
    }

    public void sortByGender() {
        sortByName();
        for (int i = personCount - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (Identity.getGender(persons[j].getCode()) < Identity.getGender(persons[j - 1].getCode())) {
                    swapPerson(j, j - 1);
                }
            }
        }
    }

    private void swapPerson(int index1, int index2) {
        Person temp = persons[index1];
        persons[index1] = persons[index2];
        persons[index2] = temp;
    }

    public void filter(String licenceSets) {
        System.out.println("List of people having licence sets of " + licenceSets);
        int[] unmatchedPerson = new int[personCount];
        int unmatchedCount = 0;
        for (int i = 0; i < personCount; i++) {
            for (char ch : licenceSets.toCharArray()) {
                if (Identity.getLicences(persons[i].getCode()).indexOf(ch) == -1) {
                    unmatchedPerson[unmatchedCount] = i;
                    unmatchedCount++;
                    break;
                }
            }
        }
        for (int i = 0; i < personCount; i++) {
            if (!checkInArray(i, unmatchedPerson, unmatchedCount)) {
                System.out.println("\t" + persons[i]);
            }
        }
    }

    private boolean checkInArray(int num, int[] array, int sizeofArray) {
        for (int i = 0; i < sizeofArray; i++) {
            if (num == array[i]) {
                return true;
            }
        }
        return false;
    }

    public void filter(int minDays) {
        System.out.println("List of people with minimu m" + minDays + " days field trip");
        int[] fieldDays = new int[3];
        for (int i = 0; i < personCount; i++) {
            fieldDays = persons[i].getFieldDays();
            if (fieldDays[0] + fieldDays[1] + fieldDays[2] >= minDays) {
                System.out.println("\t" + persons[i]);
            }
        }
    }
}
