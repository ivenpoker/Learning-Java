package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_20;

public class AlternativeImplementation {

    public static void main(String[] args) {
        MonthSlips monthSlips = new MonthSlips(31);
        monthSlips.randomlyFillMonth();

        monthSlips.printTotalSalesByPerson();
        monthSlips.printTotalSalesByProduct();

        monthSlips.coreProcessingOfSales();
    }

}
