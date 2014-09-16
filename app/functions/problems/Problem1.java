package functions.problems;

import functions.Multiples;
import functions.Array;
import play.Logger;

import java.lang.Class;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class Problem1 implements Problem {
	public int parameter1;
	public int parameter2;
	public int upperBound;

	//Default constructor
	public Problem1(){
        int parameter1 = 0;
        int parameter2 = 0;
        int parameter3 = 0;
	}

	//Constructor with parameters
    public Problem1(int param1, int param2, int upperBd){
        this.parameter1 = param1;
        this.parameter2 = param2;
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
        Multiples ans = new Multiples(upperBound);

        int[] multiplesOfParameter1 = ans.getMultiplesBelow(upperBound, parameter1);
        int[] multiplesOfParameter2 = ans.getMultiplesBelow(upperBound, parameter2);
        int[] multiplesOfBoth = Array.MergeTables(multiplesOfParameter1, multiplesOfParameter2);

        long answer = Array.SumOfAllElements(multiplesOfBoth);

        return answer;
	}



}