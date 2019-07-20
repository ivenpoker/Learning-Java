package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_14;

public class PieceWorker extends Employee {

    private int pieceCount;
    private double wagePerPiece;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       int pieceCount, double wagePerPiece, Date birthDate) {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if (pieceCount < 0)
            throw new IllegalArgumentException("Invalid initial piece count. Must be >= 0");
        if (wagePerPiece < 0)
            throw new IllegalArgumentException("Invalid initial wage per piece. Must be >= 0");

        this.pieceCount = pieceCount;
        this.wagePerPiece = wagePerPiece;
    }

    public double getWagePerPiece() {
        return this.wagePerPiece;
    }

    public int getPieceCount() {
        return this.pieceCount;
    }

    public void setPieceCount(int pieceCount) {
        if (pieceCount < 0)
            throw new IllegalArgumentException("Invalid piece count. Must be >= 0");
        this.pieceCount = pieceCount;
    }

    public void setWagePerPiece(double wagePerPiece) {
        if (wagePerPiece < 0)
            throw new IllegalArgumentException("Invalid wage per piece. Must be >= 0");
        this.wagePerPiece = wagePerPiece;
    }

    @Override
    public double getPaymentAmount() {
        return this.getPieceCount() * this.getWagePerPiece();
    }

    @Override
    public String toString() {
        return String.format("%nPiece Worker: %sPiece count: %d%n" +
                "Wage per piece: $%.2f%n", super.toString(), this.getPieceCount(), this.getWagePerPiece());
    }
}
