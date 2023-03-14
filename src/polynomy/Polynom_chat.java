package polynomy;

public class Polynom_chat {

    private final double[] koeficienty;

    // Konstruktor pro vytvoření polynomu z pole koeficientů
    public Polynom_chat(double[] koeficienty) {
        this.koeficienty = new double[koeficienty.length];
        System.arraycopy(koeficienty, 0, this.koeficienty, 0, koeficienty.length);
    }

    // Konstruktor pro vytvoření polynomu nultého stupně (konstanty)
    public Polynom_chat(double constant) {
        this.koeficienty = new double[] { constant };
    }

    // Konstruktor pro vytvoření polynomu prvního stupně (přímky)
    public Polynom_chat(double a, double b) {
        this.koeficienty = new double[] { b, a };
    }

    // Konstruktor pro vytvoření polynomu druhého stupně
    public Polynom_chat(double a, double b, double c) {
        this.koeficienty = new double[] { c, b, a };
    }

    // Metoda pro získání stupně polynomu
    public int getDegree() {
        return this.koeficienty.length - 1;
    }

    // Metoda pro získání koeficientu na dané pozici
    public double getKoeficient(int position) {
        return this.koeficienty[position];
    }

    // Metoda pro výpočet hodnoty polynomu pomocí Hornerova schématu
    public double evaluate(double x) {
        double result = 0;
        for (int i = this.koeficienty.length - 1; i >= 0; i--) {
            result = this.koeficienty[i] + x * result;
        }
        return result;
    }

    // Metoda pro výpočet derivace polynomu
    public Polynom_chat derivace() {
        if (this.koeficienty.length == 1) {
            return new Polynom_chat(0);
        }
        double[] newkoeficienty = new double[this.koeficienty.length - 1];
        for (int i = 0; i < newkoeficienty.length; i++) {
            newkoeficienty[i] = (i + 1) * this.koeficienty[i + 1];
        }
        return new Polynom_chat(newkoeficienty);
    }

    // Metoda pro získání textového zápisu polynomu
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.koeficienty.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(this.koeficienty[i]);
            } else if (i == 1) {
                sb.append(this.koeficienty[i]).append("x + ");
            } else {
                sb.append(this.koeficienty[i]).append("x^").append(i).append(" + ");
            }
        }
        return sb.toString();

    }

    /*
     * public Polynomy(int stupen) {
     * if (stupen < 0) {
     * throw new IllegalArgumentException("stupen polynomu je mensi jak 0");
     * } else {
     * for (int i = 0; i <= stupen; i++) {
     * int temp = pascalTriangle(i, stupen);
     * this.koeficienty[i] = temp;
     * this.mocnitele[i] = stupen - i;
     * }
     * this.stupenPolynomu = stupen;
     * }
     * }
     * 
     * public int factorial(int i) {
     * if (i <= 0)
     * return 1;
     * return i * factorial(i - 1);
     * }
     * 
     * public int pascalTriangle(int n, int k) {
     * int number;
     * int nk = n - k;
     * int factN = factorial(n);
     * int factK = factorial(k);
     * int factNK = factorial(nk);
     * number = factN / (factK * factNK);
     * return number;
     * }
     */

}