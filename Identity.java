
public class Identity {

    public static char getGender(String code) {
        return code.charAt(0);
    }

    public static String getIdNumber(String code) {
        return code.substring(1, 4);
    }

    public static char getClassification(String code) {
        return code.charAt(4);
    }

    public static int getFirstAidLevel(String code) {
        return code.charAt(5) - '0';
    }

    public static String getLicences(String code) {
        return code.substring(6);
    }

    public static String updateFirstAidLevel(String code, int newLevel) {
        if (newLevel < 0 || newLevel > 2) {
            return code;
        }

        String newCode = code.substring(0, 5)
                + newLevel
                + code.substring(6);
        return newCode;
    }

    public static String updateLicences(String code, String newLicences) {
        return code.substring(0, 6) + newLicences;
    }
}
