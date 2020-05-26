package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_20;

public class Slip {

    private int cnt;
    private final int salesPersonNumber;
    private final String productNumber;
    private final double totalSold;

    public enum ProductType {PROD_1, PROD_2, PROD_3, PROD_4, PROD_5};

    private final ProductType productType;

    public Slip(int salesPersonNumber, String productNumber, double totalSold, int cnt, ProductType productType) {
        this.salesPersonNumber = salesPersonNumber;
        this.productNumber = productNumber;
        this.totalSold = totalSold;
        this.cnt = cnt;
        this.productType = productType;
    }

    public int getSalesPersonNumber() {
        return this.salesPersonNumber;
    }

    public String getProductNumber() {
        return this.productNumber;
    }

    public double getTotalSold() {
        return this.totalSold;
    }

    public int getCnt() {
        return this.cnt;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    @Override
    public String toString() {
        return String.format("(%d, %s, %.1f, %s, %d)",
                this.salesPersonNumber, this.productNumber, this.totalSold,
                this.productType, this.cnt);
    }

}
