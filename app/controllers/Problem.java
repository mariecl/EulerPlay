package controllers;

import functions.Array;
import functions.Multiples;
import functions.Conf;
import functions.Problem1;

import java.io.IOException;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import play.Logger;

public class Problem extends Controller {

    public static Result show(Integer id) {
        Problem1 pb1 = new Problem1();
        Class pbClass = pb1.class;

        
        
        
        Field field = pbClass.getField(name);
        field.set(pb1, value);

        // Set question parameters using values found in query string
        // To do: dynamically do the assignment
        int parameter1 = Integer.parseInt(request().getQueryString("parameter1"));
        int parameter2 = Integer.parseInt(request().getQueryString("parameter2"));
        int upperBound = Integer.parseInt(request().getQueryString("upperBound"));

        int answertest = pb1.Compute();

        String question = new String("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of " + parameter1 + " or " + parameter2 + " below " + upperBound + ".");

        Multiples ans = new Multiples(upperBound);

        // Generates array of all numbers multiple of number 1 or number 2 which value is below upperBound
        int[] multiplesOfNumber1 = ans.getMultiplesBelow(upperBound, parameter1);
        int[] multiplesOfNumber2 = ans.getMultiplesBelow(upperBound, parameter2);
        int[] multiplesOfBoth = Array.MergeTables(multiplesOfNumber1, multiplesOfNumber2);

        // Sums all the elements of multiplesOfBoth to get the answer to the question
        int answer = Array.SumOfAllElements(multiplesOfBoth);

        return ok(views.html.answer.render(question, answertest));
    }

}
