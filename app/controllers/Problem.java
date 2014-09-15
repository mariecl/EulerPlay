package controllers;

import functions.Conf;
import functions.Problem_data;

import java.util.*;

import functions.problems.ProblemsInterface;
import play.mvc.*;

public class Problem extends Controller {

    public static Result show(Integer id) throws NoSuchFieldException, IllegalAccessException {
        //Initializes variables returned by the method
        Long answer = 0L;
        String question = "problem unavailable";

        //Dynamically instantiate problem depending on the requested id
        ProblemsInterface problem;
        String problemClassName = "functions.problems.Problem" + id.toString();
        try {

            problem = (ProblemsInterface) Class.forName(problemClassName).newInstance();

            //Sets parameter values to that of the query string
            Conf conf = new Conf();
            //Finds the problem data associated to the problem id
            Problem_data problemId = Conf.getProblems().get(id - 1);
            //Loops over each parameter recorded in JSON file
            for (HashMap<String, Object> parameter: problemId.parameters) {
                    problem.setParameterValue(parameter.get("name").toString(), Integer.parseInt(request().getQueryString(parameter.get("name").toString())));
                }

            //Computes the problem's answer with the given parameters
            answer = problem.compute();

            // Gets question text from JSON file
            String question1 = problemId.question;
            for (HashMap<String, Object> parameter: problemId.parameters) {
                String value = request().getQueryString(parameter.get("name").toString());
                String toReplace = "%" + parameter.get("name").toString() + "%";
                question1 = question1.replace(toReplace, value);
            }
            question = question1;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ok(views.html.answer.render(question, answer));
    }

    public static Result showList () {
        Conf conf = new Conf();
        List<Problem_data> problems = Conf.getProblems();

        HashMap<Problem_data, String> queryStrings = new HashMap<Problem_data, String>();
        for (Problem_data problem: problems) {
            String queryString = "?";
            for (HashMap<String, Object> parameter: problem.parameters) {
                queryString = queryString + parameter.get("name") + "=" + parameter.get("default") + "&";
            }
            queryStrings.put(problem, queryString);
        }

        return ok(views.html.problemlist.render(problems, queryStrings));
    }

}
