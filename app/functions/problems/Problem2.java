package functions.problems;

import functions.Array;
import functions.Fibonacci;
import play.Logger;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by marieclemessy on 14/09/2014.
 */
public class Problem2 extends ProblemBaseClass {
    public int upperBound;

    //Default constructor
    public Problem2(){
        long upperBound = 0L;
    }

    //Constructor with parameter
    public Problem2(int upperBd){
        this.upperBound = upperBd;
    }

    //Generates problem answer
    public Long compute(){
        int[] fib = Fibonacci.FibonacciSuite(upperBound);
        long answer = Array.SumOfPairElements(fib);
        return answer;
    }
}
