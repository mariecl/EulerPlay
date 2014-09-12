package controllers;

import functions.Array;
import functions.Multiples;

import play.mvc.*;

public class Problem extends Controller {

    public static Result show(Integer parameter1, Integer parameter2, Integer upperBound) {
        models.Problem problem = new models.Problem();
        problem.problemId = 001;
        problem.parameter1 = parameter1;
        problem.parameter2 = parameter2;
        problem.upperBound = upperBound;

        String question = new String("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of " + parameter1 + " or " + parameter2 + " below " + upperBound + ".");

        Multiples ans = new Multiples(upperBound);

        // Generates array of all numbers multiple of number 1 or number 2 which value is below upperBound
        int[] multiplesOfNumber1 = ans.getMultiplesBelow(upperBound, parameter1);
        int[] multiplesOfNumber2 = ans.getMultiplesBelow(upperBound, parameter2);
        int[] multiplesOfBoth = Array.MergeTables(multiplesOfNumber1, multiplesOfNumber2);

        // Sums all the elements of multiplesOfBoth to get the answer to the question
        int answer = Array.SumOfAllElements(multiplesOfBoth);

        return ok(views.html.answer.render(question, answer));
    }

}
