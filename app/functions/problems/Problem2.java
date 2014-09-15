package functions.problems;

import functions.Array;
import functions.Fibonacci;
import functions.Multiples;

import java.lang.reflect.Field;

/**
 * Created by marieclemessy on 14/09/2014.
 */
public class Problem2 implements ProblemsInterface {
    public int upperBound;

    //Default constructor
    public Problem2(){
        int upperBound = 0;
    }

    //Constructor with parameter
    public Problem2(int upperBd){
        this.upperBound = upperBd;
    }

    //Sets a new value to the given parameter
    public void setParameterValue(String parameter_name, int parameter_value) throws NoSuchFieldException, IllegalAccessException {
        Class prob = this.getClass();
        Field field = prob.getField(parameter_name);
        field.set(this, parameter_value);
    }

    //Generates problem answer
    public Long compute(){
        int[] fib = Fibonacci.FibonacciSuite(upperBound);
        long answer = Array.SumOfPairElements(fib);
        return answer;
    }
}
