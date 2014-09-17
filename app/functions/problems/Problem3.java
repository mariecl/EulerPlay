package functions.problems;

import functions.Array;
import functions.Multiples;
import play.Logger;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by marieclemessy on 15/09/2014.
 */
public class Problem3 extends ProblemBaseClass {
    public long parameter1;

    //Default constructor
    public Problem3(){
        long parameter1 = 0L;
    }

    //Constructor with parameters
    public Problem3(int param1){
        this.parameter1 = param1;
    }

    //Generates problem answer
    public Long compute(){
        Long answer = Multiples.getHighestPrimeFactor(this.parameter1);
        return answer;
    }

}
