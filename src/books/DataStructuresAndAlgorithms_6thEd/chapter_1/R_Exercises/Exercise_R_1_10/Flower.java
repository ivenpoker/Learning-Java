// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.10 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises.Exercise_R_1_10;

public class Flower {

    private String _flowerName;
    private int _numberOfPetals;
    private double _price;

    public Flower(String flowerName, int numberOfPetals, double price) {
        this._flowerName = flowerName;
        this._numberOfPetals = numberOfPetals > 0 ? numberOfPetals : 0;
        this._price = price > 0 ? price : 0;
    }

    public void setFlowerName(String newFlowerName) {
        this._flowerName = newFlowerName;
    }

    public void setNumberOfPetals(int newNumberOfPetals) {
        this._numberOfPetals = newNumberOfPetals > 0 ? newNumberOfPetals : 0;
    }

    public void setPrice(double newPrice) {
        this._price = newPrice > 0 ? newPrice : 0;
    }

    public String getFlowerName() {
        return this._flowerName;
    }

    public int getNumberOfPetals() {
        return this._numberOfPetals;
    }

    public double getPrice() {
        return this._price;
    }
}
