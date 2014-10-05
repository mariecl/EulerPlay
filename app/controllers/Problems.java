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
        return ok(views.html.notFoundPage.render(request().uri()));
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

        return ok(views.html.addProblem.render("Please fill in this form to add a new problem to the database"));
    }

    public static Result submit() {
        // Retrieve data from the request body
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        // Prepare a new problem using the request data
        models.Problems newProblem = new models.Problems();
        newProblem.setProblemName(values.get("problemName")[0]);
        newProblem.setProblemQuestion(values.get("problemQuestion")[0]);

        // Prepare a new parameter using the request data
        models.Parameters newParameter = new models.Parameters();
        newParameter.setParameterName(values.get("parameterName_1")[0]);
        newParameter.setProperName(values.get("parameterProperName_1")[0]);
        newParameter.setParameterDefaultValue(Long.parseLong(values.get("parameterDefaultValue_1")[0]));

        // Add parameter to the problem's parameter list
        List<models.Parameters> parametersList = new ArrayList<models.Parameters>();
        parametersList.add(newParameter);
        newProblem.setParameters(parametersList);

        // Save problem to the database
        newProblem.save();
        return ok(views.html.requestSuccess.render("Problem successfully added to the database"));
    }

    public static Result showListDelete() {
        // Get the list of all available problems from database
        List<models.Problems> problems = models.Problems.find.all();

        // Removes problems 1 to 3 so that they can not be deleted by the user.
        for (Long i = 1L; i < 4L; i++) {
            if (problems.contains(models.Problems.find.byId(i))) {
                problems.remove(models.Problems.find.byId(i));
            }
        }
        return ok(views.html.deleteProblem.render(problems));
    }

    public static Result delete() {
        // Retrieves the list of problems to delete from the form filled in by the user
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        // Deletes each problem which checkbox was checked by the user
        values.forEach((k, v) -> models.Problems.find.byId(Long.parseLong(k)).delete());

        // Displays a different text depending on the number of problems the user wants to delete
        String text = new String();
        if (values.size() == 0) {
            text = "No problem were removed because you didn't select any.";
        } else if (values.size() == 1) {
            text = "Problem successfully removed.";
        } else {
            text = "Problems successfully removed.";
        }
        return ok(views.html.requestSuccess.render(text));
    }

    public static Result homePage() {
        // Get the list of all available problems from database
        List<models.Problems> problems = models.Problems.find.all();
        Integer problemsNb = problems.size();
        Integer deleteNb = problemsNb - 3;
        return ok(views.html.index.render(problemsNb, deleteNb));
    }
}
