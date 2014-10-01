package functions;

/**
 * Stores all the mathematical functions associated to the problematic of Multiples
 * used to answer the Euler problems.
 *
 * @author Marie Clemessy <marie.clemessy@gmail.com>
 *
 */


public class Multiples {
    int value;

    public Multiples (int testedNumber) {
        this.value = testedNumber;
    }

    public void setValue (int newValue) {
        this.value = newValue;
    }

    public int getValue () {
        return this.value;
    }


    /**
     * Computes all the multiples below a given number
     *
     * @param max Multiples should be below max
     *
     * @return Returns array of multiples
     */
    public int[] getMultiplesBelow (int max, int testedMultiple) {
        int[] multiples = new int[max];
        int j = 0;

        for (int i = 1; i < max; i++){
            if (i % testedMultiple == 0) {
                // Modulo = 0 then i is a multiple of the testedMultiple
                multiples[j] = i;
                j++;
            }
        }

        return multiples;
    }


    /**
     * Finds the highest prime factor of a given number through a step by step decomposition into prime numbers.
     *
     * @return Returns the highest prime factor of the given number
     */

    public static long getHighestPrimeFactor (long number) {
        long largestFactor = 0L;
        long factor = 2L;
        long remains = number;

        while (factor < remains) {
            if (remains % factor == 0) {
                remains = remains / factor;
                largestFactor = factor;
            } else {
                factor = factor + 1;
            }
        }

        if (largestFactor < remains) {
            largestFactor = remains;
        }

        return largestFactor;
    }



    /**
     * Verifies if the given number is a factor of another given number
     *
     * @return Returns true if testedMultiple is a factor of testedNumber
     */
    public static boolean isAMultiple (int testedNumber, int testedMultiple) {
        if(testedNumber % testedMultiple == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Verifies if the given number is a prime number
     *
     * @return Returns true if the given number is prime
     */
    public static boolean isPrime (int testedNumber) {
        boolean prime = true;
        for (int i = 2; i < testedNumber; i++) {
            // Tests if testedNumber has a multiple other than 1 and himself
            if (isAMultiple(testedNumber, i)){
                prime = false;
            }
        }
        return prime;
    }

}