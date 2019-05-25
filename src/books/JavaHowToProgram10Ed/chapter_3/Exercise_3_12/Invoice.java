// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_12;

public class Invoice {

    private String _partNumber;
    private String _partDescription;
    private int _quantityPurchased;
    private double _pricePerItem;

    public Invoice(String _partNumber, String _partDescription,
                   int _quantityPurchased, double _pricePerItem) {
        this._partNumber = _partNumber;
        this._partDescription = _partDescription;
        if (_quantityPurchased > 0)
            this._quantityPurchased = _quantityPurchased;
        if (_pricePerItem > 0)
            this._pricePerItem = _pricePerItem;
    }

    public String getPartNumber() {
        return this._partNumber;
    }

    public String getPartDescription() {
        return this._partDescription;
    }

    public int getQuantityPurchased() {
        return this._quantityPurchased;
    }

    public double getPricePerItem() {
        return this._pricePerItem;
    }

    public void setPartNumber(String _newPartNumber) {
        this._partNumber = _newPartNumber;
    }

    public void setPartDescription(String _newPartDescription) {
        this._partDescription = _newPartDescription;
    }

    public void setQuantityPurchased(int _newQuantityPurchased) {
        if (_newQuantityPurchased > 0)
            this._quantityPurchased = _newQuantityPurchased;
    }
    public void setPricePerItem(double _newPricePerItem) {
        if (_newPricePerItem > 0.0)
            this._pricePerItem = _newPricePerItem;
    }
    public double getInvoiceAmount() {
        return (this._pricePerItem * this._quantityPurchased);
    }
}
