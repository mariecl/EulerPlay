package controllers;

import com.avaje.ebean.Ebean;
import functions.problems.Problem;

import java.util.*;

import play.mvc.*;

public class Problems extends Controller {

    public static Result show(Integer id) throws NoSuchFieldException, IllegalAccessException {
        try {
            // Dynamically instantiate problem depending on the requested id
            Problem problem;
            String problemClassName = "functions.problems.Problem" + id.toString();
            problem = (Problem) Class.forName(problemClassName).newInstance();

            // Find the problem data associated to the problem id
            models.Problems problemId = models.Problems.find.byId(Long.parseLong(id.toString()));

            // Retrieve parameters (name and value) from the query string and gives it to the instance of the problem
            final Set<Map.Entry<String,String[]>> entries = request().queryString().entrySet();
            problem.setParametersValue(entries);

            // Compute the problem's answer with the parameters from the query string
            Long answer = problem.compute();

            // Retrieve question text from database
            String question = problemId.getProblemQuestion();

            // Retrieve from the database the list of parameters for the problem with the given id
            List<models.Parameters> parameters = Ebean.find(models.Parameters.class)
                    .where()
                    .eq("problemId", problemId.getProblemId())
                    .findList();
            // Replace parameter name with parameter value from query string to adapt the text of the question
            for (models.Parameters parameter: parameters) {
                String value = request().getQueryString(parameter.getParameterName());
                String toReplace = "%" + parameter.getParameterName() + "%";
                question = question.replace(toReplace, value);
            }
            return ok(views.html.answer.render(question, answer, parameters, id));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ok(views.html.error.render());

    }

    public static Result showList () {
        // Get the list of all available problems from database
        List<models.Problems> problems = models.Problems.find.all();

        // Generate a holder for the problems and their query string
        HashMap<models.Problems, String> queryStrings = new HashMap<models.Problems, String>();
        // Loop over problems
        for (models.Problems problem: problems) {
            // Get all parameters with the same problemId as the problem in the iterator
            List<models.Parameters> parameters = Ebean.find(models.Parameters.class)
                    .where()
                    .eq("problemId", problem.getProblemId())
                    .findList();
            String queryString = "?";
            // Generates a query string with the default values of the problem
            for (models.Parameters parameter: parameters) {
                queryString = queryString
                            + parameter.getParameterName()
                            + "=" + parameter.getParameterDefaultValue()
                            + "&";
            }
            // Add the problem and its associated query string in the holder queryStrings
            queryStrings.put(problem, queryString);
        }
        return ok(views.html.problemlist.render(problems, queryStrings));
    }

}
