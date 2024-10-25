package KI304.Kozak.Lab4;

/**
 * class, that find y for x by formula: y = sin(x) / ctg(8x). Formula is simplified to y = sin(x) * tan(8x)
 */
public class EquationResolver {
    /**
     * calculate method, throw exception when x leads to infinity in calculation. for tan(8x) it's pi/16 * n, n is any odd integer
     * @param x degree
     * @return y = sin(x)/ctg(8x)
     */
    public double calculate(double x) {
        double radX = Math.toRadians(x);
        if((x % 0.5) != 0.0 && (radX/ Math.PI) % 0.0625 == 0)
            throw new InfinityException();

        double y = (Math.sin(radX) * (Math.tan(Math.toRadians(8 * x))));
        return y;
    }
}
