package controllers;

/**
 * Created by marieclemessy on 10/09/2014.
 */

import play.mvc.*;

public class ProblemList extends Controller{
    public static Result show () {
        return ok(views.html.problemlist.render());
    }
}
