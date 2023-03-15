package polynomy;

/**
 *
 * @author marts
 */
public class navrh {

    private double stupenPolynomu;
    private final double[] koeficienty;
    private double[] mocnitele;

    // zada se pouze jen stupenPolynomu polynomu a on se automaticky vytvori podle
    // pascalova
    // trojuhelniku

    public navrh(int stupen) {
        if (stupen < 0) {
            throw new IllegalArgumentException("stupen polynomu je mensi jak 0");
        } else {
            this.koeficienty = new double[stupen];
            for (int i = 0; i <= stupen; i++) {
                int temp = pascalTriangle(i, stupen);
                this.koeficienty[i] = temp;
            }
            this.stupenPolynomu = stupen;
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

    public navrh(String vzorec) {
        String[] splitedNumbers = vzorec.split(" |x^");
        this.koeficienty = new double[splitedNumbers.length / 2];
        int iMoc = 0;
        int iCisl = 0;
        double maxstupenPolynomu = 0;
        for (int i = 0; i < splitedNumbers.length; i++) {
            double temp = Integer.parseInt(splitedNumbers[i]);
            if (i % 2 == 0 || i == 0) {
                this.koeficienty[iCisl] = temp;
                iCisl++;
            } else {
                this.mocnitele[iMoc] = temp;
                iMoc++;
                if (temp > maxstupenPolynomu) {
                    maxstupenPolynomu = temp;
                }
            }
        }
        this.stupenPolynomu = maxstupenPolynomu;
    }
    // ukazkovy vstup: 5x^3 + 4x^2 - 2x^1 + 3x^0

    public double getStupenPolynomu() {
        return stupenPolynomu;
    }

    public String getString() {
        String vypis = "";
        double x = koeficienty.length;
        for (int i = 0; i < x; i++) {
            vypis += koeficienty[i] + "x^" + mocnitele[i];
        }
        return vypis;
    }
}