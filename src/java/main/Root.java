package java.main;

import static java.lang.Math.*;

/**
 * Created by Valentina Shaban on 25.01.2017.
 */
public class Root {

    public static void main(String[] args) {
        double a = 1;
        double b = 11;
        double eps = 0.0001;
        double x = methodСhord(b, a, eps);
        System.out.println(x);
    }

    public static double methodСhord(double prev, double curr, double eps) {
        double next = 0;
        double tmp;
        do {
            tmp = next;
            next = curr - f(curr) * (prev - curr) / (f(prev) - f(curr));
            prev = curr;
            curr = tmp;
        } while (abs(next - curr) > eps);
        return next;
    }

    public static double methodKas(double prev, double curr, double eps) {
        double next = 0;
        double tmp;
        do {
            tmp = next;
            next = curr - f(curr) / fP(curr);
            prev = curr;
            curr = tmp;
        } while(abs(next - curr) > eps);
        return next;
    }

    public static double f(double x) {
        return log(x) - cos(x) - sqrt(x);
    }
    public static double fP(double x) { return 1 / x + sin(x) - 1 / (2 * sqrt(x)); }
}
