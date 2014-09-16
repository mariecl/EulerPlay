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
public class Problem2 implements Problem {
    public int upperBound;

    //Default constructor
    public Problem2(){
        long upperBound = 0L;
    }

    //Constructor with parameter
    public Problem2(int upperBd){
        this.upperBound = upperBd;
    }

    //Gives values to the variables of the current problem instance using data from the query string
    public void setParametersValue(Set<Map.Entry<String,String[]>> entries) throws NoSuchFieldException, IllegalAccessException {
        Class prob = this.getClass();

        //Loops over the parameters found in the query string
        for (Map.Entry<String,String[]> entry : entries) {

            // Gets the name of the parameter
            final String parameterName = entry.getKey();

            // Gets the value to give to the parameter
            // Each key can have several values but we only keep the first one
            final String parameterValue = entry.getValue()[0];

            //Finds the field with the right name
            Field field = prob.getField(parameterName);

            // Attributes parameterValue to the field using parsing
            if (field.getType().getCanonicalName() == "int"){
                field.setInt(this, Integer.parseInt(parameterValue));
            } else if (field.getType().getCanonicalName() == "long") {
                field.setLong(this, Long.parseLong(parameterValue));
            }
        }
    }

    //Generates problem answer
    public Long compute(){
        int[] fib = Fibonacci.FibonacciSuite(upperBound);
        long answer = Array.SumOfPairElements(fib);
        return answer;
    }
}
