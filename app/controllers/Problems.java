package controllers;

import functions.Conf;
import functions.Problem_data;
import functions.problems.Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import functions.problems.Problem1;
import play.data.Form;
import play.mvc.*;

public class Problems extends Controller {

    public static Result show(Integer id) throws NoSuchFieldException, IllegalAccessException {
        try {
            //Dynamically instantiate problem depending on the requested id
            Problem problem;
            String problemClassName = "functions.problems.Problem" + id.toString();
            problem = (Problem) Class.forName(problemClassName).newInstance();

            //Sets parameter values to that of the query string
            Conf conf = new Conf();

            //Finds the problem data associated to the problem id
            Problem_data problemId = Conf.getProblems().get(id - 1);

            //Gets parameters (name and value) from the query string and gives it to the instance of the problem
            final Set<Map.Entry<String,String[]>> entries = request().queryString().entrySet();
            problem.setParametersValue(entries);

            //Computes the problem's answer with the given parameters
            Long answer = problem.compute();

            // Gets question text from JSON file
            String question = problemId.question;
            // Replace parameter name with parameter value from query string to adapt the text of the question
            for (HashMap<String, Object> parameter: problemId.parameters) {
                String value = request().getQueryString(parameter.get("name").toString());
                String toReplace = "%" + parameter.get("name").toString() + "%";
                question = question.replace(toReplace, value);
            }

            return ok(views.html.answer.render(question, answer, problemId.parameters, id));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ok(views.html.error.render());

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
