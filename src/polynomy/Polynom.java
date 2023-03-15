package polynomy;

/**
 *
 * @author marts
 */

public class Polynom {

    private final double[] koeficienty;

    // Konstruktor pro vytvoření polynomu z pole koeficientů
    public Polynom(double[] koeficienty) {
        this.koeficienty = new double[koeficienty.length];
        System.arraycopy(koeficienty, 0, this.koeficienty, 0, koeficienty.length);
    }

    // Konstruktor pro vytvoření polynomu nultého stupně (konstanty)
    public Polynom(double konstanta) {
        this.koeficienty = new double[] { konstanta };
    }

    // Konstruktor pro vytvoření polynomu prvního stupně (přímky)
    public Polynom(double a, double b) {
        this.koeficienty = new double[] { a, b };
    }

    // Konstruktor pro vytvoření polynomu druhého stupně
    public Polynom(double a, double b, double c) {
        this.koeficienty = new double[] { a, b, c };
    }

    // Metoda pro získání stupně polynomu
    public int getStupen() {
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

    // Metoda pro výpočet derivace polynomu
    public Polynom derivace() {
        if (this.koeficienty.length == 1) {
            return new Polynom(0);
        }
        double[] newKoeficienty = new double[this.koeficienty.length - 1];
        for (int i = 0; i < newKoeficienty.length; i++) {
            newKoeficienty[i] = (i + 1) * this.koeficienty[i + 1];
        }
        return new Polynom(newKoeficienty);
    }

    // zada se pouze jen stupenPolynomu polynomu a on se automaticky vytvori podle
    // pascalova
    // trojuhelniku

    public int[] autoPolynom(int stupen) {
        if (stupen < 0) {
            throw new IllegalArgumentException("stupen polynomu je mensi jak 0");
        } else {
            int[] array = new int[stupen];
            for (int i = 0; i <= stupen; i++) {
                int temp = pascalTriangle(i, stupen);
                array[i] = temp;
            }
            return array;
        }
    }

    public int factorial(int i) {
        if (i <= 0)
            return 1;
        return i * factorial(i - 1);
    }

    public int pascalTriangle(int n, int k) {
        int number;
        int nk = n - k;
        int factN = factorial(n);
        int factK = factorial(k);
        int factNK = factorial(nk);
        number = factN / (factK * factNK);
        return number;
    }

}