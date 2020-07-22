package sample;

public class Matrix {

    private double col1;
    private double col2;
    public Matrix()
    {}

        public Matrix(double col1, double col2) {
            super();
            this.col1 = col1;
            this.col2 = col2;
        }

    public double getCol1() {
            return col1;
        }
    public void setCol1(double col1) {
            this.col1 = col1;
        }

    public double getCol2() {
        return col2;
    }
    public void setCol2(double col2) {
        this.col2 = col2;
    }

}
