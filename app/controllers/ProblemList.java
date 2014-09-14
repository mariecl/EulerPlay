package controllers;

/**
 * Created by marieclemessy on 10/09/2014.
 */

import functions.Conf;
import functions.Problem;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemList extends Controller{
    public static Result show () {
        Conf conf = new Conf();
		List<Problem> problems = Conf.getProblems();

		HashMap<Problem, String> queryStrings = new HashMap<Problem, String>();
		for (Problem problem: problems) {
			String queryString = new String("?");
			for (HashMap<String, Object> parameter: problem.parameters) {
				queryString = queryString + parameter.get("name") + "=" + parameter.get("default") + "&";
			}
			queryStrings.put(problem, queryString);
		}
        
        return ok(views.html.problemlist.render(problems, queryStrings));
    }
}
