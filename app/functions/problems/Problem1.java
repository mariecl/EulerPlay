package functions.problems;

import functions.Multiples;
import functions.Array;

import java.lang.Class;
import java.lang.reflect.Field;

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

    //Sets a new value to the given parameter
    public void setParameterValue(String parameter_name, int parameter_value) throws NoSuchFieldException, IllegalAccessException {
        Class prob = this.getClass();
        Field field = prob.getField(parameter_name);
        field.set(this, parameter_value);
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