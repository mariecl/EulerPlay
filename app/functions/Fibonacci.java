package functions;

/**
 * Created by marieclemessy on 14/09/2014.
 */
public class Fibonacci {

    // Generates a table with Fibonacci
    public static int[] FibonacciSuite (int max) {
        int[] suite = new int[max];
        suite[0] = 1;
        suite[1] = 2;

        for (int i = 2; i < suite.length ; i++) {
            if (
                    suite[i-1] + suite[i-2] < max
                            && suite[i-1] > suite[i-2]
                    ) {
                suite[i] = suite[i-1] + suite[i-2];
            }
        }

        return suite;
    }
}
