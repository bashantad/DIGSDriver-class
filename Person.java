
public class Person {

    private String name;
    private String code;
    private boolean onDig;
    private int[] fieldDays = new int[3];

    public Person(String name, String code) {
        this.onDig = false;
        for (int i = 0; i < 3; i++) {
            this.fieldDays[i] = 0;
        }
        this.name = name;
        this.code = code;
    }

    public Person(String name, String code, boolean onDig, int europe, int asia, int americas) {
        this.name = name;
        this.code = code;
        this.onDig = onDig;
        this.fieldDays[0] = europe;
        this.fieldDays[1] = asia;
        this.fieldDays[2] = americas;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public boolean getOnDig() {
        return this.onDig;
    }

    public int[] getFieldDays() {
        int[] tempArray = new int[3];
        int count = 0;
        for (int var : fieldDays) {
            tempArray[count] = var;
            ++count;
        }
        return tempArray;
    }

    void changeFirstAidLevel(int newLevel) {
        this.code = Identity.updateFirstAidLevel(this.code, newLevel);
    }

    void changeLicences(String newLicences) {
        this.code = Identity.updateLicences(this.code, newLicences);
    }

    void setOnDig(boolean flag) {
        this.onDig = flag;
    }

    void addFieldDays(int index, int days) {
        this.fieldDays[index] += days;
    }

    public String toString() {
        return "name: " + this.name + " code: " + this.code + " onDig: " + this.onDig + " fields days in Europe: "
                + this.fieldDays[0] + " Asia: " + this.fieldDays[1] + " The Americas: " + this.fieldDays[2];
    }
}