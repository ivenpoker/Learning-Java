// #############################################################################
// #                                                                           #
// #      Program purpose: Class Solution to Exercise 5.30 in Book             #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 5/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_30;

public class AutoPolicy {

    private int _accountNumber;
    private String _makeAndModel;
    private String _state;

    public AutoPolicy(int accountNumber, String makeAndModel,
                      String state) {
        this._accountNumber = accountNumber;
        this._makeAndModel  = makeAndModel;
        this._state = state;
    }

    public void setAccountNumber(int accountNumber) {
        this._accountNumber = accountNumber;
    }

    public int getAccoutNumber() {
        return this._accountNumber;
    }

    public void setMakeAndModel(String makeAndModel) {
        this._makeAndModel = makeAndModel;
    }

    public String getMakeAndModel() {
        return this._makeAndModel;
    }

    public void setState(String newState) {
        if (newState == "CT" || newState == "NH" || newState == "NJ"
            || newState == "NY" || newState == "PA" || newState == "VT") {
            this._state = newState;
        } else {
            System.out.printf("Invalid state");
        }
    }

    public String getState() {
        return this._state;
    }

    public boolean isNoFaultState() {
        boolean noFaultState;

        switch (this.getState()) {
            case "MA" : case "NY" : case "PA":
                noFaultState = true;
                break;
            default:
                noFaultState = false;
                break;
        }
        return noFaultState;
    }
}
