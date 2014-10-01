package functions;

/**
 * Created by marieclemessy on 09/09/2014.
 */


public class Array {

    // Computes the sum of all elements included in a given array
    public static int SumOfAllElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    // Computes the sum of all even elements included in a given array
    public static long SumOfPairElements(int[] array) {
        long sum = 0L;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i]%2 == 0){
                sum = sum + array[i];
            }
        }
        return sum;
    }

    public static int[] MergeTables (int[] tableA, int[] tableB) {
        int numberOfColumns = tableA.length + tableB.length;
        int[] merger = new int[numberOfColumns];
        for (int i = 0; i < tableA.length; i++) {
            merger[i] = tableA[i];
        }

        int k = tableA.length;
        for (int j = 0; j < tableB.length; j++) {
            int currentNumber = tableB[j];
            boolean isUnique = true;

            for (int l = 0; l < tableA.length; l++ ) {
                if (currentNumber == tableA[l]) {
                    isUnique = false;
                }
            }

            if(isUnique) {
                merger[k] = currentNumber;
                k++;
            }
        }

        return merger;
    }

    /**
     * Finds the shared elements of two arrays
     *
     * @return Returns array of shared elements
     */
    public int[] getSharedElements (int[] tableA, int[] tableB)
    {
        // Identifies the number of columns in the smallest tables between tableA and tableB
        int numberOfColumns;
        if (tableA.length < tableB.length)
        {
            numberOfColumns = tableA.length;
        }
        else
        {
            numberOfColumns = tableB.length;
        }

        // Generates an array with the number of columns of the smallest table between tableA and tableB
        int[] sharedElements = new int[numberOfColumns];

        // Verifies for each element of tableA if it is also included in table B
        for (int i = 0; i < tableA.length; i++)
        {
            for (int j = 0; j < tableB.length; j++)
            {
                if (tableA[i] == tableB[j])
                {
                    sharedElements[i] = tableA[i];
                }
            }
        }

        return sharedElements;
    }

}
