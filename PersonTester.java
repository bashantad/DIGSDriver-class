
public class PersonTester {

    public static void main(String[] args) {
        Person p1 = new Person("Richard Brin", "M321A2CR");
        System.out.println("Person1 object:" + p1);
        System.out.println("Test1: getName() should return Richard Brin");
        System.out.println("\tTest Result: " + (p1.getName().equals("Richard Brin") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test2: getCode() should return M321A2CR");
        System.out.println("\tTest Result: " + (p1.getCode().equals("M321A2CR") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test3: getOnDig() should return false");
        System.out.println("\tTest Result: " + (p1.getOnDig() == false ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test4: getFieldDays() should return starting memory address containing values of 0,0,0");
        boolean arrayCheck;
        int[] fieldDays = p1.getFieldDays();
        System.out.println("\t" + fieldDays);
        arrayCheck = (fieldDays[0] == 0 && fieldDays[1] == 0 && fieldDays[2] == 0);
        System.out.println("\tTest Result: " + (arrayCheck ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test5: changeFirstAidLevel() should change firstAidLevelcode reulting code to M321A1CR");
        p1.changeFirstAidLevel(1);
        System.out.println("\tTest Result: " + (p1.getCode().equals("M321A1CR") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test6:  changeLicences() method should change licence sets resulting code to M321A2RCH");
        p1.changeLicences("RCH");
        System.out.println("\tTest result: " + (p1.getCode().equals("M321A1RCH") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test7:  setOnDig() method should change onDig parameter to true");
        p1.setOnDig(true);
        System.out.println("\tTest result: " + (p1.getOnDig() == true ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test8:  addFieldDays() method should change number of days of europe to 2, asia to 10 and america to 9");
        p1.addFieldDays(0, 2);
        p1.addFieldDays(1, 6); //added asia twice
        p1.addFieldDays(1, 4);
        p1.addFieldDays(2, 9);
        fieldDays = p1.getFieldDays();
        arrayCheck = (fieldDays[0] == 2 && fieldDays[1] == 10 && fieldDays[2] == 9);
        System.out.println("\tTest result: " + (arrayCheck ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Person1 object after manipulation: \n\t" + p1);
        System.out.println();

        Person p2 = new Person("Jeni Jackson", "F054S0RH", true, 4, 2, 5);
        System.out.println("Person2 object when passed in second constructor: \n\t" + p2);
        System.out.println();

        System.out.println("Test 9: Person2 object: fields days should be 4 in europe 2 in asia and 5 in america");
        fieldDays = p2.getFieldDays();
        arrayCheck = (fieldDays[0] == 4 && fieldDays[1] == 2 && fieldDays[2] == 5);
        System.out.println("\tTest result: " + (arrayCheck ? "Successful" : "Failed"));
    }
}
