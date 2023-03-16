package polynomy;

public class PolynomyApp {
    public static void main(String[] args) {
        Polynom test1 = new Polynom(5); // 0. stupen
        double[] x1 = new double[] { 1, 2, 3, 6, 8 };
        Polynom test2 = new Polynom(x1);// vytvoreni z pole
        Polynom test3 = new Polynom(2, 3);// prvni stupen
        Polynom test4 = new Polynom(3, 2, 1);// druhy stupen

    }

}
