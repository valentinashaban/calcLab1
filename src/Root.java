import java.text.DecimalFormat;
import static java.lang.Math.*;

public class Root {

    public static void main(String[] args) {
        double a = 1.0;
        double b = 3.0;
        double eps = 0.0001;
        double x = methodChord(a, b, eps);
        double x2 = methodKas(b, a, eps);
        System.out.println(Double.parseDouble(new DecimalFormat("##.######").format(x)));
        System.out.println(Double.parseDouble(new DecimalFormat("##.######").format(x2)));
        System.out.println(f(2.320654));
    }

    public static double methodChord(double fixEnd, double xn, double eps) {
        double xnPlus1 = 0.0;
        int count = 0;
        do {
            if (count != 0)
                xn = xnPlus1;
            xnPlus1 = xn - f(xn) * (fixEnd - xn) / (f(fixEnd) - f(xn));
            count++;
        } while (abs(xnPlus1 - xn) > eps);
        System.out.println(count);
        return xnPlus1;
    }

    public static double methodKas(double fixEnd, double xn, double eps) {
        double xnPlus1 = 0.0;
        int count = 0;
        do {
            if (count != 0)
                xn = xnPlus1;
            xnPlus1 = xn - f(xn) / fP(xn);
            count++;
        } while(abs(xnPlus1 - xn) > eps);
        System.out.println(count);
        return xnPlus1;
    }

    public static double f(double x) {
        double tmp = log(x) - cos(x) - sqrt(x);
        return tmp;
    }
    public static double fP(double x) { return 1 / x + sin(x) - 1 / (2 * sqrt(x)); }
}
