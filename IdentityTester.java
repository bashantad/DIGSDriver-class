
public class IdentityTester {

    public static void main(String[] args) {
        String identityCode1 = "M007V2CH", identityCode2 = "F054S0R";

        System.out.println("Test1:  getGender() method should return M");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.getGender(identityCode1));
        System.out.println("\tTest result: " + (Identity.getGender(identityCode1) == 'M' ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test2:  getGender() method should return F");
        System.out.println("\tInput: " + identityCode2 + "\tOutput: " + Identity.getGender(identityCode2));
        System.out.println("\tTest result: " + (Identity.getGender(identityCode2) == 'F' ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test3:  getIdNumber() method should return 007");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.getIdNumber(identityCode1));
        System.out.println("\tTest result: " + (Identity.getIdNumber(identityCode1).equals("007") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test4:  getIdNumber() method should return 054");
        System.out.println("\tInput: " + identityCode2 + "\tOutput: " + Identity.getIdNumber(identityCode2));
        System.out.println("\tTest result: " + (Identity.getIdNumber(identityCode2).equals("054") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test5:  getClassification() method should return V");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.getClassification(identityCode1));
        char classification = Identity.getClassification(identityCode1);
        System.out.println("\tTest result: " + (classification == 'V' ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test6:  getClassification() method should return S");
        System.out.println("\tInput: " + identityCode2 + "\tOutput: " + Identity.getClassification(identityCode2));
        classification = Identity.getClassification(identityCode2);
        System.out.println("\tTest result: " + (classification == 'S' ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test7:  getFirstAidLevel() method should return 2");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.getFirstAidLevel(identityCode1));
        System.out.println("\tTest result: " + (Identity.getFirstAidLevel(identityCode1) == 2 ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test8:  getFirstAidLevel() method should return 0");
        System.out.println("\tInput: " + identityCode2 + "\tOutput: " + Identity.getFirstAidLevel(identityCode2));
        System.out.println("\tTest result: " + (Identity.getFirstAidLevel(identityCode2) == 0 ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test9:  getLicences() method should return CH");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.getLicences(identityCode1));
        System.out.println("\tTest result: " + (Identity.getLicences(identityCode1).equals("CH") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test10:  getLicences() method should return R");
        System.out.println("\tInput: " + identityCode2 + "\tOutput: " + Identity.getLicences(identityCode2));
        System.out.println("\tTest result: " + (Identity.getLicences(identityCode2).equals("R") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test11:  updateFirstAidLevel() method should return M007V1CH when passed valid level: 1");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.updateFirstAidLevel(identityCode1, 1));
        System.out.println("\tTest result: " + (Identity.updateFirstAidLevel(identityCode1, 1).equals("M007V1CH") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test12:  updateFirstAidLevel() method should not alter original code when passed invalid level: 6");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.updateFirstAidLevel(identityCode1, 6));
        System.out.println("\tTest result: " + (!Identity.updateFirstAidLevel(identityCode1, 6).equals("M007V6CH") ? "Successful" : "Failed"));
        System.out.println();

        System.out.println("Test13:  updateLicences() method should return M007V2RCH when licence set(RCH) is passed");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.updateLicences(identityCode1, "RCH"));
        System.out.println("\tTest result: " + (Identity.updateLicences(identityCode1, "RCH").equals("M007V2RCH") ? "Successful" : "Failed"));
        System.out.println();

        String invalidInput1 = "F003";
        System.out.println("Test14: checkIdentity method should return false for invalid length of characters");
        System.out.println("\tInput: " + invalidInput1 + "\tOutput: " + Identity.checkIdentity(invalidInput1));
        System.out.println("\tTest result: " + (Identity.checkIdentity(invalidInput1) == false ? "Successful" : "Failed"));

        System.out.println("Test15:  checkIdentity() method should return true for valid length and valid characters");
        System.out.println("\tInput: " + identityCode1 + "\tOutput: " + Identity.checkIdentity(identityCode1));
        System.out.println("\tTest result: " + (Identity.checkIdentity(identityCode1) == true ? "Successful" : "Failed"));
        System.out.println();

        String invalidInput2 = "M007V2CDF";
        System.out.println("Test16:  checkIdentity() method should return false for invalid licence sets");
        System.out.println("\tInput: " + invalidInput2 + "\tOutput: " + Identity.checkIdentity(invalidInput2));
        System.out.println("\tTest result: " + (Identity.checkIdentity(invalidInput2) == false ? "Successful" : "Failed"));
        System.out.println();

        String invalidInput3 = "F007V2CCH";
        System.out.println("Test17: checkIdentity() method should return false for duplicate set of licences");
        System.out.println("\tInput: " + invalidInput3 + "\tOutput: " + Identity.checkIdentity(invalidInput3));
        System.out.println("\tTest result: " + (Identity.checkIdentity(invalidInput3) == false ? "Successful" : "Failed"));
    }
}
