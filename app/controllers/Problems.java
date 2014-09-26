package controllers;

import functions.problems.Problem;

import java.util.*;

import models.Parameters;
import play.data.Form;
import play.mvc.*;

public class Problems extends Controller {

    public static Result show(Integer id) throws NoSuchFieldException, IllegalAccessException {
        try {
            // Dynamically instantiate problem depending on the requested id
            Problem problem;
            String problemClassName = "functions.problems.Problem" + id.toString();
            problem = (Problem) Class.forName(problemClassName).newInstance();

            // Retrieve parameters (name and value) from the query string and gives it to the instance of the problem
            final Set<Map.Entry<String,String[]>> entries = request().queryString().entrySet();
            problem.setParametersValue(entries);

            // Compute the problem's answer with the parameters from the query string
            Long answer = problem.compute();

            // Find the problem data associated to the problem id
            models.Problems problemId = models.Problems.find.byId(Long.parseLong(id.toString()));

            // Retrieve question text from database
            String question = problemId.getProblemQuestion();

            // Retrieve the list of parameters for the problem with the given id from the database
            List<models.Parameters> parameters = problemId.getParameters();
            // Replace the parameter name with parameter value from query string to adapt the text of the question
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
            // Retrieve the list of parameters for the problem with the given id from the database
            List<models.Parameters> parameters = problem.getParameters();
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

    public static Result addNew() {
        Form<models.Problems> problemsForm = Form.form(models.Problems.class);

        models.Problems newProblem = problemsForm.bindFromRequest().get();

        return ok(views.html.addProblem.render(problemsForm));
    }

    public static Result submit() {
        Form<models.Problems> problemsForm = Form.form(models.Problems.class);
        models.Problems newProblem = problemsForm.bindFromRequest().get();

        return ok ("C'est noté");
    }
}
